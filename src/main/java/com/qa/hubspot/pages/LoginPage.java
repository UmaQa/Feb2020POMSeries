package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {
	
	//1. By Locators:
	
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By SignupLink = By.linkText("Sign up");
	
	
	
	
	// 2. constructor of the page class:

		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}

		// 3. page actions/methods:

		public String getLoginPageTitle() {
			return driver.getTitle();
		}

		public boolean  checkSignUpLink() {
			return driver.findElement(SignupLink).isDisplayed();
			
		}
		
		public void doLogin(String un, String pwd) {
			driver.findElement(username).sendKeys(un);
			driver.findElement(password).sendKeys(pwd);
			driver.findElement(loginButton).click();
	
	
		}
	
	}
