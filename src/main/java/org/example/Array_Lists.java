package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Array_Lists {
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();
        al.add("AA");
        al.add("BB");
        al.add("CC");
        al.add(1,"ZZ");

        System.out.println("Traversing the forward direction");
        ListIterator<String> itr= al.listIterator();
        while (itr.hasNext()){
            System.out.println("Index: " + itr.nextIndex()+" value "+itr.next());
        }

        System.out.println("Traversing the backward direction");
        while(itr.hasPrevious()){
            System.out.println("Index: "+ itr.previousIndex()+ " value "+ itr.previous());
        }

        System.out.println("For each");
        for(String forEach :al){
            System.out.println(forEach);
        }
    }
}
