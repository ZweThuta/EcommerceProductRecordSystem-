package ecommereceproductrecord;

import java.util.LinkedList;

public class UpdateRecords {
    LinkedList<Transaction> transactions = new LinkedList<>();
    UserInput userInput = new UserInput();
    Search search = new Search();

    public UpdateRecords(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void update() {
        String customerId = userInput.getCustomerId();
        String transactionId = userInput.getTransactionId();

        int transactionIndex = (search.searchTransIdAndCusId(customerId, transactionId, transactions));

        while (transactionIndex < 0) {
            System.out.println("This transaction doesn't exist!");
            customerId = userInput.getCustomerId();
            transactionId = userInput.getTransactionId();
            transactionIndex = (search.searchTransIdAndCusId(customerId, transactionId, transactions));
        }
        transactions.remove(transactionIndex);
        System.out.println("Please edit the records!");
        new InsertNewTransaction(transactions).insertTransaction();
    }
}
