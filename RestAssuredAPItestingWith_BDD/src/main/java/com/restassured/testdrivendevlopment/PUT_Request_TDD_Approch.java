package com.restassured.testdrivendevlopment;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT_Request_TDD_Approch {

	public String URI = "https://reqres.in";

	@Test
	public void putRequest() {

		RestAssured.baseURI = URI;
		RequestSpecification httpRequset = RestAssured.given();

		httpRequset.header("Content-Type", "application/json");

		Map<String, String> inputData = new HashMap<String, String>();

		inputData.put("first_name", RestUtils.getFirstName());
		inputData.put("last_name", RestUtils.getLastName());
		System.out.println("inputData : " + inputData);

		JSONObject payload = new JSONObject(inputData);
		httpRequset.body(payload.toString());

		Response httpResponse = httpRequset.request(Method.PUT, "/api/users/2");

		int statusCode = httpResponse.statusCode();
		System.out.println("statusCode : " + statusCode);

		String responseBody = httpResponse.getBody().asString();
		System.out.println("responseBody : " + responseBody.toString());
		
		
		String firstName=httpResponse.jsonPath().get("first_name");
		String lastName=httpResponse.jsonPath().get("last_name");
		String updatTime=httpResponse.jsonPath().get("updatedAt");
		
		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		System.out.println("updatTime : " + updatTime);
		
		
		Assert.assertTrue(responseBody.contains(firstName),"firstname not available");
	}

}
