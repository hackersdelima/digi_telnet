package com.docmgmt.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.docmgmt.app.component.CrudReturnService;
import com.docmgmt.app.entity.UserHistory;
import com.docmgmt.app.entity.Users;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.UserHistoryRepo;
import com.docmgmt.app.repo.UsersRepo;
import com.docmgmt.app.service.GetNetworkAddress;

@Component
public class UserHistoryController implements ApplicationListener<InteractiveAuthenticationSuccessEvent> {

	@Autowired
	UserHistoryRepo userHistoryRepo;

	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	CrudReturnService<UserHistory> crudReturnService;

	
	//this event is triggered when a user logs in successfully
	@Override
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent event) {
		sendValues();
	}

	public ResponseEntity<?> sendValues() {

		UserHistory userHistory = new UserHistory();

		String username = getUserName();
		String date = currentDate();
		String macAddr = GetNetworkAddress.GetAddress("ip");
		Boolean status = status();

		userHistory.setUsername(username);
		userHistory.setDateTimeOfEntry(date);
		userHistory.setMacAddress(macAddr);
		userHistory.setStatus(status);

		UserHistory savedHistory = userHistoryRepo.save(userHistory);

		ResponseEntity<Messages> returntype = crudReturnService.updateReturn(savedHistory);
		return returntype;

	}

	// returns the logged in user name
	public String getUserName() {
		Users username = new Users();
		String current_username = SecurityContextHolder.getContext().getAuthentication().getName();
		username = usersRepo.findByUsername(current_username);
		String user = username.getUsername();
		return user;
	}

	// returns the current date
	public String currentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String formattedDate = formatter.format(date);
		return formattedDate;
	}
	
	// returns true if authenticated user is found
	public boolean status() {
		String username = getUserName();
		if (username!= null) {
			return true;
		}
		else {
			return false;
		}
	}

}
