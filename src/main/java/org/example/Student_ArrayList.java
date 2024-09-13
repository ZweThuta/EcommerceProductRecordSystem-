package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student_ArrayList {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        Student s1 = new Student(1,"Lin Lin", 20);
        Student s2 = new Student(2,"Myat Myat", 22);
        Student s3 = new Student(3,"ZZ", 23);

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(new Student(4,"John Doe", 34));

        for(Student stu :studentList){
            System.out.println(stu.toString());
        }

    }
}
