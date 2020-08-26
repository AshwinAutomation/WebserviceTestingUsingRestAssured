package com.restassured.testdrivendevlopment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request_For_SingleUser {


	@Test
	public void getSingleUserDetails() {
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification httpRequest=RestAssured.given();
		Response httpResponse=httpRequest.request(Method.GET,"/api/users/3");
		
		
		String responseBody=httpResponse.body().asString();
		System.out.println("responseBody : " + responseBody);
		
		int statusCode=httpResponse.getStatusCode();
		System.out.println(statusCode);
		
		//String email=httpResponse.jsonPath().get("email");
		
		JsonPath path=httpResponse.jsonPath();
		
		
		//String email=path.getString("email");
		
		//System.out.println("email : " + email);
		
		System.out.println(path.getString("email"));
	
	}
	
}
