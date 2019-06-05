package com.luis.springboot.CRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luis.springboot.CRUD.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager theEM) {
		entityManager= theEM;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		Session cs = entityManager.unwrap(Session.class);
		
		Query<Employee> theQuery = cs.createQuery("from Employee",Employee.class);
		
		List<Employee> emp = theQuery.getResultList();
		
		
		return emp;
	}


	@Override
	public Employee findById(int theId) {
		
		Session cs = entityManager.unwrap(Session.class);
		
		Employee theEmp = cs.get(Employee.class, theId);
		
		return theEmp;
	}


	@Override
	public void save(Employee theEmp) {

		Session cs = entityManager.unwrap(Session.class);
		
		cs.saveOrUpdate(theEmp);
		
	}


	@Override
	public void deleteById(int theId) {

		Session cs = entityManager.unwrap(Session.class);
		
		Query theQ= cs.createQuery("delete from Employee where id=:employeeId");
		theQ.setParameter("employeeId", theId);
		
		theQ.executeUpdate();
	}

}
