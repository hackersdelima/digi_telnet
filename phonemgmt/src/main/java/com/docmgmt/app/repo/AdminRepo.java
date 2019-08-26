package com.docmgmt.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.docmgmt.app.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	public Admin findByUsername(String username);

	public Admin getUsernameById(int id);
}
