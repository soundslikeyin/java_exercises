package com.generation;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{

    public static void main( String[] args )
        throws ParseException
    {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        Scanner scanner = new Scanner( System.in );
        int option = 0;
        do
        {
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                case 1:
                    registerStudent( studentService, scanner);
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollStudentToCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showAverageGrade( courseService, studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

//    case 4
    private static void enrollStudentToCourse(StudentService studentService, CourseService courseService,
                                              Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse(studentId, course, courseService);
        if ( student.isCourseApproved(course, courseService) ){
            courseService.enrollStudent( courseId, student );
            System.out.println("Student with ID: " + studentId + " enrolled successfully to " + courseId);
        } else {
            System.out.println("Student with ID: " + studentId + " does not have the prerequisites to " + courseId);
        }

    }

//    case 6
    private static void showCoursesSummary(CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

//    case 5
    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        studentService.showSummary();
    }

//    case 3
    private static void gradeStudent( StudentService studentService, Scanner scanner )
            throws ParseException
    {
        System.out.println( "| Enter student ID:                   |" );
        String studentId = scanner.next();
        System.out.println( "| Enter course ID:                   |" );
        String courseId = scanner.next();
        System.out.println( "| Enter grade:                   |" );
        int grade = scanner.nextInt();
        studentService.findStudent(studentId).addGrade(courseId, grade);
    }

//    case 2
    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        }
        else
        {
            System.out.println( "Student with Id = " + studentId + " not found" );
        }
    }

//    case 1
    private static void registerStudent( StudentService studentService, Scanner scanner)
        throws ParseException
    {
        Student student = PrinterHelper.createStudentMenu( scanner ); // create student object
        studentService.subscribeStudent( student ); // add student object into student list
    }

//    case 7
    private static void showAverageGrade(CourseService courseService, StudentService studentService, Scanner scanner )
        throws ParseException{
        System.out.println( "| Enter course ID:                   |" );
        String courseId = scanner.next();
        int totalGrade = 0;
        int studentNum = 0;
        float averageGrade;

        for (Student student: courseService.getStudents(courseId)) {
            totalGrade += student.getGrade(courseId);
            studentNum ++;
        }

        if (studentNum == 0) {
            averageGrade = 0;
        } else {
            averageGrade = (float) totalGrade / studentNum;
        }

        System.out.println("Average grade of " + courseId + " is " + averageGrade);
    }
}
