package com.docmgmt.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.docmgmt.app.entity.Admin;
import com.docmgmt.app.repo.AdminRepo;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class PhonemgmtApplication {

	@Autowired
	AdminRepo adminRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(PhonemgmtApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startupActions() {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		Admin admin = adminRepo.findByUsername("admin");
		
		if (admin == null) {
			admin = new Admin();
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin"));
			admin.setStatus(true);
		}
		
		adminRepo.save(admin);
	}
	
}
