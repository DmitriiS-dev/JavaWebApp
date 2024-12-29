package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    //Get Restful Endpoint
    @GetMapping
    public List<Student> getStudents(){
//        Coming for a Database:
        List<Student> l1 = new ArrayList<Student>();
        Student s = new Student(1L,"Marian","marian@gmail.com",21, LocalDate.of(2003, Month.JANUARY, 5));
        l1.add(s);
        return l1;
    }
}
