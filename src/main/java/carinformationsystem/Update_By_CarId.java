package carinformationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Update_By_CarId {
    public void update(ArrayList<Car> cars){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Car ID: ");
        int cID = scanner.nextInt();
        System.out.print("Enter update price: ");
        int price = scanner.nextInt();

        for(Car c : cars){
            if(c.getCar_id()==cID){
                c.setPrice(price);
                System.out.println("Update Successful!!!");
            }
        }

        new WriteData().write(cars,"data/carsDataset.csv", false);
    }
}
