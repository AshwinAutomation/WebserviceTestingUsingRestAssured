package com.restassured.behaviourdrivendevlopment;

import org.testng.annotations.Test;
//import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class DELETE_Request {
	
	@Test
	public void deleteData() {
		
		Response response=
		given()
		.when()
		.delete("https://reqres.in/api/users/2")
		
		.then()
		
		.statusCode(204)
		 .and()
		 .statusLine("HTTP/1.1 204 No Content")
		//.log().all()
		.extract().response()
		;
		
	
	
		String responseBody=response.asString();
		  
	       System.out.println("responseBody : " + responseBody);
		
	   	int statuscode=response.statusCode();
	   	
	   	System.out.println(statuscode);
		
	}

}
