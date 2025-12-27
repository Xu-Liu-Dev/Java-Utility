package libraries.csv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * CsvFileBasicReader
 * <p>
 * A basic utility class for reading CSV files. This class provides simple
 * methods to load CSV content from a file path or input stream and parse
 * each line into structured data.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-27
 */
public class CsvFileBasicReader {
    // CSV File Name
    private static final String strCsvFIleName = "sample_csv_data.csv";
    // CSV delimiter
    private static final String strDelimiter = ",";

    // Logger instance for recording application events, errors, and debugging information.
    private static final Logger log = LoggerFactory.getLogger(CsvFileBasicReader.class);

    public void reader() throws IOException {
        // Lines read from the file
        String strLine;

        // Load the CSV file from the classpath using the class loader.
        InputStream inputStream = CsvFileBasicReader.class
                .getClassLoader()
                .getResourceAsStream(strCsvFIleName);

        // Validate that the CSV resource exists on the classpath.
        // If not found, log the error and throw an exception to prevent further processing.
        if (inputStream == null) {
            log.error("Can't find resource: " + strCsvFIleName);
            throw new FileNotFoundException("Resource file not found: " + strCsvFIleName);
        }

        // Reads the CSV content line by line from the InputStream.
        // Each line is split into fields using the configured delimiter.
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] values = strLine.split(strDelimiter);
                // Output each parsed field for debugging or inspection.
                for (String value : values) {
                    System.out.print(value + "|");
                }
                System.out.println();
            }
        } catch (IOException fileNotFoundException) {
            // Wrap and rethrow the exception if the specified file does not exist.
            log.error("Failed to read CSV file: {}", strCsvFIleName, fileNotFoundException);
            throw new RuntimeException(fileNotFoundException);
        }
    }
}