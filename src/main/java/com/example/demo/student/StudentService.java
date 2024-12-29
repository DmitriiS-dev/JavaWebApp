package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
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

//    Delete API Endpoint
    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists){
            throw new IllegalStateException("student with id "+ studentId);
        }
        studentRepository.deleteById(studentId);
    }

//    Update API Endpoint
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with Id "+ studentId + " was not found!"
                )
        );
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email Taken!");
            }
            System.out.println("should update the Email");
            student.setEmail(email);
        }
    }
}
