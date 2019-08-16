package com.ayaz.service.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.employee.Department;
import com.ayaz.repository.employee.DepartmentRepository;
import com.ayaz.service.employee.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean insert(Department department) {
		if(department != null) {
			departmentRepository.save(department);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(Department department) {
		if(department != null) {
			departmentRepository.delete(department);
			return true;
		}else {
			Department deleteDepartment = getDerpatmentById(department.getDepartmentId());
			departmentRepository.delete(deleteDepartment);
			return true;
		}
	}

	@Override
	public Department update(Department department) {
		if(department != null) {
			departmentRepository.save(department);
			return department;
		}else {
			Department updateDepartment = getDerpatmentById(department.getDepartmentId());
			return updateDepartment;
		}
	}

	@Override
	public Department getDerpatmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	
	}

	@Override
	public List<Department> getDepartments() {
		return (List<Department>) departmentRepository.findAll();
	}

	@Override
	public List<Department> getDepartmentsEntiries(int firstResult, int maxResult) {
		return null;
	}

	@Override
	public List<String> getDepartmentNames() {
		return departmentRepository.findAllNames();
	}

}
