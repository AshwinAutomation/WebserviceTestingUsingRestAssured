package com.apitest.librarybook;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class LibraryBook {

	@Test(enabled = false)
	public void addBook() {
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().header("Content-Type", "application/json").body(Payload.payloadForAddBook()).when()
				.post("/Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response();

		String httpRequest = response.asString();

		JsonPath path = new JsonPath(httpRequest);

		String id = path.get("ID");
		String message = path.get("Msg");

		System.out.println(message + "----------------" + id);

	}

	@Test(enabled=false)
	public void addBooks() {
		RestAssured.baseURI = "http://216.10.245.166";
		Response response = given().header("Content-Type", "application/json").log().all()
				.body(Payload.payloadForAddBook("learn4", "fff", "dd4", "acbd")).when().post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response();

		String httpRequest = response.asString();
		JsonPath path = new JsonPath(httpRequest);

		String id = path.get("ID");
		String message = path.get("Msg");

		System.out.println(message + "----------------" + id);

	}
	
	
     @Test(dataProvider="setData")
	public void addBooks(String name, String isbn, String aisle, String author) {
    	 RestAssured.baseURI = "http://216.10.245.166";
 		Response response = given().header("Content-Type", "application/json").log().all()
 				.body(Payload.payloadForAddBook(name,isbn,aisle,author)).when().post("/Library/Addbook.php")
 				.then().log().all().assertThat().statusCode(200).extract().response();

 		String httpRequest = response.asString();
 		JsonPath path = new JsonPath(httpRequest);

 		String id = path.get("ID");
 		String message = path.get("Msg");

 		System.out.println(message + "----------------" + id);
	}

     
     
     @DataProvider
     public Object[][] getData() {
		return new Object[][] {{"learn6","ddd","dd1","acbd"},{"learn7","eee","dd2","efgh"},{"learn7","fff","ggg","pqrs"}};
		
	}
     
     
     
     
     @DataProvider
     public Object[][] setData() {
		 Object[][] data=new Object[2][4];
    	 data[0][0]="learn1";
    	 data[0][1]="ddd2";
    	 data[0][2]="ddeee";
    	 data[0][3]="ac";
    	 return data;
	}
     
     
     
     
     
     
     
}
