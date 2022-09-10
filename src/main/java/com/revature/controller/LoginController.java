package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Account;
import com.revature.services.AccountService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	private AccountService accountService;

	@Autowired
	public LoginController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}

	@GetMapping
	public ResponseEntity<Boolean> getAccount(@RequestBody Account account){
		String userPwd = account.getUserPwd();
		Account userAccount = accountService.getAccountByUser(account.getUsername());
		
		if(userAccount != null && userAccount.getUserPwd().equals(userPwd)) {
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}else {
			return ResponseEntity.status(204).build();
		}
	}
	
}
