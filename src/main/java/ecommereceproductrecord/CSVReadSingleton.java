package ecommereceproductrecord;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReadSingleton {

    private static CSVReadSingleton instance = new CSVReadSingleton();

    private CSVReadSingleton() {
    }

    public static CSVReadSingleton getInstance() {
        return instance;
    }

    public LinkedList<Transaction> csvRead(String fileName) {
        LinkedList<Transaction> productsList = new LinkedList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(fileName);
            CSVReader csvReader = new CSVReader(fr);
            String[] data;

            while ((data = csvReader.readNext()) != null) {
                productsList.add(new Transaction(
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        Double.parseDouble(data[8]),
                        Double.parseDouble(data[9]),
                        Double.parseDouble(data[10]),
                        data[11],
                        data[12]
                ));
            }

            csvReader.close();
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return productsList;
    }
}
