package libraries.csv;

import java.io.*;

public class CsvFileBasicReader {
    public static void main(String[] args) {
        String strCsvFIleName = "sample_csv_data.csv";
        String strLine;
        String strDelimiter = ",";

        InputStream inputStream = CsvFileBasicReader.class
                .getClassLoader()
                .getResourceAsStream(strCsvFIleName);

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((strLine = bufferedReader.readLine()) != null) {
                String[] values = strLine.split(strDelimiter);
                for (String value : values) {
                    System.out.println(value + "|");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}