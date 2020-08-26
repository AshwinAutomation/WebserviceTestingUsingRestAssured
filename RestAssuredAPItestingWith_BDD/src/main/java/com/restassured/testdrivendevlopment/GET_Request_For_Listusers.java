package com.restassured.testdrivendevlopment;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request_For_Listusers {
	
	@Test
	public void getRequsetForListusers() {
	RestAssured.baseURI="https://reqres.in";
	    
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response httpResponse=httpRequest.request(Method.GET,"api/users?page=2");
		
		
	/*	 String responseBody=httpResponse.body().asString();
		System.out.println("responseBody : " + responseBody);*/
		
		int statusCode=httpResponse.getStatusCode();
		System.out.println(statusCode);

		
             
	

		JsonPath jpath=httpResponse.jsonPath();

		System.out.println(" data inside :" + jpath.get("data"));
	

		
		
		
		
		
	}
	

	
	
	
	
	
	
	

}
