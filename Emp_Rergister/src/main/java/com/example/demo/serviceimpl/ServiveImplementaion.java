package com.example.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;
import com.example.demo.repository.CompRepo;
import com.example.demo.repository.EmpRepo;
import com.example.demo.service.ComapanyService;

@Component
public class ServiveImplementaion  implements ComapanyService{

	@Autowired
	CompRepo comprepo;
	
	@Autowired
	EmpRepo emprepo;
	

	@Override
	public String saveEmpInCompany(int compid,Employee emp)
	{
		try
		{
			Company company=comprepo.findById(compid).get();
			List<Employee> list = company.getEmployee();
			list.add(emp);
			company.setEmployee(list);
			comprepo.save(company);
			return "Successfully Saved";
		}
		catch (Exception e)
		{
			return "Something Went Wrong";
		}
	}

	@Override
	public String deleteEmpFromCompany(int compid,int empid) 
	{
		try
		{
			Company company=comprepo.findById(compid).get();
			
			List<Employee> list = company.getEmployee();
			for(Employee emp:list)
			{
				if(emp.getEmpid()==empid)
				{
					list.remove(emp);
					break;
				}
			}
			comprepo.save(company);
			return "Successfully deleted ";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
	}

	@Override
	public String savecompany( Company comp)
	{
		try
		{
			Company company=new Company();
			company.setName(comp.getName());
			comprepo.save(company);
			return "Successfully Saved";
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "Something Went Wrong";
		}
		
	}

}
