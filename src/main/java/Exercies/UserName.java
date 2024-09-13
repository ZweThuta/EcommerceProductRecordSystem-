package Exercies;

import java.util.ArrayList;
import java.util.Scanner;

public class UserName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many users want to input?");
        int user = sc.nextInt();
        sc.nextLine();
        ArrayList <String> username = new ArrayList<>();
        for (int i=0; i<user; i++){
            System.out.println("Enter name "+(i+1)+" => ");
            String name = sc.nextLine();
            username.add(name);
        }
        System.out.println("The input names are:");
        for(String eachName : username){
            System.out.println(eachName);
        }

        System.out.println();
        System.out.println("Names that are longer than 5 characters are:");
        for (String fiveChrname : username){
            if (fiveChrname.length()>5){
                System.out.println(fiveChrname);
            }
        }

    }
}
