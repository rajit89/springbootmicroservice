package com.springfirst.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springfirst.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

	
}
