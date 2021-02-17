package com.ahmedwaeer.crmsystem.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "CaLLs")
public class CallEntity implements Serializable {

	private static final long serialVersionUID = 2962294823080606873L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String callId;
	@Column(nullable = false)
	private String notes;
	@Column(nullable = false)
	private Date timeAndDate;
	@OneToMany(cascade = CascadeType.ALL)
	private List<ActionEntity> actions;
	


	
	public List<ActionEntity> getActions() {
		return actions;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public void setActions(List<ActionEntity> actions) {
		this.actions = actions;
	}

	public Date getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = new Date();
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	public void addAction(ActionEntity action) {
		this.actions.add(action);
	}

	
}
