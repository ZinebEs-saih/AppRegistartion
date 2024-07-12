package com.helze.registration.Service;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    ResponseEntity<List<Student>> getCourseStudents(long id);

    ResponseEntity<List<Course>> getStudentCourses(long id);
    ResponseEntity<List<Student>> getStudentsWithoutAnyCourses();
    ResponseEntity<List<Course>> getCoursesWithoutAnyStudents();



}
