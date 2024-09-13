package org.example;

import java.util.TreeSet;

public class TreeSet_example {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("E");
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("D");
        treeSet.add("C");
        System.out.println("Initial Set "+ treeSet);
        System.out.println("Reverse Set "+treeSet.descendingSet());
        System.out.println("Head Set "+ treeSet.headSet("C",true));
        System.out.println("Subst "+treeSet.subSet("A",false,"E",true));
        System.out.println("Tail Set "+treeSet.tailSet("C",false));
    }
}
