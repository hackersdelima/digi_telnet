package com.docmgmt.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UserHistory {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@NotNull
	String username;
	
	@NotNull
	String dateTimeOfEntry;
	
	@NotNull
	String macAddress;
	
	@NotNull
	boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDateTimeOfEntry() {
		return dateTimeOfEntry;
	}

	public void setDateTimeOfEntry(String dateTimeOfEntry) {
		this.dateTimeOfEntry = dateTimeOfEntry;
	}

	public String getMacAddress() {
		return macAddress;
	}

	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
