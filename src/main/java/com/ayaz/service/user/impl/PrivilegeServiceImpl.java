package com.ayaz.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.user.Privilege;
import com.ayaz.repository.user.PrivilegeRepository;
import com.ayaz.service.user.PrivilegeService;

@Service
public class PrivilegeServiceImpl implements PrivilegeService{

	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	
	@Override
	public boolean insert(Privilege privilege) {
		if(privilege != null) {
			privilegeRepository.save(privilege);
			return true;
		}else {
			return false;
		}
	}

}
