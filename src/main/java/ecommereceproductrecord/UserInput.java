package ecommereceproductrecord;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {
    Scanner sc = new Scanner(System.in);

    //Input Customer Id
    public String getCustomerId() {
        System.out.print("Enter Customer ID with 6 digits number: ");
        String input = sc.nextLine();
        if (!input.matches("[1-9][0-9]{5}")) {
            System.out.println("Please enter valid customer id (eg.123456)");
            input = getCustomerId();
        }
        return input;
    }

    //Input Transaction Id
    public String getTransactionId() {
        System.out.print("Enter Transaction ID with 10 digits number: ");
        String input = sc.nextLine();
        if (!input.matches("[1-9][0-9]{9}")) {
            System.out.println("Please enter valid transaction id (eg.1234567890)");
            input = getTransactionId();
        }
        return input;
    }

    //Input get Gender
    public String getGender() {
        System.out.println("Enter gender Male or Female: ");
        String input = sc.nextLine();

        if (!input.matches("(Male|Female|Other)")) {
            System.out.println("Gender must be Male, Female or Other.");
            input = getGender();
        }
        return input;
    }

    //Input Age Group
    public String getAgeGroup() {
        System.out.println("Enter Your age: ");
        String input = sc.nextLine();
        if (input.matches("([1-9]|1[0-7])")) {
            return "under 18";
        } else if (input.matches("(1[8-9]|2[0-4])")) {
            return "18-25";
        } else if (input.matches("(2[5-9]|[3-4][0-4])")) {
            return "25-45";
        } else if (input.matches("(4[5-9]|[5-6][0-4])")) {
            return "45-65";
        } else if (input.matches("(6[5-9]|[7-9][0-9]|100)")) {
            return "over 65";
        } else {
            System.out.println("Age must be between 1 and 100 years.");
            input = getAgeGroup();
        }
        return input;
    }

    //PurchaseDate
    public String getPurchaseDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateTime = dateFormat.format(currentDate);
        return currentDateTime;
    }

    //Input Product Category
    public String getProductCategory() {
        System.out.println("Please choice the following category: ");
        System.out.println("Beauty and Health" +
                "\n" + "Electronics" +
                "\n" + "Pet Care" +
                "\n" + "Home & Kitchen" +
                "\n" + "Clothing" +
                "\n" + "Books" +
                "\n" + "Toys & Games" +
                "\n" + "Sports & Fitness" +
                "\n" + "Other"
        );
        System.out.println();
        System.out.print("Enter Product Category: ");
        String input = sc.nextLine();
        if (!input.matches("(Beauty and Health|Books|Clothing|Electronics|Home & Kitchen|Other|Pet Care|Sports & Fitness|Toys & Games)")) {
            System.out.println("Please choice only form the product category!");
            input = getProductCategory();
        }
        return input;
    }

    //Input Discount
    public String getDiscount() {
        System.out.println("Enter discount available Yes or No: ");
        String input = sc.nextLine();

        if (!input.matches("(Yes|No)")) {
            System.out.println("Discount must be Yes or No!");
            input = getDiscount();
        }
        return input;
    }

    //Input Discount Name
    public String getDiscountName() {
        System.out.print("Please choose the following discount name: ");
        System.out.println();
        System.out.println("FESTIVE50" +
                "\n" + "SAVE10" +
                "\n" + "NEWYEARS" +
                "\n" + "WELCOME5" +
                "\n" + "SEASONALOFFER21"
        );
        String input = sc.nextLine();
        if (!input.matches("WELCOME5|SAVE10|NEWYEARS|SEASONALOFFER21|FESTIVE50")) {
            System.out.println("Please enter the valid discount name!");
            input = getDiscountName();
        }
        return input;
    }

    //Input Discount Amount
    public String getDiscountAmount() {
        System.out.print("Enter Discount Amount: ");
        String input = sc.nextLine();
        if (!input.matches("[0-9]+(\\.[0-9]+)?")) {
            System.out.println("Please enter a valid discount amount (eg.437.5)");
            input = getDiscountAmount();
        }
        return input;
    }

    //Input Gross Amount
    public String getGrossAmount() {
        System.out.print("Enter Gross Amount: ");
        String input = sc.nextLine();
        if (!input.matches("[0-9]+(\\.[0-9]+)?")) {
            System.out.println("Please enter a valid gross amount (eg.3703.5819)");
            input = getGrossAmount();
        }
        return input;
    }

    //net amount
    public String getNetAmount() {
        return null;
    }

    //Input Purchase Method
    public String getPurchaseMethod() {
        System.out.println("Please choice the following purchase method.");
        System.out.println();
        System.out.println("Cash On Delivery" +
                "\n" + "Debit Card" +
                "\n" + "Credit Card" +
                "\n" + "Paytm UPI" +
                "\n" + "Net Banking" +
                "\n" + "International Card" +
                "\n" + "PhonePe UPI" +
                "\n" + "Google Pay UPI"
        );
        System.out.println();
        System.out.print("Enter Purchase Method: ");
        String input = sc.nextLine();
        if (!input.matches("(Cash On Delivery|Credit Card|Debit Card|Google Pay UPI|International Card|Net Banking|Paytm UPI|PhonePe UPI)")) {
            System.out.println("Please choice only form the purchase method!");
            input = getPurchaseMethod();
        }
        return input;
    }

    //Input Location
    public String getLocation() {
        System.out.print("Enter Location: ");
        String input = sc.nextLine();
        if (!input.matches("[A-Z][a-z]+")) {
            System.out.println("Location must start with capital letter and follows by small letters.");
            input = getLocation();
        }
        return input;
    }

    //Search Record by CID and Product Category
    public String getSearchType() {
        System.out.println("Please choice the type of searching!");
        System.out.println("Search by Customer ID" + "\n" + "Search by Product Category");
        String input = sc.nextLine();
        if (!input.matches("(Customer ID|Product Category)")){
            System.out.println("Please choice Customer ID or Product Category!");
            input = getSearchType();
        }
        return input;
    }
}
