package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class SortProductCategoryByNetAmount implements SearchAndReport {
    LinkedList<Transaction> transactions;
    UserInput userInput = new UserInput();

    public SortProductCategoryByNetAmount(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void searchAndReport() {
        String productCategory = userInput.getProductCategory();
        LinkedList<Transaction> foundProductCategory = new LinkedList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getProductCategory().equalsIgnoreCase(productCategory)) {
                foundProductCategory.add(transaction);
            }
        }

        if (foundProductCategory.isEmpty()) {
            System.out.println("No transactions found for the specified product category: " + productCategory);
            return;
        }

        foundProductCategory.sort(Comparator.comparing(Transaction::getNetAmount).reversed());

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(Arrays.asList("CustomerId", "TransactionId", "Gender", "Age Group",
                "Purchase Date", "Product Category", "Discount Available", "Discount Name",
                "Discount Amount", "Gross Amount", "Net Amount", "Purchase Method", "Location"));
        table.addRule();

        for (Transaction transaction : foundProductCategory) {
            List<Object> rowData = Arrays.asList(
                    transaction.getCustomerId(), transaction.getTransactionId(),
                    transaction.getGender(), transaction.getAge(),
                    transaction.getPurchaseDate(), transaction.getProductCategory(),
                    transaction.getDiscountAvailed(), transaction.getDiscountName(),
                    transaction.getDiscountAmount(), transaction.getGrossAmount(),
                    transaction.getNetAmount(), transaction.getPurchaseMethod(), transaction.getLocation()
            );
            table.addRow(rowData);
            table.addRule();
        }

        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        CSVWriteSingleton.getInstance().csvWriter("data/sortNetAmount.csv", foundProductCategory, false);
    }
}
