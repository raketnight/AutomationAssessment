package com.qa.Assessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfigurePage {
	
	@FindBy(name = "_.fullName")
	private WebElement fullNameField;
	
	@FindBy(id = "yui-gen2-button")
	private WebElement buttonSave;
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::h1[1]")
	private WebElement fullnameText;
	
	public void sendFullName(String text) {
		fullNameField.clear();
		fullNameField.sendKeys(text);
	}
	
	public void save() {
		buttonSave.click();
	}
	
	public void checkFullname(String text) {
		assertEquals(text, fullnameText.getText());
	}

}
