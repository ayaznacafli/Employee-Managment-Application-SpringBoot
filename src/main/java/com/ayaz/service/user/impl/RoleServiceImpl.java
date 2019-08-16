package com.ayaz.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayaz.domain.user.Role;
import com.ayaz.repository.user.RoleRepository;
import com.ayaz.service.user.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public Role insert(Role role) {
		if(role != null) {
			roleRepository.save(role);
			return role;
		}else {
			return null;
		}
	}

	@Override
	public Role update(Role role) {
		if(role != null) {
			roleRepository.save(role);
			return role;
		}else {
			Role updateRole = getRoleById(role.getId());
			roleRepository.save(updateRole);
			return updateRole;
		}
	}

	@Override
	public Role delete(Role role) {
		if(role != null) {
			roleRepository.delete(role);
			return role;
		}else {
			Role deleteRole = getRoleById(role.getId());
			roleRepository.save(deleteRole);
			return deleteRole;
		}
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).get();
	}

	@Override
	public Role getRoleByName(String roleName) {
		return roleRepository.findByName(roleName);
	}

	@Override
	public List<Role> getRoles() {
		return (List<Role>) roleRepository.findAll();
	}

}
