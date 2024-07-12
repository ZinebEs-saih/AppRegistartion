package com.helze.registration.Web;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import com.helze.registration.Service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/report/course/{id}/student")
    public ResponseEntity<List<Student>>getCourseStudents(@PathVariable long id){
        return reportService.getCourseStudents(id);
    }
    @GetMapping("/report/student/{id}/course")
    public ResponseEntity<List<Course>>getStudentCourse(@PathVariable long id){
        return reportService.getStudentCourses(id);
    }

    @GetMapping("/report/coursesWithoutAnyStudents")
    public ResponseEntity<List<Course>>getCoursesWithoutAnyStudent(){
        return reportService.getCoursesWithoutAnyStudents();
    }

    @GetMapping("/report/getStudentsWithoutAnyCourses")
    public ResponseEntity<List<Student>>getStudentsWithouAnuCourse(){
        return reportService.getStudentsWithoutAnyCourses();
    }
}
