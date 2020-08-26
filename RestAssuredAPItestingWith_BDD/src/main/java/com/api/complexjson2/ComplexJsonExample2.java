package com.api.complexjson2;

import java.util.ArrayList;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ComplexJsonExample2 {
	JsonPath jsonPath = null;

	public ComplexJsonExample2() {
		jsonPath=new JsonPath(ComplexJsonPayload.payloadComplexJSON2());
	}

	@Test(priority=1)
	public void booksPrint() {
         ArrayList<String> bookName=jsonPath.get("Books");
         System.out.println(bookName);
         int bookSize=bookName.size();
         System.out.println(bookSize);
         
         for (int i = 0; i < bookSize; i++) {
			String title=jsonPath.get("Books["+i+"].title");
			System.out.println("title : " + title);
			int edition=jsonPath.getInt("Books["+i+"].Edition");
			System.out.println("edition : " + edition);
			
			int year=jsonPath.getInt("Books["+i+"].year");
			System.out.println("year : " + year);
			
		}
      
	}
	

	

}
