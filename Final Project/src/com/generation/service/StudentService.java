package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    public void subscribeStudent( Student student )
    {
        if (!isSubscribed(student.getId())) {
            students.put(student.getId(), student);
        } else {
            System.out.println("Student is already subscribed");
        }
    }

    public Student findStudent( String studentId )
    {
        if ( students.containsKey( studentId ) )
        {
            return students.get( studentId );
        }
        return null;
    }

    public boolean isSubscribed( String studentId )
    {
       return students.containsKey(studentId);
    }

    public void showSummary()
    {
        System.out.println("Students currently subscribed:");
        students.forEach((k, v) -> {
            System.out.println("Name: " + v.getName());
            if (v.getApprovedCourses().isEmpty()) {
                System.out.println(v.getName() + " has not registered for any approved courses" + "\n");
            } else {
                System.out.println("Approved Courses: ");
                for (Course course: v.getApprovedCourses()) {
                    if (v.hasBeenGraded(course.getCode())){
                        System.out.println(course.getName() + "      " + "Grade: " + v.getGrade(course.getCode()) + "\n" );
                    } else {
                        System.out.println(course.getName() + " has not been graded.");
                    }
                }
            }
        });
    }

    public void enrollToCourse(String studentId, Course course, CourseService courseService )
    {
        if ( students.containsKey( studentId ) )
        {
            students.get( studentId ).enrollToCourse( course, courseService );
        }
    }




}
