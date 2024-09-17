package popularbabyname;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.LinkedList;

public class ReportBabyNameByYear {
    LinkedList<BabyName> nameList = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public ReportBabyNameByYear(LinkedList<BabyName> nameList) {
        this.nameList = nameList;
    }

    public void displayNamesByYear(){
        String year = userInput.getYear();
         while(!sea.searchYear(year,nameList)){
             System.out.println("Year does not exist");
             year=userInput.getYear();
         }
        LinkedList<BabyName> maleNames = new LinkedList<>();
        LinkedList<BabyName> femaleNames = new LinkedList<>();

        for( BabyName B: nameList){
            if (B.getYear() == Integer.parseInt(year)){
                if (B.getGender().equals("M")){
                    maleNames.add(B);
                }
                else {
                    femaleNames.add(B);
                }
            }
        }

        AsciiTable table = new AsciiTable();
        System.out.println("Baby Names of Year "+ year);
        table.addRule();
        table.addRow(Arrays.asList("Name","Gender","Year","Rank","Count"));
        table.addRule();

        for (BabyName B: maleNames){
            table.addRow(Arrays.asList(B.getBabyName(),B.getGender(),
                    B.getYear(),B.getRank(),B.getCount()));
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        sea.writeToCsv("data/maleList.csv",maleNames,false);


        for (BabyName B: femaleNames){
            table.addRow(Arrays.asList(B.getBabyName(),B.getGender(),
                    B.getYear(),B.getRank(),B.getCount()));
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        sea.writeToCsv("data/femaleList.csv",femaleNames,false);
    }


}
