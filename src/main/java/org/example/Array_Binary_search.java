package org.example;

import java.util.Arrays;

public class Array_Binary_search {
    public static void main(String[] args) {
        int []a={2,3,6,5,4,8,9,7,10};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        int search =10;
        int index = Arrays.binarySearch(a, search);
        if (index >=0){
            System.out.println(search +" is found at index "+ index);
        }
        else {
            System.out.println(search +" is not found ");
        }

    }
}
