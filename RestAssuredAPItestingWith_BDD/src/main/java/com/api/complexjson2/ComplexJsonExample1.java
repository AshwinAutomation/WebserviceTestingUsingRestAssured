package com.api.complexjson2;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonExample1 {
	JsonPath jsonPath = null;

	public ComplexJsonExample1() {
		jsonPath=new JsonPath(ComplexJsonPayload.payloadComplexJSON1());
	}

	@Test(priority=1)
	public void getFirstName_LastName_Age() {
     String firstName=jsonPath.get("FirstName");
     String lastName=jsonPath.get("LastName");
     int age=jsonPath.getInt("age");
     System.out.println("firstName :" + firstName);
     System.out.println("secondName :" + lastName);
     System.out.println("age :" + age);
	}
	
	@Test(priority=2)
	public void getAddress() {
     String streetName=jsonPath.get("address.Street");
     String cityName=jsonPath.get("address.City");
     int postalCode=jsonPath.getInt("address.Postalcode");
     System.out.println("streetName :" + streetName);
     System.out.println("cityName :" + cityName);
     System.out.println("postalCode :" + postalCode);
	}
	@Test(priority=3)
	public void getPhoneNumbers() {
    int phoneNumberCount=jsonPath.getInt("PhoneNumbers.size()");
    System.out.println("phoneNumberCount :" + phoneNumberCount);
    for (int i = 0; i < phoneNumberCount; i++) {
    	String contactNumber=jsonPath.get("PhoneNumbers["+i+"].ContactNo");
    	System.out.println("contactNumber :" + contactNumber);
    	String type=jsonPath.get("PhoneNumbers["+i+"].type");
    	System.out.println("type :" + type);
	}
	}
	
	

}
