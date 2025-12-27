package test.csv;

import libraries.csv.CsvFileBasicReader;

import java.io.IOException;

public class CsvFileBasicReaderTest {

    public static void main(String[] args) throws IOException {
        CsvFileBasicReader csvFileBasicReader = new CsvFileBasicReader();
        csvFileBasicReader.reader();
    }
}
