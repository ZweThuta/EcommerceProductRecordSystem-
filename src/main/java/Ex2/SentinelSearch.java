package Ex2;

public class SentinelSearch {
    public static void main(String[] args) {
        int[] data = {1,2,3,4,5,6,7,8,9};
        int key = 7;
        int last_data= data[data.length-1];
        data[data.length-1]=key;

        int index =0;
         while (data[index]!=key){
             index++;
         }
         data[data.length-1]=last_data;
         if (index < data.length -1 || data[data.length-1]==key){
             System.out.println("Searched Data is found at index: "+ index);
         }
         else {
             System.out.println("Searched data isn't found!");
         }
    }
}
