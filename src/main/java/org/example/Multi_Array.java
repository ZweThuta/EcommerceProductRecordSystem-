package org.example;

import java.util.Arrays;

public class Multi_Array {
    public static void main(String[] args) {
        int[][] arr = {{3,4,5,6},{7,8,9,10}};
//        for (int i=0; i< arr.length; i++){
//            for (int  j=0; j<arr[i].length; j++){
//                System.out.print(arr[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(Arrays.deepToString(arr));
    }
}
