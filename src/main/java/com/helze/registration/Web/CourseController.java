package com.helze.registration.Web;

import com.helze.registration.Entity.Course;
import com.helze.registration.Service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping("/createCourse")
    public ResponseEntity<Course> create(@RequestBody Course course){
        return courseService.create(course);
    }
    @GetMapping("/courses")
    public ResponseEntity<List<Course>>getAll(){
        return courseService.getAll();
    }
    @GetMapping("/course/{id}")
    public ResponseEntity<Course>getById(@PathVariable long id){
        return courseService.getById(id);
    }
    @PutMapping("/course/{id}")
    public ResponseEntity<Course>update(@PathVariable long id, Course course){
        return courseService.update(id,course);
    }
    @DeleteMapping("/courses")
    public ResponseEntity<?>deleteAll(){
        return courseService.deleteAll();
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        return courseService.deleteById(id);
    }
}
