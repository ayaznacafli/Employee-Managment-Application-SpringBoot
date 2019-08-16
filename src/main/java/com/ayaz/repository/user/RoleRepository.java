package com.ayaz.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.user.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

	Role findByName(String roleName);
	
	
}
