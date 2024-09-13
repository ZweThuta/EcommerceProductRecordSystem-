package org.example;

import java.util.Arrays;

public class Array_test {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;
        arr[5]=6;
        arr[6]=7;
        arr[7]=8;
        arr[8]=9;
        arr[9]=10;
        System.out.println(Arrays.toString(arr));
        arr[9]=3;
        System.out.println(Arrays.toString(arr));

        int arr2[]={10,20};
        System.out.println(arr2[1]);
    }
}
