package com.selenium.spring.test.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.selenium.spring.entity.Account;
import com.selenium.spring.repository.AccountRepository;
import com.selenium.spring.service.AccountService;
import com.selenium.spring.test.TestConfig;
import com.selenium.spring.test.TestData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class AccountServiceImplTest {

	@Autowired
	private AccountService classToTest;
	
	@Autowired
	private AccountRepository acctRepo;

	@Test
	public void findByUsername_not_found() {
		Account foundAcct = classToTest.findByUsername("testUser");
		assertNull(foundAcct);
	}

	@Test
	public void findByUsername_found() {
		
		acctRepo.save(TestData.createDummy("MaryZheng", "Mary", "Zheng"));
		Account foundAcct = classToTest.findByUsername("MaryZheng");
		assertNotNull(foundAcct);
		assertEquals(1, foundAcct.getId().intValue());
	}
}
