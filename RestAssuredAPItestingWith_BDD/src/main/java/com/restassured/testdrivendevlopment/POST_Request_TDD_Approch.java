package com.restassured.testdrivendevlopment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request_TDD_Approch {

	@Test
	public void createNewUser() {

		//Pass URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();
		//set header for content type
		httpRequest.header("Content-Type", "application/json");
		//insert respective unique data
		Map<Object, Object> inputData = new HashMap<Object, Object>();
		inputData.put("FirstName", RestUtils.getFirstName());
		inputData.put("LastName", RestUtils.getLastName());
		inputData.put("UserName", RestUtils.getUserName());
		inputData.put("Password", RestUtils.getPassword());
		inputData.put("Email", RestUtils.getEmail());
		System.out.println(inputData);
		JSONObject payload = new JSONObject(inputData);
		System.out.println("payload : " + payload);
		httpRequest.body(payload.toString());
		
		//send request
		Response httpResponse = httpRequest.request(Method.POST, "/register");
		//get response

		int statusCode = httpResponse.statusCode();

		System.out.println("statusCode : " + statusCode);

		long timeTaken = httpResponse.getTime();

		System.out.println("timeTaken : " + timeTaken);
		
		String responseBody=httpResponse.body().asString();
		System.out.println("responseBody : " + responseBody);

		  Headers allheader= httpResponse.headers();
		   for (Header header : allheader) {
			System.out.println(header.getName() + "============" + header.getValue());
		}
		
		   
		   String successCode= httpResponse.jsonPath().get("SuccessCode");
		   System.out.println("successCode : " + successCode);
		
		    Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		    
		    
		    String message=  httpResponse.jsonPath().get("Message");
		   List<String> value=httpResponse.jsonPath().getList("Message");
		   for (int i = 0; i < value.size(); i++) {
			   value.get(i);

			    System.out.println("message : " + i);
		}
		    
		    Assert.assertEquals(message, "Operation completed successfully");
	}

}
