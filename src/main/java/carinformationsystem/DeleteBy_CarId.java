package carinformationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteBy_CarId {
    public void delete(ArrayList<Car> cars){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car ID: ");
        int cID = scanner.nextInt();

        for(Car c : cars){
            if(c.getCar_id()==cID){
                cars.remove(c);
                System.out.println("Successfully deleted!!!");
                break;
            }
        }
        new WriteData().write(cars,"data/carsDataset.csv", false);
    }
}

