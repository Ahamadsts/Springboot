package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Company;
import com.example.demo.model.Employee;

public interface CompRepo extends JpaRepository<Company, Integer> {

}
