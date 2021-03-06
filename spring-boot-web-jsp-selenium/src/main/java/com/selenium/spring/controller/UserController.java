package com.selenium.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.selenium.spring.entity.Account;
import com.selenium.spring.model.User;
import com.selenium.spring.service.AccountService;

@Controller
public class UserController {

	private static final String NEWUSER_VIEW = "newuser";
	private static final String USER_VIEW = "user";

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/user/save", method = RequestMethod.POST)
	public String saveuser(@Validated @ModelAttribute("account") Account acct, Model model) {
		accountService.save(acct);
		model.addAttribute("account", acct);
		return USER_VIEW;

	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(@Validated User user, Model model) {
		model.addAttribute("userName", user.getUserName());

		Account foundUser = accountService.findByUsername(user.getUserName());
		if (foundUser != null) {
			model.addAttribute("account", foundUser);
			return USER_VIEW;
		} else {
			return NEWUSER_VIEW;
		}
	}

}