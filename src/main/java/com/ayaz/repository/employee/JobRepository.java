package com.ayaz.repository.employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.employee.Job;

public interface JobRepository extends CrudRepository<Job, Long> {

	
	@Query("SELECT j.jobTitle FROM Job j")
	List<String> findJobTitles();
	
	
	
}
