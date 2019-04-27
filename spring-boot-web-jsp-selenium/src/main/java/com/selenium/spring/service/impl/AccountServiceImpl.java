package com.selenium.spring.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.selenium.spring.entity.Account;
import com.selenium.spring.entity.RewardTransaction;
import com.selenium.spring.repository.AccountRepository;
import com.selenium.spring.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository acctDao;

	@Override
	public Account findByUsername(String username) {
		return acctDao.findByUserName(username);
	}

	@Override
	public Account save(Account accout) {
		accout.addTransactions(createTransaction("Anitha", "Happy for you"));
		accout.addTransactions(createTransaction("Senthil", "You got first Rank"));
		accout.addTransactions(createTransaction("Kohli", "You broke the records"));
		accout.addTransactions(createTransaction("Dhoni", "GOAT"));
		accout.addTransactions(createTransaction("Deepa", "You Beauty"));
		accout.addTransactions(createTransaction("Aswathi", "Nice to meet you"));
	
		return acctDao.save(accout);
	}
	
	private RewardTransaction createTransaction(String receiver, String messageDetails) {
		RewardTransaction trans = new RewardTransaction();
		trans.setSentDate(new Date());
		trans.setMessageDetails(messageDetails);
		trans.setReceiver(receiver);
		return trans;
	}
}
