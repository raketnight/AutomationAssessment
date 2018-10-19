package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage {
	
	@FindBy(id = "j_username")
	private WebElement username;
	
	@FindBy(name = "j_password")
	private WebElement passowrd;
	
	public void signIn() {
		username.sendKeys("root");
		passowrd.sendKeys("root");
		passowrd.submit();
	}

}
