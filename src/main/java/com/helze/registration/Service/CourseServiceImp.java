package com.helze.registration.Service;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import com.helze.registration.Repository.CourseRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CourseServiceImp implements CourseService{

    private final CourseRep courseRep;

    public CourseServiceImp(CourseRep courseRep) {
        this.courseRep = courseRep;
    }

    @Override
    public ResponseEntity<Course> create(Course course) {
        try{
            Course _course=courseRep.save(new Course(course.getName(),course.getDate(),course.getDuration()));

            return new ResponseEntity<>(_course,HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Course> update(long id, Course course) {
        Optional<Course> courseData=courseRep.findById(id);
        if(courseData.isPresent()){
            Course course1=courseData.get();
            course1.setName(course.getName());
            course1.setDate(course.getDate());
            course1.setDuration(course.getDuration());
            return new ResponseEntity<>(courseRep.save(course1),HttpStatus.OK);
        }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    @Override
    public ResponseEntity<?> deleteAll() {
        try {
            courseRep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }

    @Override
    public ResponseEntity<?> deleteById(long id) {
        try {
            courseRep.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<List<Course>> getAll() {
        try {
           List<Course> course=courseRep.findAll();
           return new ResponseEntity<>(course,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public ResponseEntity<Course> getById(long id) {
        try {
            Course course=courseRep.findById(id).get();
            return new ResponseEntity<>(course,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
