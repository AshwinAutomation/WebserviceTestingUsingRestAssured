package com.restassured.restutils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Ashwin" + generatedString);
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Ashwin" + generatedString);
	}

	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Ashwin" + generatedString);
	}

	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Ashwin" + generatedString);
	}

	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(3);
		return ("Ashwin" + generatedString);
	}

	public static String getEmpName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Ashwin" + generatedString);
	}

	public static String getJob() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString);
	}
	
	
	
	public static String getEmpSalary() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return ( generatedString);
	}
	public static String getEmpAge() {
		String generatedAge = RandomStringUtils.randomNumeric(0);
		return (generatedAge);
	}

}
