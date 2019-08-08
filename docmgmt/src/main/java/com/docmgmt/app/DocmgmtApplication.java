package com.docmgmt.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DocmgmtApplication {
	public static void main(String[] args) {
		SpringApplication.run(DocmgmtApplication.class, args);
		
	}
}
