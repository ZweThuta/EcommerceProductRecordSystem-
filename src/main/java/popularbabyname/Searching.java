package popularbabyname;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Searching {
    public int searchNameGenderYear(String name, String gender, String year, LinkedList<BabyName> namelist){
        int index =-1;
        for(BabyName B: namelist){
            if (B.getBabyName().equals(name)&& B.getGender().equals(gender)&& B.getYear()==Integer.parseInt(year)){
                return index;
            }
            index++;
        }
        return -1;
    }
    public boolean searchYear(String year, LinkedList<BabyName> nameList){
        for (BabyName B: nameList){
            if (B.getYear() == Integer.parseInt(year)){
                return true;
            }
        }
        return false;
    }

    public void ranking(String gender, String year, LinkedList<BabyName> nameList){
        LinkedList<BabyName> tempList = new LinkedList<BabyName>();
        for (BabyName B: nameList){
            if(B.getGender().equals(gender) && B.getYear()==Integer.parseInt(year)){
                tempList.add(B);
            }
        }
        nameList.removeAll(tempList);
        tempList.sort(Collections.reverseOrder(Comparator.comparing(BabyName::getCount)));
        int rank=0;
        int tempcount=0;
        for (BabyName B: tempList){
            if (B.getCount()!=tempcount)
                rank++;
            tempcount=B.getCount();
            B.setRank(rank);
        }
        tempList.sort(Comparator.comparing(BabyName::getBabyName));
        nameList.addAll(tempList);
    }
    public void writeToCsv(String fname, LinkedList<BabyName> namelist, boolean append){
        FileWriter fw = null;
        try {
            fw = new FileWriter(fname,append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fw);
        for (BabyName B: namelist){
            String[] data ={B.getBabyName(),B.getGender(),
                    String.valueOf(B.getYear()),
                    String.valueOf(B.getCount()),
                    String.valueOf(B.getRank())};
           csvWriter.writeNext(data);
        }
        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
