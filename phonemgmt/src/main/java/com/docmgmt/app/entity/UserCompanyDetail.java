package com.docmgmt.app.entity;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class UserCompanyDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@NotNull
	String name;
	
	@NotNull
	String Address;
	
	@NotNull
	double poBoxNumber;
	
	@NotNull
	double phoneNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public double getPoBoxNumber() {
		return poBoxNumber;
	}

	public void setPoBoxNumber(double poBoxNumber) {
		this.poBoxNumber = poBoxNumber;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	

}
