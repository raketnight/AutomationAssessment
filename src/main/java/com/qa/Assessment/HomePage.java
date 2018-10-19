package com.qa.Assessment;


import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


public class HomePage {
	
	@FindBy(linkText = "Manage Jenkins")
	private  WebElement buttonManageJenkins;
	
	public void clickManageJenkins() {
		buttonManageJenkins.click();
	}

}
 