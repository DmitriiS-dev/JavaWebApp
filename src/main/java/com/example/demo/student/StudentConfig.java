package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student marian = new Student("Marian","marian@gmail.com",21, LocalDate.of(2003, Month.JANUARY, 5));
            Student alex = new Student("Alex","alex@gmail.com",23, LocalDate.of(2001, Month.JANUARY, 5));

            repository.saveAll(
                    List.of(marian,alex)
            );
        };
    }
}
