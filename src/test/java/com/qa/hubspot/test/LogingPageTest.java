package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

//pre condition --> Test  --> post step
//@BeforeTest  -->  @Test -->Assert  --> @AfterTest
//browser, url  --> test google title  --> Google vs Google --> close browser
	

public class LogingPageTest {
	
	Properties prop;
	WebDriver driver;
	
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.int_prop();
		driver = basePage.int_driver(prop);
		loginPage = new LoginPage(driver);
				
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void verifySignupLinkTest() {
		Assert.assertTrue(loginPage.checkSignUpLink());
	}
	
	@Test(priority=3)
	public void verifyloginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void teatDown() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
