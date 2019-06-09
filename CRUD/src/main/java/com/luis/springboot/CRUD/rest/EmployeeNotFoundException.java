package com.luis.springboot.CRUD.rest;

public class EmployeeNotFoundException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8655317859068182601L;

	public EmployeeNotFoundException() {
		super();
	}

	public EmployeeNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public EmployeeNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	
	}

	public EmployeeNotFoundException(String arg0) {
		super(arg0);
		
	}

	public EmployeeNotFoundException(Throwable arg0) {
		super(arg0);
	}

	
	
}
