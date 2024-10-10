package ecommereceproductrecord;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Search {

    public int searchTransIdAndCusId(String customerId, String transactionId, LinkedList<Transaction> productsList) {
        int index = 0;
        for (Transaction transaction : productsList) {
            if (transaction.getCustomerId().equals(customerId) && transaction.getTransactionId().equals(transactionId)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public boolean searchCusId(String customerId, LinkedList<Transaction> productsList) {
        int index = 0;
        for (Transaction transaction : productsList) {
            if (transaction.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public int searchTransId(String transactionId, LinkedList<Transaction> productsList) {
        int index = 0;
        for (Transaction transaction : productsList) {
            if (transaction.getTransactionId().equals(transactionId)) {
                return index;
            }
            index++;
        }
        return -1;
    }


    public boolean searchProductCategory(LinkedList<Transaction> productsList, String productCategory) {
        for (Transaction transaction : productsList) {
            if (transaction.getProductCategory().equals(productCategory)) {
                return true;
            }
        }
        return false;
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
}
