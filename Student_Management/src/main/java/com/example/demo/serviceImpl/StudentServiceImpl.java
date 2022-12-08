package com.example.demo.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.SubjectRepo;
import com.example.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
	{
	
	@Autowired
	StudentRepo studentrepo;
	
	@Autowired
	SubjectRepo subjectrepo;
	
	@Override
	public Student saveStudent(Student student) 
	{
		try
		{
		Student st=new Student();
		st.setFirstName(student.getFirstName());
		st.setLastName(student.getLastName());
		st.setEmail(student.getEmail());
		st.setAddress(student.getAddress());
		st.setStandard(student.getStandard());
		st.setSubject(student.getSubject());
		
		Student savedstudent = studentrepo.save(st);
		System.out.println("Student Saved Successfully");
		return savedstudent;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteStudent(int studentid) 
	{
		
		try 
		{
			studentrepo.deleteById(studentid);
			System.out.println("Student Deleted Successfully");
			return "Student Deleted Successfully";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}
}
