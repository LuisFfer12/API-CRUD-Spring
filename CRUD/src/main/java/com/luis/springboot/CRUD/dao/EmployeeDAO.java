package com.luis.springboot.CRUD.dao;

import java.util.List;

import com.luis.springboot.CRUD.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmp);
	
	public void deleteById(int theId);
	
	
}
