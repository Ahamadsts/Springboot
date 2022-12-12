package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.serviceImpl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentserviceimp;
	
	@Autowired
	StudentRepo studentrepo;
	
	
	@RequestMapping("saveStudent")
	public String register(@RequestBody Student student)
	{
		try
		{
			String st = this.studentserviceimp.registerStudent(student);
			if(st!=null)
			return "Student Saved";
			else
				return "Student Not Saved Something Went Wrong";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
		
	}
	
	@RequestMapping("deleteStudent")
	public String delete(@RequestParam int studentId)
	{
		try
		{
			this.studentserviceimp.deleteStudent(studentId);
			return "Student Deleted Successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}
	
	@RequestMapping("updateStudent")
	public Student Update(@RequestBody Student student)
	{
		try
		{
			Student updatedStudent = this.studentserviceimp.updateStudent(student);
			return updatedStudent;
		}
		catch (Exception e)
		{
		e.printStackTrace();
		return null;
		}
	}
	
	@RequestMapping("getAllStudent")
	public List<Student> ViewAllStudent()
	{
		try
		{
			List<Student> list = this.studentserviceimp.getAllStudent();
			return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("getByName")
	public Student get(@RequestParam String name)
	{
		try 
		{
			Student student = this.studentrepo.getbyname(name);
			return student;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("getPassword")
	public String getPassword(String name)
	{
		return 	this.studentserviceimp.getPassword(name);
	}
}
