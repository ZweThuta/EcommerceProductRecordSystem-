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

public class EPRSMain extends MenuMethodsTemplate {
    LinkedList<Transaction> productsList = new LinkedList<Transaction>();
    Scanner sc = new Scanner(System.in);
    SearchAndReportFacade searchAndReportFacade;

    public void menu() {
        System.out.println("Welcome to Ecommerce Product Record Program ");
        System.out.println("_____________________________________________");
        System.out.println("1. Menu");
        System.out.println("2. Adding new product data to the csv file.");
        System.out.println("3. Updating the existing product record data.");
        System.out.println("4. Deleting the existing product");
        System.out.println("5. Search the product record data according to either product category or customer id.");
        System.out.println("6. All the product category sorting in net amount from the highest to the lowest.");
        System.out.println("7. List of the product according to the category.");
        System.out.println("8. Total number of product bought by each user sorting by the most product counts.");
        System.out.println("9. List of the product with discount availed “Yes” with sort by product category.");
        System.out.println("10. Product Category Count In Each Location and display location name with the product count from the highest to the lowest.");
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
                System.out.println("Searching product record by customer Id and product category.");
                searchRecord();
                break;
            }
            case "6": {
                System.out.println("Sorting product category by net amount in highest to lowest.");
                sortNetAmount();
                break;
            }
            case "7": {
                System.out.println("Listing product according to product category.");
                sortProductList();
                break;
            }
            case "8": {
                System.out.println("Total product count by each user");
                totalProductByEachUser();
                break;
            }
            case "9": {
                System.out.println("Product with discount available");
                discountProduct();
                break;
            }
            case "10": {
                System.out.println("Product Category Count by Location");
                productByEachLocation();
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

    @Override
    public void searchRecord() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        UserInput userInput = new UserInput();
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        if (userInput.getSearchType().equals("Customer ID")){
            searchAndReportFacade.searchByCustomerId();
        }
        else {
            searchAndReportFacade.searchByProductCategory();
        }
        displayMenu();
    }

    @Override
    public void sortNetAmount() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        searchAndReportFacade.reportSortedByNetAmount();
        displayMenu();
    }

    @Override
    public void sortProductList() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        searchAndReportFacade.listProductsByCategory();
        displayMenu();
    }

    @Override
    public void totalProductByEachUser() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        searchAndReportFacade.productCountByEachUser();
        displayMenu();
    }

    @Override
    public void discountProduct() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        searchAndReportFacade.productWithDiscountAvailable();
        displayMenu();
    }

    @Override
    public void productByEachLocation() {
        productsList = new LinkedList<Transaction>();
        dataRead("data/project1_df.csv");
        searchAndReportFacade = new SearchAndReportFacade(productsList);
        searchAndReportFacade.countProductsByLocation();
        displayMenu();
    }

    public void dataRead(String fname) {
        productsList = CSVReadSingleton.getInstance().csvRead(fname);
    }

    public static void main(String[] args) {
        EPRSMain eprsMain = new EPRSMain();
        eprsMain.dataRead("data/project1_df.csv");
        System.out.println(eprsMain.productsList.size());
        eprsMain.displayMenu();
    }
}
