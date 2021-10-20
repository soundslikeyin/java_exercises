package com.yin.java.exercise;

import java.util.Scanner;
import java.time.LocalDate;

public class UserProfile {
    public static final Scanner input = new Scanner(System.in);
    int age;
    int birthYear;
    String name;
    char gender;
    String jobPreference;
    String nationality = "Singapore";
    String bloodType;

    public static void main(String[] args) {
        UserProfile user = new UserProfile();
        LocalDate today = LocalDate.now();

        user.name = getName();
        user.age = getAge();
        user.gender = getGender();
        user.jobPreference = getJobPreference();
        user.bloodType = getBloodType();
        user.birthYear = calculateBirthYear(user.age, today);

        System.out.println("Hello " + user.name);
        System.out.println("Today is  " + today);
        System.out.println("Year now is  " + today.getYear());
        System.out.println("You were born in " + user.birthYear);

    }

    public static String getName() {
        System.out.println("Please enter your name: ");
        return input.next();
    }

    public static int getAge() {
        int age = 0;
        boolean inputValid = false;

        while (!inputValid) {
            System.out.print("Enter your age: ");
            String in = input.next();
            try {
                age = Integer.parseInt(in);
                inputValid = true;
            }  catch (NumberFormatException e) {
                System.out.println("You didn't enter a valid number.");
            }
        }
        return age;
    }

    public static char getGender() {
        char gender = '\0';

        while (gender != 'm' && gender != 'f') {
            System.out.println("Please indicate your gender (m/f): ");
            gender = input.next().charAt(0);
        }
        return gender;
    }

    public static String getJobPreference() {
        System.out.println("Please indicate your job preference: ");
        return input.next();
    }

    public static String getBloodType() {
        System.out.println("Please indicate your blood type: ");
        return input.next();
    }

    public static int calculateBirthYear(int age, LocalDate today) {
        return today.getYear() - age;
    }

}
