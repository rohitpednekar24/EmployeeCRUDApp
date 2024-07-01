package edu.dev.EmployeeCRUDApp.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
