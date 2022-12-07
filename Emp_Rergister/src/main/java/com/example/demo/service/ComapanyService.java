package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;

@Service
public interface ComapanyService {
	
	
	public String saveEmpInCompany(int compid,Employee emp);
	
	public String deleteEmpFromCompany(int compid,int empid);
	
	public String savecompany(Company comp);

}
