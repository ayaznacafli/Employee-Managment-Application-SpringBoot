package com.ayaz.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.employee.Employee;
import com.ayaz.repository.employee.EmployeeRepository;
import com.ayaz.service.employee.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public boolean insert(Employee employee) {
		if(employee != null) {
			employeeRepository.save(employee);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Employee employee) {
		if(employee != null) {
			employeeRepository.delete(employee);
			return true;
		}else {
			Employee deleteEmployee = getEmployeeById(employee.getEmployeeId());
			employeeRepository.delete(deleteEmployee);
			return true;
		}
	}

	@Override
	public Employee update(Employee employee) {
	   	if(employee != null) {
			employeeRepository.save(employee);
			return employee;
		}else {
			Employee updateEmployee = getEmployeeById(employee.getEmployeeId());
			employeeRepository.save(updateEmployee);
			return updateEmployee;
		}
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeesEntiries(int firstResult, int maxResult) {
		return null;
	}

	@Override
	public Long countEmployee() {
		return employeeRepository.findCount();
	}

	@Override
	public List<Employee> betweenSalaryEmployees(int minSalary, int maxSalary) {
		return employeeRepository.findBetweenSalaryEmployees(minSalary, maxSalary);
	}

}
