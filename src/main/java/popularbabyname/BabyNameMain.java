package popularbabyname;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BabyNameMain {
    protected  LinkedList<BabyName> babyName = new LinkedList<BabyName>();
    protected Scanner sc= new Scanner(System.in);

    public void menu(){
        System.out.println("Welcome to Popular Baby Name Program ");
        System.out.println("======================================");
        System.out.println("1. Adding One Baby Name.");
        System.out.println("2. Adding New Baby Names By Year.");
        System.out.println("3. Edit One Baby Name Data.");
        System.out.println("4. Delete One Baby Name Data.");
        System.out.println("5. Delete Baby Names by Year.");
        System.out.println("6. Display Male Female Baby Names by Year.");
        System.out.println("7. Display Top Ten Male Female Baby Names in Each Year.");
        System.out.println("8. Exit");
        System.out.print("Choose Option: ");
    }
    public String getMenuNumber(){
        String input = sc.nextLine();
        if (! input.matches("[1-8]")){
            System.out.println("Enter Menu Number only between 1 and 8.");
            input=getMenuNumber();
        }
        return input;
    }
    public void displayMenu(){
        menu();
        switch (getMenuNumber()){
            case "1": {
                babyName=new LinkedList<BabyName>();
                dataRead("data/Baby_Names.csv");
                new AddOneBabyName(babyName).addName();
                displayMenu();
                break;
            }
            case "2": {
                babyName=new LinkedList<BabyName>();
                dataRead("data/Baby_Names.csv");
                new AddRawBabyName(babyName).addName();
                displayMenu();
                break;
            }
        }
    }
    public void dataRead(String fname){
        FileReader fr = null;
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        CSVReader csvReader = new CSVReader(fr);
        String data[];
        while (true){
            try {
                if (!((data=csvReader.readNext())!=null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            }
            babyName.add(new BabyName(data[0],data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    Integer.parseInt(data[4])));
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
        System.out.println("Loading data:");
        BabyNameMain main = new BabyNameMain();
        main.dataRead("data/Baby_Names.csv");
        System.out.println(main.babyName.size());
        main.displayMenu();

//        main.dataRead("data/Baby_Names.csv");
//        for (BabyName bn:main.babyName){
//            System.out.println(bn.getBabyName());
//        }
//        Searching searching = new Searching();
//        searching.ranking("M","1887",main.babyName);
    }
}
