package com.docmgmt.app;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.docmgmt.app.entity.Office;
import com.docmgmt.app.entity.Staffs;
import com.docmgmt.app.entity.Users;
import com.docmgmt.app.repo.OfficeRepo;
import com.docmgmt.app.repo.StaffsRepo;
import com.docmgmt.app.repo.UsersRepo;

@Component
public class Monitor {
    @Autowired private UsersRepo usersRepo;
    @Autowired private StaffsRepo staffsRepo;
    @Autowired private OfficeRepo officeRepo;

    @PostConstruct
    public void init(){
    	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Users user=usersRepo.findByUsername("admin");
		if(user==null) {
		user=new Users();
		user.setUsername("admin");
		user.setPassword(encoder.encode("admin"));
		user.setStatus(true);
		
		Office office=officeRepo.findById(1).get();
		if(office==null) {
			office=new Office();
		office.setId(1);
		office.setName("diginepal");
		office.setOffice_level("HO");
		office.setRo_code("201");
		office.setAddress("baneswor");
		office=officeRepo.save(office);
		}
		
		Staffs staffs =staffsRepo.findById("201").get();
		if(staffs==null) {
		staffs=new Staffs();
		staffs.setCode("201");
		staffs.setFirstName("Shishir");
		staffs.setLastName("karki");
		staffs.setPhoneNumber("9869718832");
		staffs.setPost("employee");
		staffs.setOffice(office);
		staffs=staffsRepo.save(staffs);
		}
		user.setStaffs(staffs);
		usersRepo.save(user);
		}
    }
}
