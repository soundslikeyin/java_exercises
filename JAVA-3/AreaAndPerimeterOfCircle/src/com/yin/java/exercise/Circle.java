package com.yin.java.exercise;
import java.util.Scanner;
import java.lang.Math;

public class Circle {
    float diameter;
    float perimeter;
    float area;

    public static void main(String[] args) {
        Circle circleA = new Circle();
        circleA.diameter = getDiameter();
        circleA.area = getArea(circleA.diameter);
        circleA.perimeter = getPerimeter(circleA.diameter);

        System.out.println("The area of the circle is:" + circleA.area);
        System.out.println("The perimeter of the circle is:" + circleA.perimeter);
    }


    public static float getDiameter(){
        Scanner in = new Scanner(System.in);
        boolean inputValid = false;
        float diameter = 0f;

        while (!inputValid) {
            System.out.println("Please enter diameter of the circle: ");
            String input = in.next();
            try {
                diameter = Float.parseFloat(input);
                inputValid = true;
            }  catch (NumberFormatException e) {
                System.out.println("You didn't enter a valid number.");
            }
        }
        return diameter;
    }

    public static float getArea(float diameter) {
        return (float)(Math.pow(diameter/2, 2) * Math.PI);
    }

    public static float getPerimeter(float diameter) {
        return (float)(diameter * Math.PI);
    }


}

