package com.ayaz.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ayaz.web.dto.UserDto;


public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>{

	@Override
	public void initialize(PasswordMatches constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		UserDto userDto = (UserDto)o;
		return userDto.getPassword().equals(userDto.getMatchingPassword());
	}
}
