package libraries.csv;

import libraries.model.EmployeeManagement;
import lombok.extern.slf4j.XSlf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * AdvancedCsvReader.java
 * <p>
 * Advanced CSV reader using Apache Commons CSV.
 * Supports header-based parsing, UTF-8 decoding, and mapping rows to Java objects.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-28
 */
@XSlf4j
public class AdvancedCsvReader {

    // CSV File Name
    private static final String STR_CSV_FILE_NAME = "sample_csv_data.csv";

    /**
     * Reads the CSV file and maps each row to a Person object.
     *
     * @return list of Person objects parsed from the CSV
     * @throws IOException if the CSV cannot be read
     */
    public List<EmployeeManagement> readCsv() throws IOException {
        // Load the CSV file from the classpath using the class loader.
        InputStream inputStream = AdvancedCsvReader.class.getClassLoader().getResourceAsStream(STR_CSV_FILE_NAME);
        if (inputStream == null) {
            log.error("CSV resource not found: {}", STR_CSV_FILE_NAME);
            throw new IOException("CSV resource not found: " + STR_CSV_FILE_NAME);
        }

        log.info("Reading CSV file: {}", STR_CSV_FILE_NAME);

        // List of employee management records
        List<EmployeeManagement> employeeManagementsList = new ArrayList<>();

        // Initializes a BufferedReader to read the input stream using UTF-8 encoding
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
             // Configures and initializes a CSVParser with header support, trimmed fields, and ignored empty lines
             CSVParser csvParser = new CSVParser(
                     bufferedReader,
                     CSVFormat.DEFAULT
                             .builder() // - Reads from the buffered reader
                             .setHeader() // - Uses the header row as column names
                             .setSkipHeaderRecord(true) // - Skips the header record during parsing
                             .setIgnoreEmptyLines(true) // - Ignores empty lines
                             .setTrim(true) // Trims whitespace from each field
                             .build())) {
            // Processes each CSV record by mapping its fields to an EmployeeManagement object.
            // Valid records are added to the result list, while invalid ones are logged and skipped.
            csvParser.forEach(csvRecord -> {
                try {
                    EmployeeManagement employeeManagement = new EmployeeManagement();
                    employeeManagement.setId(csvRecord.get("id")); // id
                    employeeManagement.setFirstName(csvRecord.get("firstName")); // firstName
                    employeeManagement.setLastName(csvRecord.get("lastName")); // lastName
                    employeeManagement.setAge(Integer.parseInt(csvRecord.get("age"))); // age
                    employeeManagement.setDepartment(csvRecord.get("department")); // department
                    employeeManagement.setSalary(new BigDecimal(csvRecord.get("salary"))); // salary
                    employeeManagement.setStartDate(LocalDate.parse(csvRecord.get("startDate"))); // startDate
                    employeeManagement.setComment(csvRecord.get("comment")); // comment
                    employeeManagementsList.add(employeeManagement);
                    log.debug("Parsed record: {}", employeeManagement);
                } catch (Exception exception) {
                    // Warn about the invalid record and continue processing the remaining entries
                    log.warn("Skipping invalid record: {}", csvRecord, exception);
                }
            });
        } catch (IOException ioException) {
            // Logs an error message with the file name and exception details when CSV reading fails
            log.error("Error reading CSV file: {}", STR_CSV_FILE_NAME, ioException);
            throw ioException;
        }

        // Logs the count of successfully parsed records after processing the CSV file
        log.info("Successfully parsed {} records", employeeManagementsList.size());
        return employeeManagementsList;
    }
}
