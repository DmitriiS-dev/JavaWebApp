package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//Interface Resposible for the Data Access:
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


//this is JBQL and not straight sql (Student is the class not the DB)
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    //    Find a User By Email - Transformed to an SQL
    Optional<Student> findStudentByEmail(String email);
}
