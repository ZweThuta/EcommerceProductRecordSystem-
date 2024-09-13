package Exercies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Concordance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Words");
        String words = sc.nextLine();

        Map<Character, ArrayList<Integer>> concordance = new HashMap<>();
        for (int i=0; i<words.length();i++){
            char c = words.charAt(i);

            if (c==' '){
                continue;
            }
        }
    }
}
