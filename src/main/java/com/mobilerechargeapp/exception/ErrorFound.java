package com.mobilerechargeapp.exception;

public class ErrorFound extends Exception {
 
	@Override
	public String getMessage()
	{
		return "Invalid username and password";
		
	}

	public String getMessage1()
	{
		return "Insufficient balance";
		
	}
	public String getMessage2() {
		return "EmailId  is Already Used";
	}
	public String getMessage3() {
		return "Mobile Number is Already Used";
		
	}
	static final String FORGOTPASSWORD = "*Two password  must same";
	public String forgetPassword() {
		return FORGOTPASSWORD ;
		
	}
	static final String EMAIL = "this mail not register";

	public String emailValidate() {

		return EMAIL ;

	}
	
}
