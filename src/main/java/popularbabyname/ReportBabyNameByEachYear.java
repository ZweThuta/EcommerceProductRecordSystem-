package popularbabyname;

import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ReportBabyNameByEachYear {
    LinkedList<BabyName> nameList = new LinkedList<>();
    UserInput userInput = new UserInput();
    Searching sea = new Searching();

    public ReportBabyNameByEachYear(LinkedList<BabyName> nameList) {
        this.nameList = nameList;
    }

    public void displayTopTen(){
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

        maleNames.sort(Collections.reverseOrder(Comparator.comparing(BabyName::getRank)));
        femaleNames.sort(Collections.reverseOrder(Comparator.comparing(BabyName::getRank)));

        LinkedList<BabyName> topTenMaleNames = new LinkedList<>(maleNames.subList(0, Math.min(10, maleNames.size())));
        LinkedList<BabyName> topTenFemaleNames = new LinkedList<>(femaleNames.subList(0, Math.min(10, maleNames.size())));

        AsciiTable table = new AsciiTable();
        System.out.println("Baby Names of Year "+ year);
        table.addRule();
        table.addRow(Arrays.asList("Name","Gender","Year","Rank","Count"));
        table.addRule();

        for (BabyName B: topTenMaleNames){
            table.addRow(Arrays.asList(B.getBabyName(),B.getGender(),
                    B.getYear(),B.getRank(),B.getCount()));
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        sea.writeToCsv("data/topMaleList.csv",topTenMaleNames,false);


        for (BabyName B: topTenFemaleNames){
            table.addRow(Arrays.asList(B.getBabyName(),B.getGender(),
                    B.getYear(),B.getRank(),B.getCount()));
            table.addRule();
        }
        table.setTextAlignment(TextAlignment.CENTER);
        System.out.println(table.render());
        sea.writeToCsv("data/TopFemaleList.csv",topTenFemaleNames,false);

    }
}
