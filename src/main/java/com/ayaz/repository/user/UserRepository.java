package com.ayaz.repository.user;

import org.springframework.data.repository.CrudRepository;

import com.ayaz.domain.user.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	
	User findByUsername(String username);

}
