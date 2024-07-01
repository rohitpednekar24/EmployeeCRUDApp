package edu.dev.EmployeeCRUDApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.dev.EmployeeCRUDApp.dto.Employee;
import edu.dev.EmployeeCRUDApp.repository.EmployeeRepository;



@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @Override
	    public Employee saveEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Employee updateEmployee(Employee employee) {
	        return employeeRepository.save(employee);
	    }

	    @Override
	    public Optional<Employee> getEmployeeById(long id) {
	        return employeeRepository.findById(id);
	    }

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public void deleteEmployee(long id) {
	        employeeRepository.deleteById(id);
	    }
}