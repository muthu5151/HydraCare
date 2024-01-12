package com.test.cucumber.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.test.cucumber.steps.TearDown;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.test.cucumber",
		plugin = {
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty.html",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"junit:target/cucumber-reports/CucumberTestReport.xml"
		},
		tags = "@All"
		)

public class AllRunner extends TearDown {
	@AfterClass
	public static void tearDown() {
		sendEmail();
	}
}

