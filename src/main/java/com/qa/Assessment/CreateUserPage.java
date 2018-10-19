package com.qa.Assessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUserPage {
	
	@FindBy(id = "username")
	private WebElement textFieldUserName;
	
	@FindBy(name = "password1")
	private WebElement textFieldPasswword1;
	
	@FindBy(name = "password2")
	private WebElement textFieldPassword2;
	
	@FindBy(name = "fullname")
	private WebElement textFieldFullname;
	
	@FindBy(name = "email")
	private WebElement textFieldEmail;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement buttonSubmit;
	
	public void typeUsername(String text) {
		textFieldUserName.sendKeys(text);
	}
	
	public void typePasswword1(String text) { //type both password at the same time
		textFieldPasswword1.sendKeys(text);
	}
	
	public void typePasswword2(String text) { //type both password at the same time
		textFieldPassword2.sendKeys(text);
	}
	
	public void typeFullname(String text) {
		textFieldFullname.sendKeys(text);
	}
	
	public void typeEmail(String text) {
		textFieldEmail.sendKeys(text);
	}
	
	public void clickSubmit() {
		buttonSubmit.click();
	}
 
}
