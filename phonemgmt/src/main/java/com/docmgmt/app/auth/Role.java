package com.docmgmt.app.auth;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.docmgmt.app.entity.Admin;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
    private String name;
    
    @JsonBackReference
    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<Admin> admin;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Admin> getAdmin() {
		return admin;
	}

	public void setAdmin(Collection<Admin> admin) {
		this.admin = admin;
	}

}

