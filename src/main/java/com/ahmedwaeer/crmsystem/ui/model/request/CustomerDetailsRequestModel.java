package com.ahmedwaeer.crmsystem.ui.model.request;

import java.util.List;

public class CustomerDetailsRequestModel {
	
	
	private String companyName;
	private String telephone;
	private String email;
	private List<CallRequestModel> calls;
	
	
	public List<CallRequestModel> getCalls() {
		return calls;
	}
	public void setCalls(List<CallRequestModel> calls) {
		this.calls = calls;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
