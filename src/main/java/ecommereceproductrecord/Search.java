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


    public boolean searchProductCategory(String productCategory, LinkedList<Transaction> productsList) {
        for (Transaction transaction : productsList) {
            if (transaction.getProductCategory().equals(productCategory)) {
                return true;
            }
        }
        return false;
    }
}