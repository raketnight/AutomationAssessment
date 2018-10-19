package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPage {
	
	@FindBy(linkText = "Create User")
	private WebElement buttonCreateUser;
	
	public void clickCreateUser() {
		buttonCreateUser.click();
	}

}
