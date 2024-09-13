package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Deque<Integer> de_que = new ArrayDeque<>();
        de_que.add(10);
        de_que.add(20);
        for (Integer element: de_que){
            System.out.println("element: "+ element);
        }
        de_que.clear();
        de_que.addFirst(564);
        de_que.addFirst(291);
        de_que.addLast(24);
        de_que.addLast(14);
        System.out.println("After clearing, new elements are: ");
        for (Iterator itr = de_que.iterator(); itr.hasNext();){
            System.out.println(itr.next());
        }
        System.out.println("element of deque in reverse order: ");
        for (Iterator dItr = de_que.descendingIterator(); dItr.hasNext();){
            System.out.println(dItr.next());
        }
        System.out.println("Head Element using element(): "+de_que.element());
        System.out.println("Head Element using getFirst(): "+de_que.getFirst());
        System.out.println("Head Element using getLast(): "+de_que.getLast());


    }
}
