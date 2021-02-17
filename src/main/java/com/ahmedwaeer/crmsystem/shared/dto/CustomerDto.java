package com.ahmedwaeer.crmsystem.shared.dto;

import java.io.Serializable;
import java.util.List;



public class CustomerDto implements Serializable{
	
	private static final long serialVersionUID = -5743996675519124990L;
	private long id;
	private String customerId;
	private String companyName;
	private String telephone;
	private String email;
	private List<CallDto> calls;
	
	
	
	public void addCall(CallDto callDetails) {
		this.calls.add(callDetails);
	}
	public List<CallDto> getCallDto() {
		return calls;
	}
	public void setCallDto(List<CallDto> calls) {
		this.calls = calls;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
