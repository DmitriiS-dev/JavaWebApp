package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Get Restful Endpoint
    @GetMapping
    public List<Student> getStudents(){
//        Coming for a Database:
        return studentRepository.findAll();
    }

//    Post Restful Endpoint
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()){
            throw new IllegalStateException("Email Taken");
        }

        studentRepository.save(student);
        System.out.println(student);

    }

//    Deletes API Endpoint
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("student with id "+ studentId);
        }
        studentRepository.deleteById(studentId);
    }
}
