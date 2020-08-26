package googlemaptdd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;
public class AddPlace {

	
	@Test
	public void addplace() {
	 RestAssured.baseURI="https://rahulshettyacademy.com";
	   RequestSpecification httpRequest= RestAssured.given();
	     Map<Object, Object> input=new HashMap<Object, Object>();
	     //input.put(key, value)

	}
}
