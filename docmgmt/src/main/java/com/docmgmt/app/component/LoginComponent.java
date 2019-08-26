package com.docmgmt.app.component;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.docmgmt.app.entity.LoginHistoryManagement;
import com.docmgmt.app.message.HttpResponses;
import com.docmgmt.app.message.Messages;
import com.docmgmt.app.repo.LoginHistoryManagementRepo;

@Component
public class LoginComponent {
	 
	@Autowired
	LoginHistoryManagementRepo loginHistoryManagementRepo;
	
	Authentication authentication;


	//setting login history details
	public ResponseEntity<Messages> create(LoginHistoryManagement logHistoryMgmt,String username) {
		 
		try {
			System.out.println("entered read method");
			String dateOfEntry = currentDate();
			String userMacAddr = "1234";
			
			if (!username.equals(null)) {
				System.out.println("past getting strings");
				logHistoryMgmt.setUsername(username);
				logHistoryMgmt.setDateTime(dateOfEntry);
				logHistoryMgmt.setUserMac(userMacAddr);
				logHistoryMgmt.setLoginStatus(true);
				System.out.println("set names done");
				
				System.out.println(username+" "+dateOfEntry+" "+userMacAddr);

				LoginHistoryManagement savedLogs = loginHistoryManagementRepo.save(logHistoryMgmt);
				
				System.out.println("no saved logs");
			
				if (savedLogs != null) {
					return new ResponseEntity<Messages>(HttpResponses.created(savedLogs), HttpStatus.CREATED);
				}
			}
			else {
				System.out.println("No body has logged in");
			}
		}
		catch (Exception e) {
			System.out.println("Error:"+e);			}
		return new ResponseEntity<Messages>(HttpResponses.badrequest(), HttpStatus.BAD_REQUEST);
	}
	
		//returns the current username
//		public Users getCurrentUser() {
//			Users current_user = new Users();
//			try {
//				String current_username = SecurityContextHolder.getContext().getAuthentication().getName();
//				current_user = usersRepo.findByUsername(current_username);
//			}
//			catch (Exception e) {
//				System.out.println("this is the culprit");
//				System.out.println(e);
//			}
//			
//			return current_user;
//		}
		
		//returns the current date
		public String currentDate() {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String formattedDate = formatter.format(date);
			return formattedDate;
		}
		
		//return mac address of the user
		public String userMac() {
			InetAddress ip;
			String macAddr = "";
			try {
					
				ip = InetAddress.getLocalHost();
				
				NetworkInterface network = NetworkInterface.getByInetAddress(ip);
					
				byte[] mac = network.getHardwareAddress();
					
					
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < mac.length; i++) {
					sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
				}
				
				macAddr = sb.toString();
					
			} catch (Exception e) {
				System.out.println("inside");
				e.printStackTrace();
				
			} 
//			catch (SocketException e){
//					System.out.println("inside1");
//				e.printStackTrace();
//					
//			}
			   return macAddr; 
		}


}
