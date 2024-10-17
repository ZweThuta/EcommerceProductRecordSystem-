package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class TotalProductCountByEachUser implements SearchAndReport {
    private LinkedList<Transaction> transactions;

    public TotalProductCountByEachUser(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void searchAndReport() {
        HashMap<String, Integer> customerProductCount = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            customerProductCount.put(customerId, customerProductCount.getOrDefault(customerId, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCustomers = new ArrayList<>(customerProductCount.entrySet());
        sortedCustomers.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        AsciiTable table = new AsciiTable();
        int num = 1;
        table.addRule();
        table.addRow(Arrays.asList("No.", "Customer", "Product Count"));
        table.addRule();
        for (Map.Entry<String, Integer> list : sortedCustomers) {
            table.addRow(Arrays.asList(num, list.getKey(), list.getValue()));
            table.addRule();
            num++;
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        CSVWriteSingleton.getInstance().csvWriter("data/productCountByEachUser.csv", sortedCustomers);
    }
}
