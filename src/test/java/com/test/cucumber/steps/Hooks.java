package com.test.cucumber.steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import com.test.cucumber.utilities.ReadProperties;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void openBrowser() throws Exception {

		ReadProperties propertiesReader = new ReadProperties();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(ReadProperties.getValue("url"));
	}

	@After
	public void teardown(Scenario scenario) {

		if(scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				//				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException noSupportScreenshot) {
				System.err.println(noSupportScreenshot.getMessage());
			}
		}
		driver.quit();
		
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) {
//		try {
//			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//							scenario.attach(screenshot, "image/png", "image");
//		} catch (WebDriverException noSupportScreenshot) {
//			System.err.println(noSupportScreenshot.getMessage());
//		}
		
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		 String screenshotPath = "src/test/resources/screenshots/screenshot1.png";

	        try {
	            // Copy the screenshot file to the specified path
	            org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(screenshotPath));
	            System.out.println("Screenshot saved to: " + screenshotPath);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
}
