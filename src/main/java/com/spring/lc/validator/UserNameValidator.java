package com.spring.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.lc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator{
	
	//check if UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	//we need to write our custom validation logic
	@Override
	public void validate(Object object, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "UserName.empty", "UserName can't be empty");
		
		String userName = ((UserRegistrationDTO)object).getUserName();
		if(!userName.contains("_")) {
			errors.rejectValue("userName", "Username.invalidString", "UserName must contain '_' ");
		}
	}

}
