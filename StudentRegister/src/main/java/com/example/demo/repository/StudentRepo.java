package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> 
{

	
	@Query(value = "select * from Student where name=:name" ,nativeQuery = true)
	Student getbyname(@Param("name") String name);
	
	Student findByName(String name);
	
	@Query(value = "select password from student where name=:name",nativeQuery = true)
	String getpassword(@Param("name")String name);
}
