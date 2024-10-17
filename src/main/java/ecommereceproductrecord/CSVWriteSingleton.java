package ecommereceproductrecord;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CSVWriteSingleton {

    private static CSVWriteSingleton instance = new CSVWriteSingleton();

    public CSVWriteSingleton() {
    }

    public static CSVWriteSingleton getInstance() {
        return instance;
    }

    public static void setInstance(CSVWriteSingleton instance) {
        CSVWriteSingleton.instance = instance;
    }

    public void csvWriter(String fileName, LinkedList<Transaction> productList, boolean append) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        for (Transaction product : productList) {
            String[] data = {
                    product.getCustomerId(),
                    product.getTransactionId(),
                    product.getGender(),
                    product.getAge(),
                    product.getPurchaseDate(),
                    product.getProductCategory(),
                    product.getDiscountAvailed(),
                    product.getDiscountName(),
                    Double.toString(product.getDiscountAmount()),
                    Double.toString(product.getGrossAmount()),
                    Double.toString(product.getNetAmount()),
                    product.getPurchaseMethod(),
                    product.getLocation()
            };
            csvWriter.writeNext(data);
        }
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void csvWriter(String fileName, List<Map.Entry<String, Integer>> productList) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        for (Map.Entry<String, Integer> entry : productList) {
            String[] data = {
                    entry.getKey(),
                    Integer.toString(entry.getValue())
            };
            csvWriter.writeNext(data);
        }
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
