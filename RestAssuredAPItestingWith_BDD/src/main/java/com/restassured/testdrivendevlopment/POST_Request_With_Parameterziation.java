package com.restassured.testdrivendevlopment;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_Request_With_Parameterziation {

	@DataProvider
	public Object[][] inputData() {
		
		Object[][] data = new Object[2][5];
		try {
			data[0][0] = RestUtils.getFirstName();
			data[0][1] = RestUtils.getLastName();
			data[0][2] = RestUtils.getUserName();
			data[0][3] = RestUtils.getPassword();
			data[0][4] = RestUtils.getEmail();
			
			
			data[1][0] = RestUtils.getFirstName();
			data[1][1] = RestUtils.getLastName();
			data[1][2] = RestUtils.getUserName();
			data[1][3] = RestUtils.getPassword();
			data[1][4] = RestUtils.getEmail();

		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		return data;
	}

	@Test(dataProvider = "inputData")
	public void RequestPOST(String firstName, String lastName, String userName, String password, String email) {

		System.out.println("firstName : " + firstName);
		System.out.println("lastName : " + lastName);
		System.out.println("userName : " + userName);
		System.out.println("password : " + password);
		System.out.println("email : " + email);

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.header("Content-Type", "application/json");

		Map<Object, Object> inputData = new HashMap<Object, Object>();
		inputData.put("FirstName", firstName);
		inputData.put("LastName", lastName);
		inputData.put("UserName", userName);
		inputData.put("Password", password);
		inputData.put("Email", email);

		JSONObject payload = new JSONObject(inputData);

		httpRequest.body(payload.toString());

		Response httpResponse = httpRequest.request(Method.POST, "/register");

		int statusCode = httpResponse.statusCode();

		System.out.println("statusCode : " + statusCode);

		long timeTaken = httpResponse.getTime();

		System.out.println("timeTaken : " + timeTaken);

		String responseBody = httpResponse.body().asString();
		System.out.println("responseBody : " + responseBody);

		Headers allheader = httpResponse.headers();
		for (Header header : allheader) {
			System.out.println(header.getName() + "============" + header.getValue());
		}

		String successCode = httpResponse.jsonPath().get("SuccessCode");
		System.out.println("successCode : " + successCode);

		Assert.assertEquals(successCode, "OPERATION_SUCCESS");

		String message = httpResponse.jsonPath().get("Message");
		System.out.println("message : " + message);
		Assert.assertEquals(message, "Operation completed successfully");

	}

}
