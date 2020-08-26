package com.restassured.behaviourdrivendevlopment;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POST_Request {

	Map<Object, Object> payload = new HashMap<Object, Object>();

	@BeforeSuite
	public void setPayloac() {

		payload.put("FirstName", RestUtils.getFirstName());
		payload.put("LastName", RestUtils.getLastName());
		payload.put("UserName", RestUtils.getUserName());
		payload.put("Password", RestUtils.getPassword());
		payload.put("Email", RestUtils.getEmail());
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";

	}

	@Test
	public void postWeatherRequest() {

		given().contentType("application/json")
		.body(payload)

				.when().post()

				.then().statusCode(201)
				.and()
                .body("SuccessCode",equalTo("OPERATION_SUCCESS"))
                .and()
                .body("Message",equalTo("Operation completed successfully"))
                 ;
                
                ;
		/*
		 * .and() .body("SuccessCode","OPERATION_SUCCESS")
		 * 
		 * 
		 * .and() .body("Message","Operation completed successfully");
		 */

	}

}
