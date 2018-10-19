package com.qa.Assessment;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	
	@FindBy(linkText = "Configure")
	private WebElement buttonConfigure;
	
	public void clickConfigure() {
		buttonConfigure.click();
	}
	
	public void checkUser(WebDriver driver, String username) {
		
		WebElement element = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='add description'])[1]/following::div[1]"));
		assertEquals("Jenkins User ID: " + username, element.getText());
	}

}
 