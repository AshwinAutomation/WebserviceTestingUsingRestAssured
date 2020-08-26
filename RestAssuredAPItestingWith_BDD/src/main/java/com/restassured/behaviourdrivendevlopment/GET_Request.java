package com.restassured.behaviourdrivendevlopment;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import  static org.hamcrest.Matchers.*;

public class GET_Request {

	
	@Test
	public void getRequest() {
		
	 String  httpResponce = given()//post,put body
	     .header("Content-Type","application/json")
	     
	     
	    
	    . when()//http url
	    .get("https://restapi.demoqa.com/utilities/weather/city/hyderabad")
	  
	     
	     .then()//validation
		   .statusCode(200)
		   .and()
		   .statusLine("HTTP/1.1 200 OK")
		   .and()
		   .assertThat().body("City",equalTo("Hyderabad"))
		   .and()
		   .header("Content-Type","application/json").toString();
		
		   
	}
	
	
}
