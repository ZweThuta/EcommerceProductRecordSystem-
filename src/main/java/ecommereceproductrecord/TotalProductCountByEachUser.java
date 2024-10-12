package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class TotalProductCountByEachUser {
    private LinkedList<Transaction> transactions;

    public TotalProductCountByEachUser(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void report() {
        HashMap<String, Integer> customerProductCount = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerId = transaction.getCustomerId();
            customerProductCount.put(customerId, customerProductCount.getOrDefault(customerId, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedCustomerList = new ArrayList<>(customerProductCount.entrySet());
        sortedCustomerList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow(Arrays.asList("No", "CustomerId", "Total Products Bought"));
        table.addRule();

        LinkedList<Transaction> csvData = new LinkedList<>();
        int num = 1;

        for (Map.Entry<String, Integer> entry : sortedCustomerList) {
            String customerId = entry.getKey();
            int count = entry.getValue();
            table.addRow(Arrays.asList(num, customerId, count));
            table.addRule();

            csvData.add(new Transaction(customerId, "", "", "",
                    "", "", "", "",
                    0.0, 0.0, count, "", ""));
            num++;
        }

        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());

        CSVWriteSingleton.getInstance().csvWriter("data/totalProductByEachUser.csv", csvData, false);
    }
}
