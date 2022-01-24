package com.mobilerechargeapp.model;

import java.util.Objects;

public class Admin {
    private String adminEmailId;
    private String password;
	public String getAdminEmailId() {
		return adminEmailId;
	}
	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Admin(String adminEmailId, String password) {
		super();
		this.adminEmailId = adminEmailId;
		this.password = password;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [adminEmailId=" + adminEmailId + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(adminEmailId, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		return Objects.equals(adminEmailId, other.adminEmailId) && Objects.equals(password, other.password);
	}
    
	
    
    
}
