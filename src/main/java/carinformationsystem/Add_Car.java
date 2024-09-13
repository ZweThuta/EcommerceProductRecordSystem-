package carinformationsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Add_Car {
    public void add(ArrayList<Car> cars) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> data = new ArrayList<Car>();
        data = cars;
        System.out.print("Enter Car ID: ");
        int car_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Car Number: ");
        String car_number = sc.nextLine();
        sc.nextLine();
        System.out.print("Enter Car Name: ");
        String car_name = sc.nextLine();
        System.out.print("Enter Car Model: ");
        int model = sc.nextInt();
        System.out.print("Enter Kilometer: ");
        int kilometer = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Fuel Type: ");
        String fueltype = sc.nextLine();
        sc.nextLine();
        System.out.print("Enter Drive Type: ");
        String drivetype = sc.nextLine();
        System.out.print("Enter Price: ");
        int price = sc.nextInt();

        cars.add(new Car(car_id, car_number, car_name, model, kilometer, fueltype, drivetype, price));
        new WriteData().write(cars,"data/carsDataset.csv", true);
    }
}





