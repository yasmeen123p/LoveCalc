package com.spring.lc.controllers;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.lc.api.CommunicationDTO;
import com.spring.lc.api.Phone;
import com.spring.lc.api.UserRegistrationDTO;
import com.spring.lc.propertyeditor.NamePropertyEditor;
import com.spring.lc.validator.EmailValidator;
import com.spring.lc.validator.UserNameValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmailValidator emailValidator;
	
	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg")UserRegistrationDTO dto) {
//		UserRegistrationDTO dto=new UserRegistrationDTO();
//		model .addAttribute("userReg", dto);
		
		
//		dto.setName("Yasmeen");
//		dto.setUserName("Yasmeen_Parveen");
		System.out.println("Inside showRegistrationPage");
		
		
		/*
		 * to print default value of phone no,as it is converted to Phpne object using
		 * parse method hence to show it to the main page we again have to convert the
		 * phone obj to String object using print method of formatter.Here we are manually setting the
		 * deafault value of phone no and show it to the main page
		 */
		Phone phone =new Phone();
		phone.setCountryCode("91");
		phone.setUserName("123444");
		
		CommunicationDTO communicationdto=new CommunicationDTO();
		communicationdto.setPhoneno(phone);
		
		dto.setCommunicationDTO(communicationdto);
		//load the saved userdata from the database
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserreg(@Valid @ModelAttribute("userReg")UserRegistrationDTO dto,BindingResult result) {
		System.out.println("Inside processUserreg");
		
		//EmailValidator Validator=new EmailValidator();
		//Spring will add validator---calling the emailvalidator method
		emailValidator.validate(dto, result);
		
		if(result.hasErrors()) {
			System.out.println("My page has errors");
			
			List<ObjectError> allErrors = result.getAllErrors();
			for(ObjectError error: allErrors ) {
				System.out.println(error);
			}
			
			return "user-registration-page";
		}
		
		//save the dto object into our database
		return "registration-success";
	}
	
	@InitBinder //initbinder is used to stop binding the data like we stop binding the data with name
	public void initBinder(WebDataBinder binder) {
		System.out.println("inside binder method");
		//binder.setDisallowedFields("name");
		//property editor helps us to convert String type to our own custom type and viceversa
		StringTrimmerEditor editor=new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class,"name", editor);
		
		NamePropertyEditor nameeditor=new NamePropertyEditor();
		binder.registerCustomEditor(String.class,"name", nameeditor);
		
		//UserNameValidator validator = new UserNameValidator();
		binder.addValidators(new UserNameValidator());
		//binder.addValidators(new EmailValidator());
	}
}
