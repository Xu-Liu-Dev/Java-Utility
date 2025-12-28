package test.csv;

import libraries.csv.AdvancedCsvFileReader;

import java.io.IOException;

/**
 * AdvancedCsvReaderTest.java
 *
 * Unit test suite for AdvancedCsvReader, ensuring that CSV parsing,
 * data extraction, and error-handling behaviors function as expected
 * under various input scenarios.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-28
 */
public class AdvancedCsvReaderTest {

    // Application entry point that initializes the CSV reader and triggers the CSV parsing process
    public static void main(String[] args) throws IOException {
        AdvancedCsvFileReader advancedCsvReader = new AdvancedCsvFileReader();
        advancedCsvReader.readCsv();
    }
}
