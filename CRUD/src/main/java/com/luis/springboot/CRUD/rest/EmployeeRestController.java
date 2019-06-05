package com.luis.springboot.CRUD.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luis.springboot.CRUD.entity.Employee;
import com.luis.springboot.CRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService empService;
	
	@Autowired
	public EmployeeRestController(EmployeeService theEmp) {
		empService = theEmp;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return empService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		
		Employee theEmps = empService.findById(employeeId);
		
		if(theEmps == null) {
			throw new RuntimeException("Employee id not found");
		}
		
		return theEmps;
	}
	
	@PostMapping("/employees")
	public Employee post(@RequestBody Employee emp) {
		
		emp.setId(0);
		empService.save(emp);
		return emp;
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee emp) {
		
		empService.save(emp);
		
		return emp;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String delete(@PathVariable int employeeId) {
		
		Employee tempEmp = empService.findById(employeeId);
		
		if(tempEmp==null) {
			
			throw new RuntimeException("Employee id not found");
		}
		
		empService.deleteById(employeeId);
		
		return "deleted employee";
		
	}

}
