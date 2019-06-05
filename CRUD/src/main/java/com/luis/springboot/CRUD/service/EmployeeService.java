package com.luis.springboot.CRUD.service;

import java.util.List;

import com.luis.springboot.CRUD.entity.Employee;

public interface EmployeeService {

public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmp);
	
	public void deleteById(int theId);
}
