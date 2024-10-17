package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchRecordByProductCategory implements SearchAndReport {
    LinkedList<Transaction> transactions;
    UserInput userInput = new UserInput();
    Search search = new Search();

    public SearchRecordByProductCategory(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void searchAndReport() {
        String productCategory = userInput.getProductCategory();
        if (!search.searchProductCategory(productCategory, transactions)) {
            System.out.println("This product category is not available!");
            productCategory = userInput.getProductCategory();
        }
        LinkedList<Transaction> searchProductCategory = new LinkedList<>();
        int found = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getProductCategory().equals(productCategory)) {
                searchProductCategory.add(transaction);
                found++;
            }
        }

        if (found != 0) {
            AsciiTable table = new AsciiTable();
            table.addRule();
            table.addRow(Arrays.asList("CustomerId", "TransactionId", "Gender", "Age Group",
                    "Purchase Date", "Product Category", "Discount Available", "Discount Name",
                    "Discount Amount", "Gross Amount", "Net Amount", "Purchase Method", "Location"));
            table.addRule();

            for (Transaction transaction : searchProductCategory) {
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
            CSVWriteSingleton.getInstance().csvWriter("data/searchByCategory.csv", searchProductCategory, false);
        } else {
            System.out.println("This product category is not available!");
        }
    }
}
