package com.test.cucumber.steps;

import java.io.IOException;

public class TearDown {

	public static void sendEmail() {
		String scriptPath = "src/test/resources/SendEmail.sh";

	    // Build the command as a list of strings
	    ProcessBuilder processBuilder = new ProcessBuilder(
	            "sh",
	            scriptPath,
	            "src/test/resources/screenshots/screenshot1.png",
	            "Test",
	            "Execute",
	            "sonaimuthu.alagarsamy@qualitestgroup.com"
	    );

	    processBuilder.redirectErrorStream(true);

	    try {
	        Process process = processBuilder.start();

	        int exitCode = process.waitFor();

	        java.util.Scanner s = new java.util.Scanner(process.getInputStream()).useDelimiter("\\A");
	        String output = s.hasNext() ? s.next() : "";

	        System.out.println("Exit Code: " + exitCode);
	        System.out.println("Output:\n" + output);

	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
		
		System.out.println("Email sent successfully!!!");
	}
	
}
