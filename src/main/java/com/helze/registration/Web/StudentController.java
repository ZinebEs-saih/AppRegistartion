package com.helze.registration.Web;

import com.helze.registration.Entity.Student;
import com.helze.registration.Service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/create")
    public ResponseEntity<Student> create(@RequestBody Student student){
        return studentService.create(student);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAll(){
        return studentService.getAll();
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student >getById(@PathVariable long id){
        return studentService.getById(id);
    }


    @PutMapping("student/{id}")
    public ResponseEntity<Student> update(@PathVariable long id,@RequestBody Student student){
        return studentService.update(id,student);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?>deleteById(@PathVariable long id){
        return studentService.delete(id);
    }
    @DeleteMapping("/student")
    public ResponseEntity<?>deleteAll(){
        return studentService.deleteAll();
    }
    @RequestMapping(value = "/student/{id_s}/register{id_c}",method = RequestMethod.POST)
    public ResponseEntity<Student>register(@PathVariable long id_s , @PathVariable long id_c){
        return studentService.register(id_s,id_c);
    }
}
