package com.generation.utils;

import com.generation.model.Student;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PrinterHelper
{

    public static void showMainMenu(){
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Welcome to StudentGen         |" );
        System.out.println( "|-------------------------------|" );
        System.out.println( "| Select 1 option:              |" );
        System.out.println( "| . 1 Register Student          |" );
        System.out.println( "| . 2 Find Student              |" );
        System.out.println( "| . 3 Grade Student             |" );
        System.out.println( "| . 4 Enroll Student to Course  |" );
        System.out.println( "| . 5 Show Students Summary     |" );
        System.out.println( "| . 6 Show Courses Summary      |" );
        System.out.println( "| . 7 Show Average Grade        |" );
        System.out.println( "| . 8 Exit                      |" );
        System.out.println( "|-------------------------------|" );
    }

    public static Student createStudentMenu( Scanner scanner )
        throws ParseException
    {
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| . 1 Register Student                |" );
        System.out.println( "|-------------------------------------|" );
        System.out.println( "| Enter student name:                 |" );
        String name = scanner.next();
        System.out.println( "| Enter student ID:                   |" );
        String id = scanner.next();
        System.out.println( "| Enter student email:                |" );
        String email = scanner.next();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = null;

        while(birthDate == null) {
            try {
                System.out.println("| Enter student birth date(mm-dd-yyyy)|");
                String dateString = scanner.next();
                birthDate = LocalDate.parse(dateString, dateFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Exception " + e);
                System.out.println("The date you have entered is invalid, please use the format given");
            }
        }

        System.out.println( "|-------------------------------------|" );
        Student student = new Student( id, name, email, birthDate );
        System.out.println( "Student Successfully Registered! " );
        System.out.println(student);
        return student;
    }

}
