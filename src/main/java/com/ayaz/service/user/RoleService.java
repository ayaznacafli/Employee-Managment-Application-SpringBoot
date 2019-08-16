package com.ayaz.service.user;

import java.util.List;

import com.ayaz.domain.user.Role;

public interface RoleService {
	
	Role insert(Role role);
	
	Role update(Role role);
	
	Role delete(Role role);
	
	Role getRoleById(Long id);

	Role getRoleByName(String roleName);
	
	List<Role> getRoles();
}
