package popularbabyname;

import java.util.LinkedList;

public class EditOneBabyName {
    LinkedList<BabyName> nameList = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public EditOneBabyName(LinkedList<BabyName> nameList) {
        this.nameList = nameList;
    }

    public void editName(){
        String name = userInput.getName();
        String gender = userInput.getGender();
        String year = userInput.getYear();
        int index = sea.searchNameGenderYear(name,gender,year,nameList);

        while(index<0){
            System.out.println("Baby Name doesn't exist.");
            name =userInput.getName();
            gender=userInput.getGender();
            year=userInput.getYear();
            index=sea.searchNameGenderYear(name,gender,year,nameList);
        }

        nameList.remove(index);
        sea.ranking(gender,year,nameList);
        System.out.println("Enter Data to edit.");
        new AddOneBabyName(nameList).addName();
        System.out.println("Edited Successfully");
    }

}
