package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* 
CommandLineRunner is a functional interface in Spring Boot that allows you to execute specific code immediately after the Spring Boot application context has been loaded and the application has started.

Execution on Startup:
Any bean implementing CommandLineRunner will have its run() method automatically executed by Spring Boot once the application context is fully initialized.
Purpose:
It is commonly used for tasks that need to be performed during application startup, such as:
Loading initial data into a database.
Performing validation checks.
Initializing external services or resources.
Executing one-off tasks in a console application.
*/

@Configuration
public class StudentConfig {

    // @Bean instantiates an Object 
    // 
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 5)
			);

            Student alex = new Student(
				"Alex",
				"alex.jamal@gmail.com",
				LocalDate.of(2004, Month.JANUARY, 5)
			);
            
            repository.saveAll(
                List.of(mariam, alex)
            );
        };
    }
    
}
