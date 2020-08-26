package com.restassured.testdrivendevlopment;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.restassured.restutils.RestUtils;
//import static io.restassured.RestAssured.*;
//import  static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PATCH_Request {
	@Test
	public void patchData() {
		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification httpRequest = RestAssured.given();
		// set header for content type
		httpRequest.header("Content-Type", "application/json");
		Map<String, String> inputData = new HashMap<String, String>();
		inputData.put("name", RestUtils.getEmpName());
		inputData.put("job", RestUtils.getJob());
		System.out.println(inputData);
		JSONObject payload = new JSONObject(inputData);
		System.out.println(payload);
        Response httpResponse=httpRequest.request(Method.PATCH,"/api/users/2");
        int statuscode=httpResponse.getStatusCode();
        System.out.println(statuscode);
        String responseBody=httpResponse.getBody().asString();
        System.out.println("responseBody : " + responseBody);
       String updatedBodyAfterPatch=  httpResponse.jsonPath().get("updatedAt");
       System.out.println("updatedBodyAfterPatch : " + updatedBodyAfterPatch);
              Headers allHeader=httpResponse.headers();
              for (Header data : allHeader) {
            	  System.out.println(data.getName() + "====================" + data.getValue());
			}
	}

}
