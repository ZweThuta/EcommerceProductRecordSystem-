package Ex2;

public class JumpSearch {
    public static void main(String[] args) {
        int[] data = {10,20,30,40,50,60,70,80,90};
        int key = 50;
        int found_index = -1;
        int step = (int) Math.sqrt(data.length);
        int prev = 0;
        for(int index = 0; index < data.length; index += step){
            if(data[index] > key){
                break;
            }
            prev = index;
        }
        int index = prev;
        while(index < data.length && index < prev + step){
            if(data[index] == key){
                found_index = index;
            }
            index++;
        }
        if(found_index >= 0){
            System.out.println("Searched Data is found at " + found_index);
        }
        else {
            System.out.println("Searched Data is not found.");
        }
    }
}

