package com.spring.lc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.spring.lc.api.Phone;

//formatter is used to convert String obj into phone object by using parse method of formatter.
public class PhoneNoFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {

		return phone.getCountryCode() + "-" + phone.getUserName();
	}

	// Parse method used to convert one datatype to another datatype
	@Override
	public Phone parse(String completePhoneNo, Locale locale) throws ParseException {
		System.out.println("inside the parse method");

		Phone phone = new Phone();
		String[] phoneNoArray = completePhoneNo.split("-");

		// whether phoneno consist of "-" symbol
		int indexOf = completePhoneNo.indexOf("-");

		if (indexOf == -1 || completePhoneNo.startsWith("-")) {
			// if "-" is not found ,then add 91 as the default country code
			phone.setCountryCode("91");
			
			if (completePhoneNo.startsWith("-")) {
				phone.setUserName(phoneNoArray[1]);
			} 
			else {
				phone.setUserName(phoneNoArray[0]);
			}
		}

		// split the string received from the user
		else {
			// extract the countrycode and set it to the phone class countrycodeProperty

			phone.setCountryCode(phoneNoArray[0]);
			phone.setUserName(phoneNoArray[1]);

		}
		return phone;
	}

}
