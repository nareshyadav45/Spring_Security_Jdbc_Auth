package com.security.jdbc.auth.res.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringJdbcAuthRestController {

	@GetMapping("/user")
	public ResponseEntity<String> user(){
		return new ResponseEntity<String>("Hi, welcome to User DashBoard",HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin(){
		return new ResponseEntity<String>("Hi, Welcome to Admin Dashboard",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome Prime Page",HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<String> normalPage(){
		return new ResponseEntity<String>("Hello This is Normal Page Accesseble to EveryOne",HttpStatus.ACCEPTED);
		
	}
	
	
	
}
