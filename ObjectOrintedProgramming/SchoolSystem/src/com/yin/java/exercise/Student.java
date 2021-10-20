package com.yin.java.exercise;

public class Student {
    String firstName;
    String lastName;
    private static int registered = 0;
    private int registration;
    int grade;
    int year;

    public Student(String firstName, String lastName, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registered + 1;
        this.grade = grade;
        this.year = year;
        registered ++;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registered + 1;
        registered ++;
    }

    public Student(String firstName, String lastName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.year = year;
        this.registration = registered + 1;
        registered ++;
    }

    public int getGrade(){
        return this.grade;
    }

    public void printFullName(){
        System.out.println(this.firstName + " " + this.lastName);
    }

    public boolean isApproved(){
        if (this.grade >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public int changeYearIfApproved(){
        if (this.isApproved()) {
            year = year + 1;
            System.out.println("Congratulations!");
        }
        return year;
    }







}
