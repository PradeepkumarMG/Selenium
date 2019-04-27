package com.selenium.spring.test;

import java.util.Date;

import com.selenium.spring.entity.Account;
import com.selenium.spring.entity.RewardTransaction;

public class TestData {
	public static Account createDummy(String login, String firstNm, String lastNm) {
		Account dummyAccount = new Account();
		dummyAccount.setFirstname(firstNm);
		dummyAccount.setLastname(lastNm);
		dummyAccount.setUsername(login);

		return dummyAccount;
	}

	public static RewardTransaction createTransaction(String receiver, String messageDetails) {
		RewardTransaction trans = new RewardTransaction();
		trans.setSentDate(new Date());;
		trans.setMessageDetails(messageDetails);
		trans.setReceiver(receiver);
		return trans;
	}

}
