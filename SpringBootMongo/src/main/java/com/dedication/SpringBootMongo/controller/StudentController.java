package com.dedication.SpringBootMongo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dedication.SpringBootMongo.collection.Student;
import com.dedication.SpringBootMongo.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@PostMapping("/save")
	public String saveStudent(@RequestBody Student students) {
	
			studentService.saveorUpdate(students);
		return  students.get_id();
	}
	
	@GetMapping("/getAll")
	public Iterable<Student> getStudents(){
		
		return studentService.listAll();
	}
	
	@PutMapping("/edit/{id}")
	public Student updateStudent(@RequestBody Student student ,@PathVariable String id){
		
		student.set_id(id);
		studentService.saveorUpdate(student);
		return student;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable String id) {
		
		studentService.deleteStudent(id);
		return id;
	}
	
	
	@GetMapping("/search/{id}")
	public Student getStudents(@PathVariable String id) {
		
		return studentService.getStudentByID(id);
	}
}
