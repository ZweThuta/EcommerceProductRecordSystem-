package carinformationsystem;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Search_Model {
    public void search(ArrayList<Car> cars){
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> data = new ArrayList<Car>();
        data = cars;
        System.out.println("Enter car model : ");
        int model = sc.nextInt();
        AsciiTable table = new AsciiTable();
        table.addRule();

        for(Car c : data){
            if(c.getModel() == model){
                List<Object> data1 = Arrays.asList(c.getCar_id(), c.getCar_number(),
                        c.getCar_name(), c.getModel(), c.getKilometer(), c.getFueltype(),
                        c.getDrivetype(), c.getPrice());

                table.addRow(data1);
                table.addRule();
            }
          else if (c.getModel()!=model){
                System.out.println("This model isn't found!");
                return;
            }
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
    }
}

