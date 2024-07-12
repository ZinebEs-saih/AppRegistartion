package com.helze.registration.Repository;

import com.helze.registration.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRep extends JpaRepository<Student,Long> {
}
