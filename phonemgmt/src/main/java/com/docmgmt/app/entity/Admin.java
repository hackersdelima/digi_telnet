package com.docmgmt.app.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.docmgmt.app.auth.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table
public class Admin {

	
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Id
	@NotNull
	String username;
	
	@NotNull
	String password;
	
	@Transient
	String confirmpassword;
	
	@NotNull
	Boolean status;
	
	@JsonManagedReference
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( 
        name = "admin_roles", 
        joinColumns = @JoinColumn(
          name = "admin_username", referencedColumnName = "username"), 
        inverseJoinColumns = @JoinColumn(
          name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

}
