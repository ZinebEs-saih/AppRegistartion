package com.helze.registration.Repository;

import com.helze.registration.Entity.Course;
import com.helze.registration.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRep extends JpaRepository<Course,Long> {
}
