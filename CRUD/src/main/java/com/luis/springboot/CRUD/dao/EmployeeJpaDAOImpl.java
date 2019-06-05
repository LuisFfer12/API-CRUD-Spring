package com.luis.springboot.CRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luis.springboot.CRUD.entity.Employee;

@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO {

	private EntityManager entM;
	
	@Autowired
	public EmployeeJpaDAOImpl(EntityManager theEntM) {
		entM = theEntM;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		Query theQ= entM.createQuery("from Employee");
		
		List<Employee> emp = theQ.getResultList();
		
		return emp;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee emp = entM.find(Employee.class, theId);
		
		return emp;
	}

	@Override
	public void save(Employee theEmp) {
		
		Employee dbEmp= entM.merge(theEmp);
		
		theEmp.setId(dbEmp.getId());
	}

	@Override
	public void deleteById(int theId) {

		Query theQ = entM.createQuery("delete from Employee where id=:employeeId");
		theQ.setParameter("employeeId", theId);
		
		theQ.executeUpdate();
		
	}

}
