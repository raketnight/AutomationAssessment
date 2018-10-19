package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkinsPage {
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Install as Windows Service'])[1]/following::dt[1]")
	private WebElement buttonManageUsers;
	
	public void clickManageUsers() {
		buttonManageUsers.click();
	}

}
