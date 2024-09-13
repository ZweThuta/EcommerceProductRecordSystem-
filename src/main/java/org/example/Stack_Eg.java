package org.example;

import java.util.Iterator;
import java.util.Stack;

public class Stack_Eg {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Alison");
        stack.push("Authur");
        stack.push("Diego");
        stack.push("Claus");
        stack.push("Victor");
        stack.push("Lyla");
        stack.push("Five");
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println("After peek operation");
        for (String st : stack){
            System.out.println(stack);
        }
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
        System.out.println("Stack is empty "+stack.isEmpty());
    }
}
