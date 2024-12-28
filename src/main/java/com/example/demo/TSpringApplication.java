package com.example.demo;

import com.example.demo.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TSpringApplication.class, args);
	}
//	Get Restful Endpoint
	@GetMapping
	public List<Student> hello(){
		List<Student> l1 = new ArrayList<Student>();
		Student s = new Student(1L,"Marian","marian@gmail.com",21,LocalDate.of(2003, Month.JANUARY, 5));
		l1.add(s);
		return l1;
	}


}
