package com.ayaz.service.employee;

import java.util.List;

import com.ayaz.domain.employee.Employee;

public interface EmployeeService {

	boolean insert(Employee employee); 
	boolean delete(Employee employee); 
	Employee update(Employee employee); 
	Employee getEmployeeById(Long employeeId); 
	List<Employee> getEmployees(); 
	List<Employee> getEmployeesEntiries(int firstResult, int maxResult); 
	Long countEmployee();
	List<Employee> betweenSalaryEmployees(int minSalary, int maxSalary);
	
}
