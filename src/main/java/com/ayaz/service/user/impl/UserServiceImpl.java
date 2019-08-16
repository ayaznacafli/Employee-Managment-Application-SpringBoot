package com.ayaz.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ayaz.domain.user.Role;
import com.ayaz.domain.user.User;
import com.ayaz.exception.UserAlreadyExistException;
import com.ayaz.repository.user.UserRepository;
import com.ayaz.service.user.RoleService;
import com.ayaz.service.user.UserService;
import com.ayaz.web.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	
	private boolean usernameExist(String username) {
		return getUserByEmail(username) != null;
	}

	@Override
	public User registerNewUser(UserDto userDto) {
		boolean status = usernameExist(userDto.getEmail());
		 if(status) {
			 throw new UserAlreadyExistException("There is an account with that username : " + userDto.getUsername());
		 }
		 Role role = roleService.getRoleByName("ROLE_USER");
		 User user = new User();
		 user.setLastName(userDto.getLastName());
		 user.setFirstName(userDto.getFirstName());
		 user.setEmail(userDto.getEmail());
		 user.setUsername(userDto.getUsername());
		 user.setPassword(userDto.getPassword());
		 user.setRole(role);
		 return insert(user);
	}

	@Override
	public boolean checkIfValidOldPassword(User user, String oldPassword) {
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

	@Override
	public void changeUserPassword(User user, String password) {
		user.setPassword(passwordEncoder.encode(password));
		update(user);
	}

	@Override
	public User insert(User user) {
		if(user != null) {
			userRepository.save(user);
			return user;
		}else {
			return null;
		}
	}

	@Override
	public User update(User user) {
		if(user != null) {
			userRepository.save(user);
			return user;
		}else {
			User updateUser = getUserById(user.getId());
			userRepository.save(updateUser);
			return updateUser;
		}
	}

	@Override
	public User delete(User user) {
		if(user != null) {
			userRepository.delete(user);
			return user;
		}else {
			User deleteUser = getUserById(user.getId());
			userRepository.delete(deleteUser);
			return deleteUser;
		}
	}

	@Override
	public User getUserById(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepository.findAll();
	}
	
	
	
}
