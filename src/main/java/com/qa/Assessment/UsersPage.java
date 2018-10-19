package com.qa.Assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsersPage {
	
	@FindBy(xpath = "(.//*[normalize-space(text()) and normalize-space(.)='Create User'])[1]/following::h1[1]")
	private WebElement usersText;
	
	public void gettext() {
		usersText.getText();
	}
	
	public void clickUser(WebDriver driver, String username) {
		driver.findElement(By.cssSelector(("a[href*='user/" + username + "/']"))).click();
	}
	
	public void checkUser(WebDriver driver, String username) {
		new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.linkText(username)));
	}

}
