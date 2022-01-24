package com.mobilerechargeapp.model;

import java.util.Objects;

public class Operator {
	private int operatorId;
	private String operatorname;
	
	
	public int getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorname() {
		return operatorname;
	}
	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}
	public Operator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Operator(int operatorId, String operatorname) {
		super();
		this.operatorId = operatorId;
		this.operatorname = operatorname;
	}
	@Override
	public String toString() {
		return "Operator [operatorId=" + operatorId + ", operatorname=" + operatorname + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(operatorId, operatorname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		return operatorId == other.operatorId && Objects.equals(operatorname, other.operatorname);
	}
public int getOperatorId1() {
	return this.operatorId;
}
	
}
