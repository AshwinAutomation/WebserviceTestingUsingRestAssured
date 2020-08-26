package com.restassured.testdrivendevlopment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETE_Request {

	@Test
	public void deleteRequest() {

		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification httpRequest = RestAssured.given();
		
		Response httpResponse = httpRequest.request(Method.DELETE, "api/users/2");

		String responseBody = httpResponse.getBody().asString();

		System.out.println("responseBody : " + responseBody);

		
		int statusCode=httpResponse.statusCode();
		 System.out.println("statusCode :" + statusCode);
	}
	

}
