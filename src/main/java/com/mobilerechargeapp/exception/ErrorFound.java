package com.mobilerechargeapp.exception;

public class ErrorFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "***EmailId And Password Should Not Match";
	}

	static final String BALANCE = "Insufficient balance";

	public String getMessage1() {
		return BALANCE;
	}

	static final String EMAILID = "EmailId  is Already Used";

	public String getMessage2() {
		return EMAILID;
	}

	static final String MOBILENUMBER = "Mobile Number is Already Used";

	public String getMessage3() {
		return MOBILENUMBER;
	}

	static final String FORGOTPASSWORD = "*Two password  must same";

	public String forgetPassword() {
		return FORGOTPASSWORD;
	}

	static final String EMAIL = "this mail not register";

	public String emailValidate() {
		return EMAIL;
	}

	static final String PLANID = "*PLANID IS INVALID";

	public String getMessage4() {
		return PLANID;
	}

	static final String PLANNAME = "*Enter the Valid Network";

	public String planName() {
		return PLANNAME;
	}

	static final String AIRTELID = "*Enter the Valid Network";

	public String airtelId() {
		return AIRTELID;
	}

	static final String VODAFONEID = "*Enter the Valid Network";

	public String vodafoneId() {
		return VODAFONEID;
	}

	static final String BSNLID = "*Enter the Valid Network";

	public String bsnlId() {
		return BSNLID;
	}
}
