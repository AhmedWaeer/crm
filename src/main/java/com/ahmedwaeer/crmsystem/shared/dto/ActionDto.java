package com.ahmedwaeer.crmsystem.shared.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ActionDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String actionId;
	private String details;
	private Calendar requiredBy;
	private boolean complete;

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

	  public boolean isComplete() { return complete; }
	  
	  public void setComplete(boolean complete) { this.complete = complete; }
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

}
