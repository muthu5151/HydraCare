package com.test.cucumber.steps;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.cucumber.pageobjects.LoginPage;
import com.test.cucumber.utilities.ReadProperties;
import io.cucumber.java.en.Given;

public class LoginSteps {

	private WebDriver driver = Hooks.driver;
	private WebDriverWait wait;
	
	public LoginSteps() throws Exception {
		ReadProperties propertiesReader = new ReadProperties();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@Given("I login to hydracare using {string} and {string}")
	public void i_login_hydracare(String username, String password) {
		LoginPage login_po = new LoginPage(driver, wait);
		login_po.typeUsername(username);
		login_po.typePassword(password);
		login_po.clickSubmit();
	}
	
}
