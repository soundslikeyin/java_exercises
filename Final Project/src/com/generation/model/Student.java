package com.generation.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.generation.service.CourseService;


public class Student
    extends Person
    implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>(); // enroll list of courses that student wants to take

    private final Map<String, Course> approvedCourses = new HashMap<>(); // courses approved to take

    public Student( String id, String name, String email, LocalDate birthDate )
    {
        super( id, name, email, birthDate );
    }

    private final Map<String, Integer> grades = new HashMap<>(); //key is courseCode and grade is an integer

    public void enrollToCourse( Course course, CourseService courseService )
    {
        if (!this.courses.contains(course)) { // if course not already enrolled
            this.courses.add(course); //add course into enroll list
            if (isCourseApproved(course, courseService)) { // if course is approved
                registerApprovedCourse(course); // add it into approved course
            }
        }
    }


    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( Course course, CourseService courseService )
    {
        for (String moduleCode: course.getModule().getPrerequisites().keySet()) { // get prerequisite modules
            // for each prerequisite module get courses within the module
            // for every course required, check if student has or is enrolling for it
            for (Course courseRequired: courseService.getCoursesOfModule(moduleCode)) {
                if (!courses.contains(courseRequired)) {
                    return false; // course is not approved
                }
            }
        }
        return true;
    }

    public boolean hasBeenGraded(String courseCode){
        return this.grades.containsKey(courseCode);
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses( Course course )
    {
        //TODO implement this method
        return null;
    }

    public boolean isAttendingCourse( String courseCode )
    {
        return this.approvedCourses.containsKey(courseCode);
    }

    public void addGrade(String courseCode, int grade) {

        if (isAttendingCourse(courseCode)) {
            this.grades.put(courseCode, grade);
        } else {
            System.out.println("Course Code is invalid. Student is not attending this course");
        }

    }

    public int getGrade(String courseCode){
        return this.grades.get(courseCode);
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        return new ArrayList<>(this.approvedCourses.values());
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}
