package com.mobilerechargeapp.model;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {
	private int userId;
	private String userName;
	private String emailId;
	private long phoneNumber;
	private String password;
	private Double wallet;
	private Operator operator;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getEmailid() {
		return emailId;
	}

	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}

	public long getPhonenumber() {
		return phoneNumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public Operator getOperator() {
		return this.operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public User() {
		super();

	}

	public User(String username, String emailid, long phonenumber, String password, Double wallet, Operator operator) {
		super();
		this.userName = username;
		this.emailId = emailid;
		this.phoneNumber = phonenumber;
		this.password = password;
		this.wallet = wallet;
		this.operator = operator;
	}

	public User(String username2, String email, long phonenumber2, String password2, Operator operator2) {
		this.userName = username2;
		this.emailId = email;
		this.phoneNumber = phonenumber2;
		this.password = password2;
		this.operator = operator2;
	}

	@Override
	public String toString() {
		return "User [username=" + userName + ", emailid=" + emailId + ", phonenumber=" + phoneNumber + ", password="
				+ password + ", wallet=" + wallet + ", operator=" + operator + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emailId, operator, password, phoneNumber, userId, userName, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emailId, other.emailId) && Objects.equals(operator, other.operator)
				&& Objects.equals(password, other.password) && phoneNumber == other.phoneNumber
				&& userId == other.userId && Objects.equals(userName, other.userName)
				&& Objects.equals(wallet, other.wallet);
	}
}
