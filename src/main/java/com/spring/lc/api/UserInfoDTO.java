package com.spring.lc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message = "* Your name cannot be blank")
	//@Min(value = 3,message = "*your name should have atleast three characters")
	@Size(min = 3,max = 15,message = "{userName.size}")
	private String userName;
	
	@NotBlank(message = "* Crush name cannot be blank")
	@Size(min = 3,max = 15,message = "Crush name should have atleast three and max 15 characters")
	private String crushName;
	
	@AssertTrue(message = "You should agree to terms and conditions")
	private boolean termAndCondition;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCrushName() {
		return crushName;
	}
	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}
	
	public boolean isTermAndCondition() {
		return termAndCondition;
	}

	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + "]";
	}

}
