package com.yin.java.exercise;
//import java.io.Console;
import java.util.Scanner;

class MyFirstInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        Console console = System.console();
        System.out.println("Please enter your name ");
//        String name = console.readLine();
        String name = input.next();
        System.out.println("My name is "+ name);
    }
}