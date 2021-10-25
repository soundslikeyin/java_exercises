package com.generation.test;

import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StudentServiceTest
{

    @Test
    public void subscribeStudentTest(){
        // setup
        final StudentService studentService = new StudentService();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse("10-30-1979", dateFormatter);
        Student testStudent = new Student( "5", "Yin", "yin@yin.com", birthDate );

        // execute method with test data
        studentService.subscribeStudent(testStudent);

        // verify that student is added correctly
        assertTrue(studentService.isSubscribed(testStudent.getId()));
    }

    @Test
    public void enrollToCourseTest(){
        // setup
        final StudentService studentService = new StudentService();
        final CourseService courseService = new CourseService();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse("10-30-1979", dateFormatter);
        Student testStudent = new Student( "5", "Yin", "yin@yin.com", birthDate );
        studentService.subscribeStudent(testStudent);

        // execute method with test data
        studentService.enrollToCourse("5", courseService.getCourse("INTRO-CS-1"), courseService);
        studentService.enrollToCourse("5", courseService.getCourse("INTRO-WEB-1"), courseService);

        // verify that test student is enrolled to course per course approval
        assertAll(
                () -> assertTrue(testStudent.isCourseApproved(courseService.getCourse("INTRO-CS-1"), courseService)),
                () -> assertTrue(testStudent.isAttendingCourse("INTRO-CS-1")), // no prerequisite
                () -> assertFalse(testStudent.isCourseApproved(courseService.getCourse("INTRO-WEB-1"), courseService)),
                () -> assertFalse(testStudent.isAttendingCourse("INTRO-WEB-1")) // prerequisite not fulfiled
        );


    }


}
