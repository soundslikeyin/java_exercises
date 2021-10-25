package com.yin.java.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Course {
    String courseName;
    String professorName;
    int year;
    ArrayList<Student> studentList = new ArrayList<Student>();
    int bestGrade;
    float averageGrade;

    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
    }

    public void enroll(Student student){
        this.studentList.add(student);
    }

    public void enroll(Student[] newList){

        for (Student student: newList) {
            this.studentList.add(student);
        }
    }

    public void unEnroll(Student student){
        if (this.studentList.contains(student)) {
            this.studentList.remove(student);
        } else {
            System.out.println("This is not a student of the course.");
        }
    }

    public int countStudents(){
        return this.studentList.size();
    }

    public int bestGrade(){
        this.bestGrade = 0;

        for (Student student: this.studentList) {
            if (student.grade > bestGrade) {
                this.bestGrade = student.grade;
            }
        }
        return bestGrade;
    }

    public void printStudentList(){
        System.out.println("Student List of the "+ courseName +" course is: ");
        for (Student student: this.studentList) {
            student.printFullName();
        }
    }

//    Implement a function that calculates the average grade for that course.
//    Implement a function that outputs a ranking with all students enrolled in a course and respective grades.
//    Implement a function that, for each student, show if he/she is above course average or not.


    public float calculateAverageGrade(){
        int totalGrades = 0;
        for (Student student: this.studentList) {
            totalGrades += student.grade;
        }

        this.averageGrade = (float)totalGrades / this.countStudents();
        return this.averageGrade;
    }


    public void printRankingList() {
        Student[] rankedStudentList  = this.studentList.toArray(new Student[0]);
        Comparator<Student> studentGradeComparator = Comparator.comparing(Student::getGrade).reversed();
        Arrays.sort(rankedStudentList, studentGradeComparator);

//        Alternative method using ArrayList
//        ArrayList<Student> rankedStudentList = new ArrayList<>(this.studentList);
//        rankedStudentList.sort(Comparator.comparing(a -> a.grade));
//        rankedStudentList.sort(Comparator.comparing(Student::getGrade).reversed());

        System.out.println("Student ranking list");
        int rankNo = 1;

        for (Student student: rankedStudentList) {
            System.out.println(rankNo +" "+ student.firstName + " " + student.lastName + " " + student.grade);
            rankNo++;
            }
    }


    public boolean isAboveAverage(Student student){

        if (student.grade > averageGrade) {
            System.out.println(student.firstName + " " + student.lastName + " has an above average grade");
            return true;
        } else {
            System.out.println(student.firstName + " " + student.lastName + " does not have an above average grade");
            return false;
        }
    }



}

