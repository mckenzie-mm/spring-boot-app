package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

/* 
@Component 	// @Component creates an instance of the Student Service
			// without this anotation the app won't work 
			// now use @Service instead of @Component
*/

@Service
public class StudentService {
    
    public List<Student> getStudents() {
		return List.of(
			new Student(
				1L,
				"Mariam",
				"mariam.jamal@gmail.com",
				LocalDate.of(2000, Month.JANUARY, 5),
				21
			)
		);
	}
}
