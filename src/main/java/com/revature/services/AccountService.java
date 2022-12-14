package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Account;

import com.revature.repos.AccountRepo;

@Service
public class AccountService {
	
	private AccountRepo accountRepo;

	@Autowired
	public AccountService(AccountRepo accountRepo) {
		this.accountRepo = accountRepo;
	}	
	
	public List<Account> findAllAccounts() {
		return accountRepo.findAll();
	}
	
	public Account getAccountByUser(String username) {
		Optional<Account> opt = accountRepo.findByUsername(username);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	public Account addOrUpdate(Account account) {
		Account dbAccount = accountRepo.save(account);
		return dbAccount;
	}

}
