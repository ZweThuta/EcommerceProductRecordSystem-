package carinformationsystem;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    ArrayList<Car> cars = new ArrayList<Car>();
    Scanner sc = new Scanner(System.in);

    void menu(){
        System.out.println("Welcome to Our Car Information System ");
        System.out.println("======================================");
        System.out.println("1. Menu");
        System.out.println("2. View All Car Information");
        System.out.println("3. Add New Car");
        System.out.println("4. Update Price By Car ID");
        System.out.println("5. Delete By Car ID");
        System.out.println("6. Search By Car Model");
        System.out.println("7. Exit");
        System.out.print("Choose Option: ");

    }
    private boolean is_Menu_Range(String input){
        List<String> menu_number = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        return menu_number.contains(input);
    }
    void display(){
        menu();
        String input = sc.nextLine();
        while(!is_Menu_Range(input)){
            System.out.println("Enter menu between 1 to 7");
            input = sc.nextLine();
        }
        switch (input){
            case "1" : {
                display();
                break;
            }
            case "2" : {
                cars = new ArrayList<Car>();
                cars = dataRead("data/carsDataset.csv");
                new View_Car().view(cars);
                display();
                break;
            }
            case "3" : {
//                cars = dataRead("data/carsDataset.csv");
                cars = new ArrayList<Car>();
                new Add_Car().add(cars);
                new View_Car().view(cars);
                display();
                break;
            }
            case "4" : {
                cars = new ArrayList<Car>();
                cars = dataRead("data/carsDataset.csv");
                new Update_By_CarId().update(cars);
                display();
                break;
            }
            case "5" : {
                cars = new ArrayList<Car>();
                cars = dataRead("data/carsDataset.csv");
                new DeleteBy_CarId().delete(cars);
                display();
                break;
            }
            case "6" : {
                cars = new ArrayList<Car>();
                cars = dataRead("data/carsDataset.csv");
                new Search_Model().search(cars);
                display();
                break;
            }
        }
    }
    private ArrayList<Car> dataRead(String filename){
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(reader);
        String[] str;
        while (true){
            try {
                if (!((str = csvReader.readNext()) !=null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            cars.add(new Car(Integer.parseInt(str[0]),
                    str[1], str[2], Integer.parseInt(str[3]),
                    Integer.parseInt(str[4]), str[5], str[6],
                    Integer.parseInt(str[7])));

        }
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.display();
    }
}

