package com.ayaz.web.dto;

import com.ayaz.validation.PasswordMatches;
import com.ayaz.validation.ValidEmail;
import com.ayaz.validation.ValidPassword;

@PasswordMatches
public class UserDto {

	private String firstName;
	
	private String lastName;
	
	@ValidPassword
	private String password;
	
	private String matchingPassword;
	
	
	private String username;
	
	@ValidEmail
	private String email;
	
	
	public UserDto() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
