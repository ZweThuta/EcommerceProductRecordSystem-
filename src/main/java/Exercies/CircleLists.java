package Exercies;

import java.util.ArrayList;
import java.util.Random;

public class CircleLists {
    public static void main(String[] args) {
        ArrayList <CircleOject> circleOjects = new ArrayList<>();
        Random random = new Random();
    while (true){
        float radius =1+ random.nextFloat()*10;
        circleOjects.add(new CircleOject(radius));

        if (Math.random()<0.01){
            break;
        }
    }
        System.out.println("Areas of the circles:");
        for (CircleOject circleOject:circleOjects ){
            System.out.println(circleOject.getArea());
        }
    }
}
