package com.springfirst.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springfirst.model.Student;
import com.springfirst.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findById(int id) {
		Optional<Student> studentOpt = studentRepository.findById(id);
		if (studentOpt.isPresent()) {
			return studentOpt.get();
		} else
			return null;
	}
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
}
