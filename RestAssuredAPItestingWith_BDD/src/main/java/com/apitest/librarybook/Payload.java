package com.apitest.librarybook;

public class Payload {
	public static String payloadForAddBook() {
		
		String payload="{\r\n" + 
				"    \"name\" :\"abcdww\",\r\n" + 
				"    \"isbn\" : \"cwwscc\",\r\n" + 
				"    \"aisle\":\"2d67\",\r\n" + 
				"    \"author\": \"Ashwin\"\r\n" + 
				"}";
		
		
		return payload;
	}
	
	
public static String payloadForAddBook(String name,String isbn,String aisle,String author) {
		
		String payload="{\r\n" + 
				"    \"name\" :\""+name+"\",\r\n" + 
				"    \"isbn\" : \""+isbn+"\",\r\n" + 
				"    \"aisle\":\""+aisle+"\",\r\n" + 
				"    \"author\": \""+author+"\"\r\n" + 
				"}";
		
		
		return payload;
	}
	
}
