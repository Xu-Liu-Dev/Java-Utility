package test.csv;

import libraries.constant.FileConstants;
import libraries.csv.BasicCsvFileWriter;
import libraries.model.EmployeeManagement;
import lombok.extern.slf4j.XSlf4j;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

/**
 * BasicCsvWriterTest.java
 *
 * <p>
 * Unit test class responsible for validating the behavior of BasicCsvFileWriter,
 * ensuring that CSV files are generated and written correctly under various conditions.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-28
 */
@XSlf4j
public class BasicCsvWriterTest {

    // Application entry point that initializes the CSV writer and triggers the CSV parsing process
    public static void main(String[] args) throws IOException {
        // Instantiate the CSV writer responsible for generating and writing CSV files
        BasicCsvFileWriter basicCsvFileWriter = new BasicCsvFileWriter();
        // Obtain the application's working directory using the 'user.dir' system property
        String basePath = System.getProperty("user.dir");

        // Initialize a test dataset by creating a mock EmployeeManagement instance
        // and adding it to the employee list for CSV generation validation
        List<EmployeeManagement> employeesManagementList = List.of(EmployeeManagement.builder()
                .id("1")
                .firstName("John")
                .lastName("Doe")
                .age(30)
                .department("Manager")
                .salary(new BigDecimal(59000))
                .startDate(LocalDate.parse("2025-02-17"))
                .comment("backend engineer").build());

        // Execute the CSV writing operation, combining the base path and file name to produce the final output location
        basicCsvFileWriter.writeCsv(basePath + FileConstants.CSV_OUTPUT_FILE_NAME, employeesManagementList);
        log.info("EmployeeManagement CSV file has been successfully generated.");
    }
}
