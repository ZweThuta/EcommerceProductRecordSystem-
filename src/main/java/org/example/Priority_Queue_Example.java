package org.example;

import java.util.PriorityQueue;

public class Priority_Queue_Example {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>();
        priorityQueue.add("Glanz");
        priorityQueue.add("Borman");
        priorityQueue.add("Adalson");// sorting si p output htwat
        priorityQueue.add("David");
        System.out.println("Head : " + priorityQueue.element());
        System.out.println("head : " + priorityQueue.peek());
        System.out.println("Remove :" + priorityQueue.remove());
        System.out.println("Head : " + priorityQueue.element());
        System.out.println("Traversing elements :");
//        for (String st : priorityQueue){
//            System.out.println(st);
//        }
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.remove());
        }

    }
}