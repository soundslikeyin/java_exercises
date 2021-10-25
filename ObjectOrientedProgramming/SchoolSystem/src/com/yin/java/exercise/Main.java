package com.yin.java.exercise;

public class Main {

    public static void main(String[] args) {

        Student studentA = new Student("Nicole","Stewart", 1 );
        Student studentB = new Student("Sarah","Windsor", 1);
        Student studentC = new Student("Elizabeth","Blois", 1);
        Student studentD = new Student("Yvonne","Lim", 1);
        studentA.grade = 50;
        studentB.grade = 60;
        studentC.grade = 70;
        studentD.grade = 60;


        Course basicJava = new Course("Basic Java", "Hugo Sum", 2021);

//        basicJava.enroll(studentA);
//        basicJava.enroll(studentB);
//        basicJava.enroll(studentC);

        Student[] students = {studentA, studentB, studentC, studentD};
        basicJava.enroll(students);
        System.out.println("There are " + basicJava.countStudents()+ " students in the " + basicJava.courseName + " course");
        basicJava.printStudentList();
        System.out.println("Best Grade in the course is: " + basicJava.bestGrade());
        System.out.println();

//        basicJava.unEnroll(studentC);
//        basicJava.printStudentList();
//        System.out.println("Best Grade in the course is: " + basicJava.bestGrade());
        System.out.println("The average grade of the course is " + basicJava.calculateAverageGrade());
        System.out.println();


        basicJava.printRankingList();
        System.out.println();

        basicJava.isAboveAverage(studentA);
    }
}
