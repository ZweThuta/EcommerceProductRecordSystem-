package popularbabyname;

import java.io.File;
import java.util.Scanner;

public class UserInput {
    Scanner sc = new Scanner(System.in);
    public String getName(){
        System.out.println("Enter Baby Name: ");
        String input = sc.nextLine();

        if (!input.matches("[A-Z][a-z]{1,20}")){
            System.out.println("Name must be at least two letter start with capitalized.");
            input = getName();
        }
        return input;
    }

    public String getGender(){
        System.out.println("Enter gender M or F: ");
        String input= sc.nextLine();

        if (!input.matches("[M|F]")){
            System.out.println("Gender must be M or F.");
            input = getGender();
        }
        return input;
    }

    public String getYear(){
        System.out.println("Enter Year: ");
        String input = sc.nextLine();

        if (!input.matches("[1-9][0-9]{3}")){
            System.out.println("Year must be four digits.");
            input = getYear();
        }
        return input;
    }

    public String getCount(){
        System.out.println("Enter count: ");
        String input = sc.nextLine();

        if (!input.matches("[1-9][0-9]*")){
            System.out.println("Count must be greater than zero.");
            input =getCount();
        }
        return input;
    }
    public String getFilename(){
        System.out.println("Enter filename: ");
        String input = sc.nextLine();

        if (!new File(input).exists()){
            System.out.println("File does not exist.");
            input = getFilename();
        }
        return input;
    }
}
