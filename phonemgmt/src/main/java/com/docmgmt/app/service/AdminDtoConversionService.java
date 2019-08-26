package com.docmgmt.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docmgmt.app.dto.AdminDto;
import com.docmgmt.app.entity.Admin;
import com.docmgmt.app.repo.AdminRepo;

@Service
public class AdminDtoConversionService {

	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AdminDto getAdmin(int id) {
		
		Admin admin = adminRepo.getUsernameById(id);
		
		//mapping entity to dto --- vice-versa can be done
		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
		
		return adminDto;
	}
	
	
}
