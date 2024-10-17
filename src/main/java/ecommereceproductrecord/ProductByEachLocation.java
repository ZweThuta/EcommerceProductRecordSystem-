package ecommereceproductrecord;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.*;

public class ProductByEachLocation implements SearchAndReport {
    LinkedList<Transaction> transactions;

    public ProductByEachLocation(LinkedList<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public void searchAndReport() {
        HashMap<String, Integer> locationProductCount = new HashMap<>();

        for (Transaction transaction : transactions) {
            String location = transaction.getLocation();
            locationProductCount.put(location, locationProductCount.getOrDefault(location, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedLocations = new ArrayList<>(locationProductCount.entrySet());
        sortedLocations.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        AsciiTable table = new AsciiTable();
        int num = 1;
        table.addRule();
        table.addRow(Arrays.asList("No.", "Category", "Product Count"));
        table.addRule();
        for (Map.Entry<String, Integer> list : sortedLocations) {
            table.addRow(Arrays.asList(num, list.getKey(), list.getValue()));
            table.addRule();
            num++;
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        CSVWriteSingleton.getInstance().csvWriter("data/productCountByLocation.csv", sortedLocations);
    }
}
