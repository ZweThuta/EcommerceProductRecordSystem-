package popularbabyname;

import java.util.LinkedList;

public class DeleteByOneBabyName {
    LinkedList<BabyName> nameList = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public DeleteByOneBabyName(LinkedList<BabyName> nameList) {
        this.nameList = nameList;
    }

    public void deleteName(){
        String name = userInput.getName();
        String gender = userInput.getGender();
        String year = userInput.getYear();
        int index = sea.searchNameGenderYear(name,gender,year,nameList);

        while(index<0){
            System.out.println("Delete Baby Name doesn't exist.");
            name =userInput.getName();
            gender=userInput.getGender();
            year=userInput.getYear();
            index=sea.searchNameGenderYear(name,gender,year,nameList);
        }
        nameList.remove(index);
        sea.ranking(gender,year,nameList);
        sea.writeToCsv("data/Baby_Names.csv",nameList,false);
        System.out.println("Deleted Successfully!");
    }
}
