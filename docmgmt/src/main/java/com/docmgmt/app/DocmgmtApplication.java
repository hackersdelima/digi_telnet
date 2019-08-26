package com.docmgmt.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.docmgmt.app.entity.Office;
import com.docmgmt.app.entity.Staffs;
import com.docmgmt.app.entity.Users;
import com.docmgmt.app.repo.OfficeRepo;
import com.docmgmt.app.repo.StaffsRepo;
import com.docmgmt.app.repo.UsersRepo;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class DocmgmtApplication {
	 @Autowired private UsersRepo usersRepo;
	    @Autowired private StaffsRepo staffsRepo;
	    @Autowired private OfficeRepo officeRepo;
	   
		
	public static void main(String[] args) {
		SpringApplication.run(DocmgmtApplication.class, args);
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Users user=usersRepo.findByUsername("admin");
		if(user==null) {
		user=new Users();
		user.setUsername("admin");
		user.setPassword(encoder.encode("admin"));
		user.setStatus(true);
		
		Office office=null;
		 if(officeRepo.findById(1).isPresent()) {
			 office=officeRepo.findById(1).get();
		 }
		 else{
			office=new Office();
			office.setId(1);
			office.setName("Head Office");
			office.setOffice_level("HO");
			office.setRo_code("000");
			office.setAddress("Kathmandu");
			office=officeRepo.save(office);
			}
		
		
		Staffs staffs=null;
		if(staffsRepo.findById("000").isPresent()) {
			staffs=staffsRepo.findById("000").get();
		}
		else {
		staffs=new Staffs();
		staffs.setCode("000");
		staffs.setFirstName("admin");
		staffs.setLastName("admin");
		staffs.setPhoneNumber("9999999999");
		staffs.setPost("admin");
		staffs.setGender("m");
		staffs.setOffice(office);
		staffs=staffsRepo.save(staffs);
		}
		
		user.setStaffs(staffs);
		usersRepo.save(user);
		}
	}
	
	
}
