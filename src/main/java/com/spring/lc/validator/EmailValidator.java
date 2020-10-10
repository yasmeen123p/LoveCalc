package com.spring.lc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spring.lc.api.UserRegistrationDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CommunicationDTO.email", "email.empty","Email can't be blank");
		
		String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
		if(!email.endsWith("gmail.com")) {
			errors.rejectValue("CommunicationDTO.email", "email.InvalidDomain");
		}

	}

}
