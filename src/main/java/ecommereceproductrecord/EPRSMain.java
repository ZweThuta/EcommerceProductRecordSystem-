package ecommereceproductrecord;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EPRSMain extends MenuMethods {
    LinkedList<Transaction> productsList = new LinkedList<Transaction>();
    Scanner sc = new Scanner(System.in);

    public void menu() {
        System.out.println("Welcome to Ecommerce Product Record Program ");
        System.out.println("_____________________________________________");
        System.out.println("1. Menu");
        System.out.println("2. Adding new product data to the csv file.");
        System.out.println("3. Updating the existing product record data.");
        System.out.println("4. Deleting the existing product");
        System.out.println("5. Search the product record data according to either product name or customer id.");
        System.out.println("6. All the product category sorting in net amount from the highest to the lowest.");
        System.out.println("7. List of the product according to the category.");
        System.out.println("8. Total number of product bought by each user sorting by the most product counts.");
        System.out.println("9. List of the product with discount availed “Yes” with sort by product category.");
        System.out.println("10. Product Category Count In Each Location.");
        System.out.println("11. Exit");
        System.out.print("Choose Option: ");
    }

    private boolean menuNumber(String input) {
        List<String> menu_number = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");
        return menu_number.contains(input);
    }

    protected void displayMenu() {
        menu();
        String input = sc.nextLine();
        while (!menuNumber(input)) {
            System.out.println("Enter number between 1 to 11");
            input = sc.nextLine();
        }
        switch (input) {
            case "1": {
                displayMenu();
                break;
            }
            case "2": {
                System.out.println("Adding new record");
                insert();
                break;
            }
            case "3": {
                System.out.println("Update record");
                update();
                break;
            }
            case "4": {
                System.out.println("Deleting record");
                delete();
                break;
            }
            case "5": {
                System.out.println("Search");
                displayMenu();
                break;
            }
            case "6": {
                System.out.println("Sort");
                displayMenu();
                break;
            }
            case "7": {
                System.out.println("List Product");
                displayMenu();
                break;
            }
            case "8": {
                System.out.println("User Sort");
                displayMenu();
                break;
            }
            case "9": {
                System.out.println("Discount Yes");
                displayMenu();
                break;
            }
            case "10": {
                System.out.println("Product Category Count by Location");
                // Add method to show category count
                break;
            }
            case "11": {
                System.out.println("Exiting the program.");
                return;
            }
            default: {
                System.out.println("Invalid input.");
                break;
            }
        }
    }

    @Override
    public void insert() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        new InsertNewTransaction(productsList).insertTransaction();
        displayMenu();
    }

    @Override
    public void update() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        new UpdateRecords(productsList).update();
        displayMenu();
    }

    @Override
    public void delete() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        new DeleteRecords(productsList).delete();
        displayMenu();
    }

    public void dataRead(String fname) {
        FileReader fr = null;
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fr);
        String data[];
        while (true) {
            try {
                if (!((data = csvReader.readNext()) != null)) break;
            } catch (IOException e) {

                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            productsList.add(new Transaction(data[0], data[1], data[2], data[3], data[4],
                    data[5], data[6], data[7], Double.parseDouble(data[8]),
                    Double.parseDouble(data[9]), Double.parseDouble(data[10]), data[11], data[12]));
        }
        try {
            csvReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EPRSMain eprsMain = new EPRSMain();
        eprsMain.dataRead("data/project1_df.csv");
        System.out.println(eprsMain.productsList.size());
        eprsMain.displayMenu();
    }
}
