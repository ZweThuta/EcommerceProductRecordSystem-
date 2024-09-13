package carinformationsystem;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
    public void write(ArrayList<Car> cars, String fname, boolean append){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fname, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);
        for(Car c : cars){
            String[] data = {String.valueOf(c.getCar_id()), c.getCar_number(),c.getCar_name(),
                    String.valueOf(c.getModel()),String.valueOf(c.getKilometer()),c.getFueltype(),
                    c.getDrivetype(),String.valueOf(c.getPrice())};

            csvWriter.writeNext(data);
        }
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

