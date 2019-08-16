package com.ayaz.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.employee.Job;
import com.ayaz.repository.employee.JobRepository;
import com.ayaz.service.employee.JobService;


@Service
public class JobServiceImpl implements JobService{
	
	
	@Autowired
	private JobRepository jobRepository;

	@Override
	public boolean insert(Job job) {
		if(job != null) {
			jobRepository.save(job);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Job job) {
		if(job != null) {
			jobRepository.delete(job);
			return true;
		}else {
			Job deleteJob = getJobById(job.getJobId());
			jobRepository.delete(deleteJob);
			return true;
		}
	}

	@Override
	public Job update(Job job) {
		if(job != null) {
			jobRepository.save(job);
			return job;
		}else {
			Job updateJob = getJobById(job.getJobId());
			jobRepository.save(updateJob);
			return updateJob;
		}
	}

	@Override
	public Job getJobById(Long jobId) {
		return jobRepository.findById(jobId).get();
	}

	@Override
	public List<Job> getJobs() {
		return (List<Job>) jobRepository.findAll();
	}

	@Override
	public List<String> getJobTitles() {
		return jobRepository.findJobTitles();
	}

}
