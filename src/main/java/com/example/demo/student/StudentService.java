package com.example.demo.student;

import java.util.List;

import org.springframework.stereotype.Service;

/* 
@Component 	// @Component creates an instance of the Student Service
			// without this anotation the app won't work 
			// now use @Service instead of @Component
*/

@Service
public class StudentService {

	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
    
    public List<Student> getStudents() {
		return studentRepository.findAll();
	}

    public void addNewStudent(Student student) {
        System.out.println(student);
    }
}
