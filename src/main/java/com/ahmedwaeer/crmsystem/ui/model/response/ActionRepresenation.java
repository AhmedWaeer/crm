package com.ahmedwaeer.crmsystem.ui.model.response;

import java.util.Calendar;


public class ActionRepresenation {
    private Calendar requiredBy;
	private String details;
	


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


}
