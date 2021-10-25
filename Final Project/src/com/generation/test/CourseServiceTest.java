package com.generation.test;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;


public class CourseServiceTest {

    @Test
    public void registerCourseTest(){
    //  setup
        final CourseService courseService = new CourseService();
        Module testModule = new Module( "testModule", "TestModule",
                "Test Module" );

    //  execute method with test data
        courseService.registerCourse( new Course( "testCourse", "Test Course", 4, testModule));

    //  verify that test course is created correctly
        assertEquals("Test Course", courseService.getCourse("testCourse").getName());
    }

    @Test
    public void enrollStudentTest(){
    //  setup
        final CourseService courseService = new CourseService();
        final StudentService studentService = new StudentService();
        Module testModule = new Module( "testModule", "TestModule",
                "Test Module" );
        courseService.registerCourse( new Course( "testCourse", "Test Course", 4, testModule));

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate birthDate = LocalDate.parse("10-30-1979", dateFormatter);
        Student testStudent = new Student( "5", "Yin", "yin@yin.com", birthDate );
        studentService.subscribeStudent(testStudent);

    //  execute method with test data
        courseService.enrollStudent( "testCourse", testStudent );

    //  verify that test student is enrolled correctly
         assertTrue(courseService.getStudents("testCourse").contains(testStudent));
    }

}
