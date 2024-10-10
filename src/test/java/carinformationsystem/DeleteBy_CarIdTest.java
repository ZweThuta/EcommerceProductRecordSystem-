package carinformationsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteBy_CarIdTest {

    DeleteBy_CarIdTest deleteByCarId;

    @BeforeEach
    void setUp(){
        deleteByCarId = new DeleteBy_CarId();
    }

    @Test
    void test(){
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car(153, "CD-20", "Ford", 2022, 100000, "Diesal", "Manual", 20000));
        cars.add(new Car(123, "CL-10", "Lambogini", 2023, 12000, "Electric", "Automatic", 1100000));
        deleteByCarId.deleteByCarId(cars, 100);
    }
}