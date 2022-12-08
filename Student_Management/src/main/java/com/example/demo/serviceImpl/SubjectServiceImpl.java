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
		try 
		{
			Student student = studentrepo.findById(studentId).get();
			List<Subject> list = student.getSubject();
			System.out.println("List Of Subjects : "+list);
			return list;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String deleteSubject(int studId, int subId)
	{
		try 
		{
			Student student = studentrepo.findById(studId).get();
			List<Subject> list = student.getSubject();
			int count=0;
			for (Subject sub : list) 
			{
				if(sub.getId()==subId)
				{
					list.remove(sub);
					count++;
					break;
				}
			}
			if(count!=0)
			{
				studentrepo.save(student);
				subjectrepo.deleteById(subId);
				System.out.println("Subject Deleted Successfully");
				return "Subject Deleted Successfully";
			}
			else
			{
				System.out.println("Subject Not Deleted");
				return "Subject Not Deleted";
			}
		} 
		catch (Exception e) 
		{
			e.getMessage();
			return "Something Went Wrong";
		}
	}
}
