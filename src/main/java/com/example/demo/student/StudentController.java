package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    //Get Restful Endpoint
    @GetMapping
    public List<Student> hello(){
        List<Student> l1 = new ArrayList<Student>();
        Student s = new Student(1L,"Marian","marian@gmail.com",21, LocalDate.of(2003, Month.JANUARY, 5));
        l1.add(s);
        return l1;
    }
}
