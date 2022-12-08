package com.example.demo.service;

import org.springframework.stereotype.Component;

import com.example.demo.model.Student;

@Component
public interface StudentService {

	public Student saveStudent(Student student);
	
	public String deleteStudent(int id);
	
	
}
