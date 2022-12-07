package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.CompRepo;
import com.example.demo.serviceimpl.ServiveImplementaion;

@RestController
public class Controller {
	
	
	@Autowired
	ServiveImplementaion serviceimp;
	@Autowired
	CompRepo comprepo;
	
	
	@RequestMapping("SaveCompany")
	public String SaveCompany(@RequestBody Company company)
	{
		try
		{
		String savecompany = this.serviceimp.savecompany(company);
		return savecompany;
		}
		catch (Exception e)
		{
		return "Something Went Wrong";
		}
	}
	
	@RequestMapping("Saveincomp{compid}")
	public String saveempincomp(@PathVariable int compid,@RequestBody Employee emp)
	{
		try
		{
			String savedemp=this.serviceimp.saveEmpInCompany(compid,emp);
			return savedemp;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("getAllEmp{compid}")
	public List<Employee> getAllEmp(@PathVariable int compid)
	{
		try
		{
			Company company= comprepo.findById(compid).get();
			List<Employee> list = company.getEmployee();
			 return list;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping("delete{compid}and{empid}")
	public String delete(@PathVariable int compid,@PathVariable int empid)
	{
		try
		{
			return this.serviceimp.deleteEmpFromCompany(compid, empid);
		}
		catch (Exception e)
		{
			return "Somethig Went Wrong";
		}
	}

}
