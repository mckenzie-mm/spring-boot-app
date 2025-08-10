package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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
		Optional<Student> studentOptional =
		studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException(
				"student with id " + studentId + " does not exist");
		}
		studentRepository.deleteById(studentId);
    }

	@Transactional // entity is in managed state. If one fails, then all fails
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
			.orElseThrow(() -> new IllegalStateException(
				"student with id " + studentId + " does not exist"
			));
		if (name != null && name.length() > 0 &&
			!Objects.equals(student.getName(), name)) {
			student.setName(name);
		}

		if (email != null && email.length() > 0 &&
			!Objects.equals(student.getEmail(), email)) {

			Optional<Student> studentOptional =
				studentRepository.findStudentByEmail(student.getEmail());

			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			student.setEmail(email);
		}
    }
}
