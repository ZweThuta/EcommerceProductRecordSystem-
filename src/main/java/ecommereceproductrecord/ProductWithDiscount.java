package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductWithDiscount implements SearchAndReport {
    LinkedList<Transaction> transactions = new LinkedList<>();

    public ProductWithDiscount(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void searchAndReport() {
        LinkedList<Transaction> discountProduct = new LinkedList<>();

        for (Transaction transaction : transactions) {
            if (transaction.getDiscountAvailed().equals("Yes")) {
                discountProduct.add(transaction);
            }
        }
        discountProduct.sort(Comparator.comparing(Transaction::getProductCategory));

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(Arrays.asList("CustomerId", "TransactionId", "Gender", "Age Group",
                "Purchase Date", "Product Category", "Discount Available", "Discount Name",
                "Discount Amount", "Gross Amount", "Net Amount", "Purchase Method", "Location"));
        table.addRule();

        for (Transaction transaction : discountProduct) {
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
        CSVWriteSingleton.getInstance().csvWriter("data/discountProductList.csv", discountProduct, false);
    }
}
