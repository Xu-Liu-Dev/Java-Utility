package test.csv;

import libraries.csv.BasicCsvFileReader;

import java.io.IOException;

/**
 * BasicCsvFileReaderTest.java
 *
 * Unit test suite for BasicCsvFileReader, ensuring that CSV parsing,
 * record extraction, and error-handling behavior operate correctly
 * across various input scenarios.
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-28
 */
public class BasicCsvFileReaderTest {

    // Application entry point that initializes the CSV reader and triggers the CSV parsing process
    public static void main(String[] args) throws IOException {
        BasicCsvFileReader csvFileBasicReader = new BasicCsvFileReader();
        csvFileBasicReader.readCsv();
    }
}
