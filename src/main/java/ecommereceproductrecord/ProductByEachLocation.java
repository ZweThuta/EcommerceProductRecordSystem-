package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class ProductByEachLocation {
    LinkedList<Transaction> transactions = new LinkedList<>();

    public ProductByEachLocation(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void report() {
        HashMap<String, Integer> locationProductCount = new HashMap<>();

        for (Transaction transaction : transactions) {
            String location = transaction.getLocation();
            locationProductCount.put(location, locationProductCount.getOrDefault(location, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> sortedLocations = new ArrayList<>(locationProductCount.entrySet());
        sortedLocations.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        AsciiTable table = new AsciiTable();
        table.addRule();
        table.addRow("No", "Location", "Product Count");
        table.addRule();

        int num = 1;
        for (Map.Entry<String, Integer> entry : sortedLocations) {
            table.addRow(num, entry.getKey(), entry.getValue());
            table.addRule();
            num++;
        }

        LinkedList<Transaction> csvData = new LinkedList<>();
        int num1 = 1;

        for (Map.Entry<String, Integer> entry : sortedLocations) {
            String location = entry.getKey();
            int count = entry.getValue();
            table.addRow(Arrays.asList(num1, location, count));
            table.addRule();

            csvData.add(new Transaction(location, "", "", "",
                    "", "", "", "",
                    0.0, 0.0, count, "", ""));
            num1++;
        }

        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        CSVWriteSingleton.getInstance().csvWriter("data/productCountByLocation.csv", csvData, false);
    }
}
