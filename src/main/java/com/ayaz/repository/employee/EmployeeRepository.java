package com.ayaz.repository.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ayaz.domain.employee.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
	
	@Query("SELECT count(e) FROM Employee e")
	Long findCount();
	
	
	@Query("SELECT e FROM Employee e WHERE e.salary > :minSalary AND e.salary < :maxSalary")
	List<Employee> findBetweenSalaryEmployees(@Param("minSalary")int minSalary, @Param("maxSalary")int maxSalary);

}
