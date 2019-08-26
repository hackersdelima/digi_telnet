package com.docmgmt.app.service;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.docmgmt.app.entity.Admin;
import com.docmgmt.app.repo.AdminRepo;

@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	AdminRepo adminRepo;
	
	Admin admin;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin admin = adminRepo.findByUsername(username);
		
		if(admin == null)
			throw new UsernameNotFoundException("User 404");
		//using spring security's User class instead of UserPrincipal
		return new org.springframework.security.core.userdetails.User(admin.getUsername(), admin.getPassword(),
		         getAuthorities(admin));
	}

	//get name of roles
		private static Collection<? extends GrantedAuthority> getAuthorities(Admin admin) {
	        Collection<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
	        return authorities;
	    }
}
