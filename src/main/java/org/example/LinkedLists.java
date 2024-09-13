package org.example;

import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args) {
        LinkedList<Student> linkedList = new LinkedList<Student>();
        Student s1 = new Student(1,"Lin Lin", 20);
        Student s2 = new Student(2,"Myat Myat", 22);
        Student s3 = new Student(3,"ZZ", 23);
        linkedList.addFirst(s3);
        linkedList.addFirst(s1);
        linkedList.add(s2);
        linkedList.addFirst(new Student(4,"LL",32));

        for(Student stu: linkedList){
            //System.out.println("Student Id: "+stu.stu_id+" "+"Name: "+stu.stu_name+" "+"Age: "+stu.stu_age);
            System.out.println("Student Id: "+stu.stu_id);
            System.out.println("Name: "+stu.stu_name);
            System.out.println("Age: "+stu.stu_age);
            System.out.println("");
        }

    }
}
