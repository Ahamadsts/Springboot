package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.model.Subject;
import com.example.demo.repository.StudentRepo;
import com.example.demo.repository.SubjectRepo;
import com.example.demo.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired 
	StudentRepo studentrepo;
	
	@Autowired 
	SubjectRepo subjectrepo;

	@Override
	public List<Subject> getAllSubjectOfStudent(int studentId) 
	{
		
	  Student saved_student=this.studentrepo.findById(studentId).orElseThrow();
	  if(saved_student==null) {
		  return null;
	  }
	       List<Subject> list= this.subjectrepo.getAll(studentId);
	       return list;
		}
	@Override
	public String deleteSubject( int subId)
	{
		try 
		{
		subjectrepo.deleteById(subId);
		return "Successfully Deleted";
		} 
		
		catch (Exception e) 
		{
			e.getMessage();
			return "Something Went Wrong";
		}
	}
}
