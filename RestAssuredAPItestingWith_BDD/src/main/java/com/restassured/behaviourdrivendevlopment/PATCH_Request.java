package com.restassured.behaviourdrivendevlopment;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
//import  static org.hamcrest.Matchers.*;


import org.json.JSONObject;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;

import io.restassured.response.Response;

public class PATCH_Request {
	
	@Test
	public void patchRequest() {
		
		HashMap<Object, Object> inputData=new HashMap<Object, Object>();
		inputData.put("name", RestUtils.getEmpName());
		inputData.put("job", RestUtils.getJob());
		 System.out.println(inputData);
		JSONObject payload=new JSONObject(inputData);
		Response response=
	     given()
	     .header("Content-Type","application/json")
	     .body(payload.toString())
	     .when()
	     .patch("https://reqres.in/api/users/2")
	      
	     .then()
	     .statusCode(200)
	     .and()
	     .log().all()
	     .extract().response()
	     ;
		  String responseBody=response.asString();
		  
		  System.out.println("responseBody :  " + responseBody);
	}

}
