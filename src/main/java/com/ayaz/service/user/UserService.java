package com.ayaz.service.user;

import java.util.List;

import com.ayaz.domain.user.User;
import com.ayaz.web.dto.UserDto;

public interface UserService {
	
	User registerNewUser(UserDto userDto);
	
	boolean checkIfValidOldPassword(User user, String oldPassword);
	
	public void changeUserPassword(User user, String password);
	
	User insert(User user);
	
	User update(User user);
	
	User delete(User user);
	
	User getUserById(Long id);

	User getUserByEmail(String email);
	
	User getUserByUsername(String username);
	
	List<User> getUsers();
	
}
