package com.ahmedwaeer.crmsystem.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Actions")
public class ActionEntity implements Serializable {

	private static final long serialVersionUID = -5347430294896540539L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String actionId;
	@Column(nullable = false)
	private String details;
	@Column(nullable = false)
	private Calendar requiredBy;
	@Column(nullable = false)
	private boolean complete;

	public boolean isOverdue() {
		Calendar dateNow = new java.util.GregorianCalendar();

		return dateNow.after(this.requiredBy);
	}

	

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}



	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public void completeAction() {
		this.complete = true;
	}

	public boolean isComplete() {
		return this.complete;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Calendar getRequiredBy() {
		return requiredBy;
	}

	public void setRequiredBy(Calendar requiredBy) {
		this.requiredBy = requiredBy;
	}

	
	 public void setComplete(boolean complete) { this.complete = complete; }
	

}
