package com.helze.registration.Service;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import com.helze.registration.Repository.CourseRep;
import com.helze.registration.Repository.StudentRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImp implements ReportService {

    private final StudentRep studentRep;
    private final CourseRep courseRep;

    public ReportServiceImp(StudentRep studentRep, CourseRep courseRep) {
        this.studentRep = studentRep;
        this.courseRep = courseRep;
    }

    @Override
    public ResponseEntity<List<Student>> getCourseStudents(long id) {
        Optional<Course> courseData = courseRep.findById(id);

        if (courseData.isPresent()) {
            Course course = courseData.get();
            return new ResponseEntity<>(new ArrayList<Student>(course.getStudentSet()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Course>> getStudentCourses(long id) {
        Optional<Student> studentData = studentRep.findById(id);

        if (studentData.isPresent()) {
            Student student = studentData.get();
            return new ResponseEntity<>(new ArrayList<Course>(student.getCourseset()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Student>> getStudentsWithoutAnyCourses() {
        try {

            List<Student> students=studentRep.findAll().stream().filter(p->p.getCourseset().size()==0)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(students,HttpStatus.OK);


        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Course>> getCoursesWithoutAnyStudents() {
        try {
            List<Course> courses=courseRep.findAll().stream().filter(p->p.getStudentSet().size()==0)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(courses,HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
