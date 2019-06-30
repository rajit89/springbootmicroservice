package com.springfirst.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springfirst.model.Student;
import com.springfirst.service.StudentService;

@RestController
@RequestMapping(value = "/myrequest")
public class Springcontroller {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(value="/hello")
	public String showHelloworld() {
		return "Hello World from Get Mapping";
	}
	
	@PostMapping(value="/hello")
	public String showHelloworldPost() {
		return "Hello World from Post Mapping";
	}
	
	@PostMapping(value="/student")
	public Student save(@RequestBody Student student) {
		
		return studentService.save(student);
	}
	
	@GetMapping(value="/getStudentById/{idVal}")
	public ResponseEntity<Student> getStudent(@PathVariable("idVal")  int id) {
		Student students = studentService.findById(id);
		if(!(students==null)) {
			return ResponseEntity.ok().body(students);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping(value="/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> students = studentService.findAll();
		if(students != null) {
			return ResponseEntity.ok().body(students);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
}
