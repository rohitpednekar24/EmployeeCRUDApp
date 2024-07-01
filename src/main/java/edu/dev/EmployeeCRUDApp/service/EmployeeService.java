package edu.dev.EmployeeCRUDApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.dev.EmployeeCRUDApp.dto.Employee;
import edu.dev.EmployeeCRUDApp.dto.ResponseStructure;
import edu.dev.EmployeeCRUDApp.exception.EmployeeNotFoundException;
import edu.dev.EmployeeCRUDApp.exception.EmployeeNotSavedException;
import edu.dev.EmployeeCRUDApp.repository.EmployeeRepository;



@Service
public class EmployeeService {
	
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    public ResponseStructure<Employee> saveEmployee(Employee employee) {
	        ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
	        try {
	            Employee savedEmployee = employeeRepository.save(employee);
	            responseStructure.setStatus("success");
	            responseStructure.setMessage("Employee saved successfully");
	            responseStructure.setData(savedEmployee);
	        } catch (Exception e) {
	            throw new EmployeeNotSavedException("Failed to save employee");
	        }
	        return responseStructure;
	    }

	    public ResponseStructure<Employee> updateEmployee(long id, Employee employee) {
	        ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            Employee existingEmployee = optionalEmployee.get();
	            existingEmployee.setName(employee.getName());
	            existingEmployee.setJoiningDate(employee.getJoiningDate());
	            existingEmployee.setGender(employee.getGender());
	            existingEmployee.setSalary(employee.getSalary());
	            existingEmployee.setRole(employee.getRole());
	            existingEmployee.setAddress(employee.getAddress());
	            Employee updatedEmployee = employeeRepository.save(existingEmployee);
	            responseStructure.setStatus("success");
	            responseStructure.setMessage("Employee updated successfully");
	            responseStructure.setData(updatedEmployee);
	        } else {
	            throw new EmployeeNotFoundException("Employee not found with id: " + id);
	        }
	        return responseStructure;
	    }

	    public ResponseStructure<Employee> getEmployeeById(long id) {
	        ResponseStructure<Employee> responseStructure = new ResponseStructure<>();
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            responseStructure.setStatus("success");
	            responseStructure.setMessage("Employee found");
	            responseStructure.setData(optionalEmployee.get());
	        } else {
	            throw new EmployeeNotFoundException("Employee not found with id: " + id);
	        }
	        return responseStructure;
	    }

	    public ResponseStructure<List<Employee>> getAllEmployees() {
	        ResponseStructure<List<Employee>> responseStructure = new ResponseStructure<>();
	        List<Employee> employees = employeeRepository.findAll();
	        responseStructure.setStatus("success");
	        responseStructure.setMessage("Employees retrieved successfully");
	        responseStructure.setData(employees);
	        return responseStructure;
	    }

	    public ResponseStructure<String> deleteEmployee(long id) {
	        ResponseStructure<String> responseStructure = new ResponseStructure<>();
	        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
	        if (optionalEmployee.isPresent()) {
	            employeeRepository.deleteById(id);
	            responseStructure.setStatus("success");
	            responseStructure.setMessage("Employee deleted successfully");
	            responseStructure.setData("Employee with id " + id + " deleted");
	        } else {
	            throw new EmployeeNotFoundException("Employee not found with id: " + id);
	        }
	        return responseStructure;
	    }

	
}

