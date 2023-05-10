package com.dedication.SpringBootMongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dedication.SpringBootMongo.collection.Student;
import com.dedication.SpringBootMongo.repository.StudentRepo;

@Service
public class StudentService {

	
		@Autowired
		StudentRepo studentRepo;
	
	public void saveorUpdate(Student students) {
		
		studentRepo.save(students);
		
		
	}

	public Iterable<Student> listAll() {
		
		
		return studentRepo.findAll();
	}

	public void deleteStudent(String id) {
		
		 studentRepo.deleteById(id);
		
	}

	public Student getStudentByID(String id) {
		
		return studentRepo.findById(id).get();
	}

	
}
