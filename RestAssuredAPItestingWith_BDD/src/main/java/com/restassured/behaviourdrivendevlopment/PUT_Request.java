package com.restassured.behaviourdrivendevlopment;

import static io.restassured.RestAssured.*;
/*import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;*/

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.http.ContentType;

public class PUT_Request {
	static Map<Object, Object> inputData = new HashMap<Object, Object>();
	//JSONObject payload;
	String firstName = RestUtils.getFirstName();
	String lastname = RestUtils.getLastName();
	String employeeAge = RestUtils.getEmpSalary();
	int employeeID = 8;

	//@BeforeSuite
	public void setData() {

         
	/*	RestAssured.baseURI = "https://reqres.in";
		RestAssured.basePath = "/api/users/2";*/
	}

	@Test
	public void name() {
		inputData.put("first_name", firstName);
		inputData.put("last_name", lastname);
		
		System.out.println("inputdata :" + inputData);
           
		JSONObject payload=new JSONObject(inputData);

		
		
		System.out.println("payload :" + payload);
		given()
		.header("Content-Type","application/json")
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		 
		
		.body(payload.toString()).
		when()
		.put("https://reqres.in/api/users/2")
		.then()
		.and()
		.statusCode(200)
		.log().all()

		;
	}

}
