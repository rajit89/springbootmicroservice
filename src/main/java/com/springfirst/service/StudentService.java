package com.springfirst.service;

import java.util.List;

import com.springfirst.model.Student;

public interface StudentService {
	
	Student save(Student student);
	
	Student findById(int id);
	
	List<Student> findAll();

}
