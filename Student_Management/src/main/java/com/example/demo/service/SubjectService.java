package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Subject;
public interface SubjectService {
	
	
	public List<Subject> getAllSubjectOfStudent(int studentId);
	
	public String deleteSubject(int subid);

}
