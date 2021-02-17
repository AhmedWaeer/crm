package com.ahmedwaeer.crmsystem.ui.model.request;

import java.util.Date;
import java.util.List;

import com.ahmedwaeer.crmsystem.ui.model.response.ActionRepresenation;

public class CallRequestModel {
	

	private String notes;
	private Date timeAndDate;
	private List<ActionRepresenation> actions;


	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public List<ActionRepresenation> getActions() {
		return actions;
	}

	public void setActions(List<ActionRepresenation> actions) {
		this.actions = actions;
	}
	

}
