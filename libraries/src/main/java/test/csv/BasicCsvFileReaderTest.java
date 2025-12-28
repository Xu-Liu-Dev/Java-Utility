package test.csv;

import libraries.csv.BasicCsvFileReader;

import java.io.IOException;

public class BasicCsvFileReaderTest {

    // Application entry point that initializes the CSV reader and triggers the CSV parsing process
    public static void main(String[] args) throws IOException {
        BasicCsvFileReader csvFileBasicReader = new BasicCsvFileReader();
        csvFileBasicReader.readCsv();
    }
}
