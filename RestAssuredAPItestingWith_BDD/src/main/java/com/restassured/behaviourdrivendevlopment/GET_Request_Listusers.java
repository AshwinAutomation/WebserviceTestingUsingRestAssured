package com.restassured.behaviourdrivendevlopment;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;


public class GET_Request_Listusers {

	@Test
	public void allUsers() {
		
		Response response=
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all()
		.extract().response();
		
		
		   String responseBody=response.getBody().asString();
		   
		   System.out.println("responseBody : " + responseBody);
		
		   JsonPath path=response.jsonPath();
		 /*  
		     String responseInternalBody= path.get("data");
		   
		     System.out.println("responseInternalBody : " + responseInternalBody);  
		     
		     */
		     
		    
	}
}
