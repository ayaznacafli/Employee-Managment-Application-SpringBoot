package com.ayaz.repository.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.employee.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	@Query("SELECT d.departmentName FROM Department d ")
	List<String> findAllNames();

}
