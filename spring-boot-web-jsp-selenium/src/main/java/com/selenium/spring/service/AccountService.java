package com.selenium.spring.service;

import com.selenium.spring.entity.Account;

public interface AccountService {
	Account findByUsername(String username);
	Account save(Account accout);
}
