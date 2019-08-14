package com.docmgmt.app.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(uniqueConstraints = {
	      @UniqueConstraint(columnNames = {"username", "staffs_code"})
	      })
public class Users extends BaseEntity{
	
	@Id
	@NotNull
	@Size(min = 4, max = 20)
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private boolean status;
	
	@OneToOne
	@JoinColumn(updatable = false)
	private Staffs staffs;
	
	//doesn't create a new column
	@Transient
	private String confirmpassword;
	
	@Transient
	private String newpassword;
	
	
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Staffs getStaffs() {
		return staffs;
	}
	public void setStaffs(Staffs staffs) {
		this.staffs = staffs;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
}
