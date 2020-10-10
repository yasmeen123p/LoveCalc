package com.spring.lc.api;

public class Phone {
	private String countryCode;
	private String userName;
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return getCountryCode()+ "-" + getUserName();
	}
	
}
