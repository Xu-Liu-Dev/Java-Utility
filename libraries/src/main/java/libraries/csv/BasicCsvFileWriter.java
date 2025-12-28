package libraries.csv;

import libraries.model.EmployeeManagement;
import lombok.extern.slf4j.XSlf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * BasicCsvFileWriter.java
 *
 * <p>
 * Handles CSV file generation and writing operations.
 * This class encapsulates the logic required to output structured data
 * into CSV format using standard I/O mechanisms.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-28
 */
@XSlf4j
public class BasicCsvFileWriter {

    /**
     * Writes employee data to a CSV file at the specified location.
     *
     * @param filePath  path to the output CSV file
     * @param employees list of employees to write
     * @throws IOException if writing to the file fails
     */
    public void writeCsv(String filePath, List<EmployeeManagement> employees) throws IOException {
        // Creates a UTF-8 encoded BufferedWriter for writing content to the specified file path
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8));
             // Constructs a CSVPrinter instance using the provided writer and a CSV format
             // that includes a header row and automatic trimming of values
             CSVPrinter csvPrinter = new CSVPrinter(bufferedWriter,
                     CSVFormat.DEFAULT
                             .builder()
                             .setHeader("id", "firstName", "lastName", "age", "department", "salary", "startDate", "comment")
                             .setTrim(true)
                             .build())) {
            // Processes each employee entry and writes a corresponding CSV record,
            // converting any I/O errors into unchecked exceptions
            employees.forEach(employee -> {
                try {
                    csvPrinter.printRecord(
                            employee.getId(),
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getAge(),
                            employee.getSalary(),
                            employee.getDepartment(),
                            employee.getStartDate(),
                            employee.getComment());
                } catch (IOException ioException) {
                    log.error("Error writing CSV file: {}", filePath, ioException);
                    throw new RuntimeException(ioException);
                }
            });
        }
    }
}
