package com.ahmedwaeer.crmsystem.shared.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class CallDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String callId;
	private String notes;
    private Date timeAndDate;
	private List<ActionDto> actions;
	
	
	
	public List<ActionDto> getActions() {
		return actions;
	}
	public void setActions(List<ActionDto> actions) {
		this.actions = actions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	public Date getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = timeAndDate;
	}


}
