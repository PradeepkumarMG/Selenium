package com.selenium.webtest;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.selenium.webtest.HomePage;

public class HomePageTest extends WebTestBase{

	private HomePage homepage = new HomePage();;
	
	@Test
	public void login_invalid_user() throws IOException  {
		driver.get("http://localhost:8080/spring-boot-web-jsp-selenium/");
		screenshotHelper.saveScreenshot("home_screenshot.png");
		String nextPage = homepage.login(driver, "invalid");
		screenshotHelper.saveScreenshot("invalid_screenshot.png");
		assertEquals("New User", nextPage);
	}

}
