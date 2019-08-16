package com.ayaz.service.employee;

import java.util.List;

import com.ayaz.domain.employee.Job;

public interface JobService {

	
	boolean insert(Job job); 
	boolean delete(Job job); 
	Job update(Job job); 
	Job getJobById(Long jobId);
	List<Job> getJobs();
	List<String> getJobTitles();
}
