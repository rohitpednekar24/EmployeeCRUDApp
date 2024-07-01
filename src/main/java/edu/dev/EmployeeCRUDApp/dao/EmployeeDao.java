package edu.dev.EmployeeCRUDApp.dao;

import java.util.List;
import java.util.Optional;

import edu.dev.EmployeeCRUDApp.dto.Employee;



public interface EmployeeDao {
	Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    Optional<Employee> getEmployeeById(long id);
    List<Employee> getAllEmployees();
    void deleteEmployee(long id);
}
