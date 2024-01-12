package com.test.cucumber.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.cucumber.utilities.ReusableOperations;

public class LoginPage extends ReusableOperations {
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	public WebElement txtName;
	
	@FindBy(name="password")
	public WebElement txtPassword;
	
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	public WebElement btnSubmit;
	
	
	public void typeUsername(String name) {
		typeIntoElement(txtName,name);
	}
	
	public void typePassword(String name) {
		typeIntoElement(txtPassword,name);
	}
	
	public void clickSubmit() {
		clickOnElement(btnSubmit);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
