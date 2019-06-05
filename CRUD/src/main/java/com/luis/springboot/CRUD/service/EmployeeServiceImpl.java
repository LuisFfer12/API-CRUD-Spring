package com.luis.springboot.CRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luis.springboot.CRUD.dao.EmployeeDAO;
import com.luis.springboot.CRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO empDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeJpaDAOImpl") EmployeeDAO theEmp) {
		empDAO = theEmp;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {

		return empDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		return empDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmp) {
		empDAO.save(theEmp);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		empDAO.deleteById(theId);
	}

}
