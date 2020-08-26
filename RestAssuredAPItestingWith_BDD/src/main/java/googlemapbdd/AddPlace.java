package googlemapbdd;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class AddPlace {

	
	@Test
	public void addplace() {
	 RestAssured.baseURI="https://rahulshettyacademy.com";
	 
	String response= given().header("Content-Type","application/json").queryParam("key", "qaclick123")
	 .body(Payload.addPlace)
	 .when().post("/maps/api/place/add/json")
	 .then().assertThat().statusCode(200).extract().asString();
	
	   System.out.println("response : " + response);

	  JsonPath path=new JsonPath(response);
	   
	  String id= path.get("place_id");
	   System.out.println(" id : " + id);
	}
}
