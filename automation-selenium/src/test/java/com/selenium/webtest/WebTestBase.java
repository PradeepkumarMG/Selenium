package com.selenium.webtest;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestBase {
	protected WebDriver driver;
	protected ScreenshotHelper screenshotHelper;

	public WebTestBase() {
		super();
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sriram\\Pradeep\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		screenshotHelper = new ScreenshotHelper(driver);
	}

	@After
	public void close() throws IOException {
		driver.close();
	}

}