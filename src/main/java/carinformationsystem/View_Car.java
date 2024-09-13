package carinformationsystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class View_Car {
    public void view(ArrayList<Car> cars){
        ArrayList<Car> data = new ArrayList<Car>();
        data = cars;
        AsciiTable table = new AsciiTable();
        table.addRule();
        for(Car c : data){
            List<Object> data1 = Arrays.asList(c.getCar_id(), c.getCar_number(),
                    c.getCar_name(), c.getModel(), c.getKilometer(), c.getFueltype(),
                    c.getDrivetype(), c.getPrice());

            table.addRow(data1);
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
    }
}
