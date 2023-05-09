package com.example.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.student.model.Student;
import com.example.student.repo.StudentRepository;

@SpringBootTest
class StudentDalApplicationTests {

	
	
	@Autowired
	private StudentRepository repo;
	
	
	
	@Test
	void  testCreateStudent() {
		
		Student student = new Student();
		student.setName("John");
		student.setCourse("Serverless using AWS Lamda");
		student.setFee(30d);
		
		repo.save(new Student());
		
		
		
		
		
	}

}
