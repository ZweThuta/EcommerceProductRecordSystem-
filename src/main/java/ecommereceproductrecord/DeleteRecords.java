package ecommereceproductrecord;

import java.util.LinkedList;

public class DeleteRecords {
    LinkedList<Transaction> transactions = new LinkedList<>();
    UserInput userInput = new UserInput();
    Search search = new Search();

    public DeleteRecords(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void delete() {
        String customerId = userInput.getCustomerId();
        String transactionId = userInput.getTransactionId();

        int transactionIndex = (search.searchTransIdAndCusId(customerId, transactionId, transactions));

        while (transactionIndex < 0) {
            System.out.println("This transaction doesn't exist!");
            customerId = userInput.getCustomerId();
            transactionId = userInput.getTransactionId();
        }
        transactions.remove(transactionIndex);

        CSVWriteSingleton.getInstance().csvWriter("data/project1_df.csv", transactions, false);
        System.out.println("Record is deleted Successfully!");
    }
}
