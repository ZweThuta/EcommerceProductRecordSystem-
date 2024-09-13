package org.example;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("One");
        set.add("Two");
        set.add("Three");
        set.add("Four");
        System.out.println("An initial list of elements: "+set);
        set.remove("One");
        System.out.println("After removing:"+ set);

        HashSet<String> set1 = new HashSet<String>();
        set1.add("Five");
        set1.add("Six");
        set.addAll(set1);
        System.out.println("Updated List: "+ set);
        set.removeAll(set1);
        System.out.println("After removing: "+ set);
        set.removeIf(str -> str.contains("Two"));
        System.out.println("After remove if: "+ set);
        set.clear();
        System.out.println("After clear: "+set);
    }
}
