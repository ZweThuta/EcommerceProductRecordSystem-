package org.example;

import java.util.Arrays;

public class Copying_Array {
    public static void main(String[] args) {
        int[]a={1,2,3,4,5};
        int[]b=new int [2];
        System.arraycopy(a,0,b,0,2);
        System.out.println(Arrays.toString(b));

    }
}
