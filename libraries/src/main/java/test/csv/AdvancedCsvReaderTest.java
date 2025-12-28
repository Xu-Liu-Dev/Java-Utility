package test.csv;

import libraries.csv.AdvancedCsvReader;

import java.io.IOException;

public class AdvancedCsvReaderTest {

    // Application entry point that initializes the CSV reader and triggers the CSV parsing process
    public static void main(String[] args) throws IOException {
        AdvancedCsvReader advancedCsvReader = new AdvancedCsvReader();
        advancedCsvReader.readCsv();
    }
}
