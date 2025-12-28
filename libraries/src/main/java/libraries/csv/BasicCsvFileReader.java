package libraries.csv;

import lombok.extern.slf4j.XSlf4j;

import java.io.*;

/**
 * CsvFileBasicReader.java
 * <p>
 * A basic utility class for reading CSV files. This class provides simple
 * methods to load CSV content from a file path or input stream and parse
 * each line into structured data.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-27
 */
@XSlf4j
public class BasicCsvFileReader {
    // CSV File Name
    private static final String STR_CSV_FILE_NAME = "csv/sample_csv_data.csv";
    // CSV delimiter
    private static final String STR_DELIMITER = ",";

    /**
     * Reads the CSV file bundled in the application's classpath.
     * <p>
     * The method opens the CSV resource as an InputStream, wraps it in a BufferedReader,
     * and iterates through each line. Each line is split using the predefined delimiter
     * and can be further processed as needed by the caller.
     * </p>
     *
     * @throws IOException if the CSV file cannot be accessed or an I/O error occurs during reading
     */
    public void readCsv() throws IOException {
        // Lines read from the file
        String strLine;

        // Load the CSV file from the classpath using the class loader.
        InputStream inputStream = BasicCsvFileReader.class
                .getClassLoader()
                .getResourceAsStream(STR_CSV_FILE_NAME);

        // Validate that the CSV resource exists on the classpath.
        // If not found, log the error and throw an exception to prevent further processing.
        if (inputStream == null) {
            log.error("Can't find resource: " + STR_CSV_FILE_NAME);
            throw new FileNotFoundException("Resource file not found: " + STR_CSV_FILE_NAME);
        }

        // Reads the CSV content line by line from the InputStream.
        // Each line is split into fields using the configured delimiter.
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] values = strLine.split(STR_DELIMITER);
                // Output each parsed field for debugging or inspection.
                for (String value : values) {
                    System.out.print(value + "|");
                }
                System.out.println();
            }
        } catch (IOException fileNotFoundException) {
            // Wrap and rethrow the exception if the specified file does not exist.
            log.error("Failed to read CSV file: {}", STR_CSV_FILE_NAME, fileNotFoundException);
            throw new RuntimeException(fileNotFoundException);
        }
    }
}