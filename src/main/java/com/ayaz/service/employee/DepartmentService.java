package com.ayaz.service.employee;

import java.util.List;

import com.ayaz.domain.employee.Department;

public interface DepartmentService {

	
	boolean insert(Department department);
	boolean delete(Department department); 
	Department update(Department department);
	Department getDerpatmentById(Long departmentId); 
	List<Department> getDepartments(); 
	List<Department> getDepartmentsEntiries(int firstResult, int maxResult);
	List<String> getDepartmentNames();
}
