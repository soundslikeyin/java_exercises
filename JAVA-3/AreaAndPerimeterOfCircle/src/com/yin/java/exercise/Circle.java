package com.yin.java.exercise;
import java.util.Scanner;
import java.lang.Math;

public class Circle {
    float diameter;
    float perimeter;
    float area;
    float radius;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Circle circleA = new Circle();

        System.out.println("Please enter diameter of the circle: ");
        circleA.diameter = input.nextFloat();
        circleA.radius = circleA.diameter / 2;
        circleA.area = (float)(Math.pow(circleA.radius, 2) * Math.PI);
        circleA.perimeter = (float)(circleA.diameter * Math.PI);

        System.out.println("The area of the circle is:" + circleA.area);
        System.out.println("The perimeter of the circle is:" + circleA.perimeter);
    }
}

