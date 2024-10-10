package carinformationsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WriteDataTest {
    WriteData writeData = null;

    @BeforeEach
    void setUp() {
         writeData = new WriteData();
    }

    @Test
    void writeCarsNull() {
        writeData.write(null, "data/test.csv", true);
    }

    @Test
    void writeCarElementNull() {
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(200,"29THD03","Ford",2016,200000,"Gas","Auto",40000));
        cars.add(null);
        cars.add(new Car(201,"29TYU09","Porsche",2016,30000,"Petrol","Manual",4999000));
        writeData.write(null, "data/test.csv", true);
    }
}