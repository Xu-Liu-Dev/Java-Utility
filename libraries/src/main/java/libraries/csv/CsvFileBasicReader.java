package libraries.csv;

import java.io.*;

/**
 * CsvFileBasicReader
 * <p>
 * A basic utility class for reading CSV files. This class provides simple
 * methods to load CSV content from a file path or input stream and parse
 * each line into structured data.
 *
 * <p>Typical usage:
 * <pre>
 *     CsvFileBasicReader reader = new CsvFileBasicReader();
 *     List<String[]> rows = reader.read("data.csv");
 * </pre>
 *
 * @author Xu
 * @version 1.0
 * @since 2025-12-27
 */
public class CsvFileBasicReader {
    // CSV File Name
    private static String strCsvFIleName = "sample_csv_data.csv";
    // CSV delimiter
    private static String strDelimiter = ",";
    // Lines read from the file
    private static String strLine;

    public static void main(String[] args) {
        // Load the CSV file from the classpath using the class loader.
        InputStream inputStream = CsvFileBasicReader.class
                .getClassLoader()
                .getResourceAsStream(strCsvFIleName);
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
        } catch (FileNotFoundException fileNotFoundException) {
            // Wrap and rethrow the exception if the specified file does not exist.
            throw new RuntimeException(fileNotFoundException);
        } catch (IOException ioException) {
            // Wrap and rethrow any I/O-related exceptions that occur during processing.
            throw new RuntimeException(ioException);
        }
    }
}