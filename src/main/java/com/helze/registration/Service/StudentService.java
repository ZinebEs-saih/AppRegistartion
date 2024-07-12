package com.helze.registration.Service;

import com.helze.registration.Entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {

    ResponseEntity<Student> create(Student student);

    ResponseEntity<List<Student>> getAll();
    ResponseEntity<Student> getById(long id);


    ResponseEntity<Student>  update(long id,Student student);

    ResponseEntity<?> delete(long id);
    ResponseEntity<?> deleteAll();

    ResponseEntity<Student>  register(long id, long id_course);
}
