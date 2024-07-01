package edu.dev.EmployeeCRUDApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.dev.EmployeeCRUDApp.dto.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
