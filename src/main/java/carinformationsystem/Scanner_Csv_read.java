package carinformationsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Scanner_Csv_read {
    public static void main(String[] args) {

        File dataFile = new File("data/carsDataset.csv");
        Scanner sc = null;
        try {
            sc = new Scanner(dataFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (sc.hasNext()){
                System.out.println(sc.next());
            }
            sc.close();

    }
}