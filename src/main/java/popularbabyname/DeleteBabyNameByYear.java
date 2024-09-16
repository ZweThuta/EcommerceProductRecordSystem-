package popularbabyname;

import java.util.LinkedList;

public class DeleteBabyNameByYear {
    LinkedList<BabyName> nameList = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public DeleteBabyNameByYear(LinkedList<BabyName> nameList) {
        this.nameList = nameList;
    }

    public void deleteYear(){
        LinkedList<BabyName> tempList = new LinkedList<>();
        String year = userInput.getYear();
        boolean checkYear = sea.searchYear(year,nameList);

        while(!checkYear){
            System.out.println("Delete Year doesn't exist.");
            year=userInput.getYear();
            checkYear = sea.searchYear(year,nameList);
        }
        for (BabyName B:nameList){
            if(B.getYear()==Integer.parseInt(year)){
                tempList.add(B);
            }
        }
        nameList.removeAll(tempList);
        sea.writeToCsv("data/Baby_Names.csv",nameList,false);
        System.out.println("Delete Year Successfully!");
    }

}
