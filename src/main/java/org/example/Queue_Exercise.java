package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Queue_Exercise {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer("A");
        queue.offer("C");
        queue.offer("D");
        System.out.println("Initial queue: "+queue);

        queue.offer("F");
        System.out.println("F is added: "+ queue);

        queue.poll();
        queue.poll();
        System.out.println("Two letters removed: "+queue);

        queue.offer("K");
        queue.offer("L");
        queue.offer("M");
        System.out.println("K,L and M added: "+queue);

        queue.poll();
        queue.poll();
        System.out.println("Two letters removed: "+queue);
    }
}
