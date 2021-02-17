package com.ahmedwaeer.crmsystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Customers")
public class CustomerEntity implements Serializable {
	
	private static final long serialVersionUID = -6253273714570671701L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable=false)
	private String customerId;
	@Column(nullable=false)
	private String CompanyName;
	@Column(nullable=false)
	private String Telephone;
	@Column(nullable=false)
	private String email;
	@OneToMany(cascade=CascadeType.ALL)
	private List<CallEntity> calls;	
	

	public void addCall(CallEntity callDetails) {
		this.calls.add(callDetails);
	}
	public String toString()
	{
		return this.CompanyName + " : " + this.customerId;
	}
	public List<CallEntity> getCalls() {
		return calls;
	}
	public void setCalls(List<CallEntity> calls) {
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
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	


	
}
