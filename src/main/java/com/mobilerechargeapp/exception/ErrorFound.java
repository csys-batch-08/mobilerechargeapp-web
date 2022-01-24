package com.mobilerechargeapp.exception;

public class ErrorFound extends Exception {
 
	@Override
	public String getMessage()
	{
		return "invalid username and password";
		
	}
	public String getMessage1()
	{
		return "insufficient balance";
		
	}
	public String getMessage2() {
		return "EmailId is Already Used";
	}
	
}
