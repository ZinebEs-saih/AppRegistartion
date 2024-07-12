package com.helze.registration.Service;

import com.helze.registration.Entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

     ResponseEntity<Course> create(Course course);

     ResponseEntity<Course> update(long id,Course course);

     ResponseEntity<?>deleteAll();
     ResponseEntity<?>deleteById(long id);

     ResponseEntity<List<Course>> getAll();
     ResponseEntity<Course>getById(long id);



}
