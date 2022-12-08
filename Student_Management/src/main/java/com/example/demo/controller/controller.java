package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.service.StudentService;
import com.example.demo.serviceImpl.StudentServiceImpl;
import com.example.demo.serviceImpl.SubjectServiceImpl;

@RestController
public class controller {
	
	@Autowired
	StudentServiceImpl studserviceimpl;
	
	@Autowired
	SubjectServiceImpl subserviceimpl;
	
	
	@RequestMapping("savestudent")
	public Student saveStudent(@RequestBody Student student)
	{
		return studserviceimpl.saveStudent(student);
	}
	
	
	@RequestMapping("deletestudent{studentId}")
	public String deleteStudent(@PathVariable int studentId)
	{
		return  studserviceimpl.deleteStudent(studentId);

	}
	
	@RequestMapping("getAllSubject{studentId}")
	public List<Subject> getAllSubjectOfStudent(@PathVariable int studentId)
	{
		return subserviceimpl.getAllSubjectOfStudent(studentId);
	}
	
	@RequestMapping("deleteSubject{studId}/{subId}")
	public String deleteSubject(@PathVariable int studId,@PathVariable int subId)
	{
		return subserviceimpl.deleteSubject(studId,subId);
		
	}
	
}
