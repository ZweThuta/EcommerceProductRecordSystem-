package ecommereceproductrecord;

import java.util.LinkedList;

public class InsertNewTransaction {
    UserInput userInput = new UserInput();
    Search search = new Search();

    LinkedList<Transaction> transactions;

    public InsertNewTransaction(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void insertTransaction() {
        String customerId = userInput.getCustomerId();
        String transactionId = userInput.getTransactionId();
        while ((search.searchTransId(transactionId, transactions)) >= 0) {
            System.out.println("Transaction ID is already existed! Please enter again!");
            transactionId = userInput.getTransactionId();
        }
        String gender = userInput.getGender();
        String age = userInput.getAgeGroup();
        String purchaseDate = userInput.getPurchaseDate();
        String productCategory = userInput.getProductCategory();
        String discountAvailable = userInput.getDiscount();

        String discountName = null;
        String discountAmount = "0";
        String grossAmount = "0";
        if (discountAvailable.equals("Yes")) {
            discountName = userInput.getDiscountName();
            do {
                discountAmount = userInput.getDiscountAmount();
                grossAmount = userInput.getGrossAmount();
                if (Double.parseDouble(discountAmount) > Double.parseDouble(grossAmount)) {
                    System.out.println("Discount must be lower than gross amount! Please enter again.");
                }
            } while (Double.parseDouble(discountAmount) > Double.parseDouble(grossAmount));
        } else {
            grossAmount = userInput.getGrossAmount();
        }
        Double calculateNetAmount = (Double.parseDouble(grossAmount) - Double.parseDouble(discountAmount));
        String netAmount = String.valueOf(calculateNetAmount);
        String purchaseMethod = userInput.getPurchaseMethod();
        String location = userInput.getLocation();

        transactions.add(new Transaction(
                customerId,
                transactionId,
                gender,
                age,
                purchaseDate,
                productCategory,
                discountAvailable,
                discountName,
                Double.parseDouble(discountAmount),
                Double.parseDouble(grossAmount),
                Double.parseDouble(netAmount),
                purchaseMethod,
                location
        ));
        CSVWriteSingleton.getInstance().csvWriter("data/project1_df.csv", transactions, false);
        System.out.println("New record is added Successfully!");
        System.out.println();
    }
}

