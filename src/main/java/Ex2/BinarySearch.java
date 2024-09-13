package Ex2;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arry = {10, 20, 40, 55, 3, 8, 22,99};
        int key = 99;
        int first = 0;
        int last = arry.length - 1;
        int index = -1;

        while(first <= last){
            int middle = (first + last) / 2;
            if(arry[middle] == key){
                index = middle;
                break;
            }

            if(arry[middle] < key){
                first = middle + 1;
            }

            else{
                last = middle - 1;
            }
        }
        if (index >= 0){
            System.out.println("Searched data: " + key + " is found at " + index);
        }

        else {
            System.out.println("Searched data is not found");
        }
    }
}