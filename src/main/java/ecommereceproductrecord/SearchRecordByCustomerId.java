package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchRecordByCustomerId {
    LinkedList<Transaction> transactions = new LinkedList<>();
    UserInput userInput = new UserInput();
    Search search = new Search();

    public SearchRecordByCustomerId(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void search() {
        String customerId = userInput.getCustomerId();
        if (!search.searchCusId(customerId, transactions)) {
            System.out.println("This customer is not available!");
            customerId = userInput.getCustomerId();
        }
        LinkedList<Transaction> searchCustomer = new LinkedList<>();
        int found = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCustomerId().equals(customerId)) {
                searchCustomer.add(transaction);
                found++;
            }
        }
        if (found != 0) {
            System.out.println("Product Records of " + customerId);
            AsciiTable table = new AsciiTable();
            table.addRule();
            table.addRow(Arrays.asList("CustomerId", "TransactionId", "Gender", "Age Group",
                    "Purchase Date", "Product Category", "Discount Available", "Discount Name",
                    "Discount Amount", "Gross Amount", "Net Amount", "Purchase Method", "Location"));
            table.addRule();

            for (Transaction transaction : searchCustomer) {
                List<Object> searchProductRecord = Arrays.asList(
                        transaction.getCustomerId(), transaction.getTransactionId(),
                        transaction.getGender(), transaction.getAge(),
                        transaction.getPurchaseDate(), transaction.getProductCategory(),
                        transaction.getDiscountAvailed(), transaction.getDiscountName(),
                        transaction.getDiscountAmount(), transaction.getGrossAmount(),
                        transaction.getNetAmount(), transaction.getPurchaseMethod(), transaction.getLocation()
                );
                table.addRow(searchProductRecord);
                table.addRule();
            }
            table.setTextAlignment(TextAlignment.CENTER);
            System.out.println(table.render());
            CSVWriteSingleton.getInstance().csvWriter("data/searchedByCustomer.csv", searchCustomer, false);
        } else {
            System.out.println("This customer is not available!");
        }
    }
}
