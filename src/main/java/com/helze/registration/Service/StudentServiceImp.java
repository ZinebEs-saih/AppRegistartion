package com.helze.registration.Service;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import com.helze.registration.RegistrationApplication;
import com.helze.registration.Repository.CourseRep;
import com.helze.registration.Repository.StudentRep;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImp implements StudentService{


    private final StudentRep studentRep;
    private final CourseRep courseRep;
    public StudentServiceImp(StudentRep studentRep, CourseRep courseRep) {
        this.studentRep = studentRep;
        this.courseRep = courseRep;
    }
    @Override
    public ResponseEntity<Student> create(Student student) {
        try {
            Student _student = studentRep.save(
                    new Student(student.getFirstName(), student.getLastName(),student.getCne(),student.getDateOfBirth(),student.getAddress()));
            return new ResponseEntity<>(_student, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public  ResponseEntity<List<Student>> getAll() {
        try{
        List<Student> students= studentRep.findAll();

            return new ResponseEntity<>(students, HttpStatus.OK);

        }catch (Exception ex){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Student> getById(long id) {
        Optional<Student> studentData= studentRep.findById(id);
        if(studentData.isPresent()){
            return new ResponseEntity<>(studentData.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Student>  update(long id,Student student) {
        Optional<Student> StudentData=studentRep.findById(id);
        if(StudentData.isPresent()){
            Student _student= StudentData.get();
            _student.setFirstName(student.getFirstName());
            _student.setLastName(student.getLastName());
            _student.setCne(student.getCne());
            _student.setAddress(student.getAddress());
            _student.setDateOfBirth(student.getDateOfBirth());
            return new ResponseEntity<>(studentRep.save(_student),HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<?> delete(long id) {
        try{
          studentRep.deleteById(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(Exception ex){
            return new ResponseEntity<>(ex,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> deleteAll() {
        try{
            studentRep.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Student> register(long id, long id_course) {
       Optional<Student> _student = studentRep.findById(id);
       Optional<Course> _course = courseRep.findById(id_course);
        if(_student.isPresent() && _course.isPresent()){
           Student student=_student.get();
           Course couse=_course.get();
           if(student.getCourseset().size()< RegistrationApplication.Course_Limit
               && couse.getStudentSet().size()<RegistrationApplication.Student_Limit ){
               student.getCourseset().add(couse);
               return new ResponseEntity<>(studentRep.save(student),HttpStatus.OK);
           }
        }else{
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
