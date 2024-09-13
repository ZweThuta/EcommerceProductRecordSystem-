package popularbabyname;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class AddRawBabyName {
    LinkedList<BabyName> babyName = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public AddRawBabyName(LinkedList<BabyName> babyName) {
        this.babyName = babyName;
    }

    public void addName(){
        String year = userInput.getYear();
        String fname = userInput.getFilename();
        while (sea.searchYear(year,babyName)){
            System.out.println("Year is already exist.");
            year=userInput.getYear();
        }
        LinkedList<BabyName> tempList = new LinkedList<>();
        FileReader fr = null;
        try {
            fr = new FileReader(fname);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br = new BufferedReader(fr);
        String line;
        while (true){
            try {
                if (!((line = br.readLine())!=null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String [] data =line.split(",");
            tempList.add(new BabyName(data[0],data[1],Integer.parseInt(year),0,Integer.parseInt(data[2])));
        }
        try {
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sea.ranking("M",year,tempList);
        sea.ranking("F",year,tempList);
        babyName.addAll(tempList);
        sea.writeToCsv("data/Baby_Names.csv",babyName,false);
        System.out.println("Added Successfully.");

    }
}
