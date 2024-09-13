package popularbabyname;

import java.util.LinkedList;

public class AddOneBabyName {
    UserInput userInput = new UserInput();
    Searching sea = new Searching();
    LinkedList <BabyName> namelist = new LinkedList<>();

    public AddOneBabyName(LinkedList<BabyName> namelist) {
        this.namelist = namelist;
    }

    public void addName(){
        String name = userInput.getName();
        String gender = userInput.getGender();
        String year = userInput.getYear();

        while ((sea.searchNameGenderYear(name,gender,year,namelist))>=0){
            System.out.println("Baby Name is already exists");
            name= userInput.getName();
            gender = userInput.getGender();
            year = userInput.getYear();
        }
        String count = userInput.getCount();
        namelist.add(new BabyName(name,gender,Integer.parseInt(year),0,Integer.parseInt(count)));
        sea.ranking(gender,year,namelist);
        sea.writeToCsv("data/Baby_Names.csv",namelist,false);
        System.out.println("Added Successfully.");
    }
}
