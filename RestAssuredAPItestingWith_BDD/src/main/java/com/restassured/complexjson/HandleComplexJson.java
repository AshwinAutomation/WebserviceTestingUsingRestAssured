package com.restassured.complexjson;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class HandleComplexJson {


	JsonPath path;
	
	HandleComplexJson(){
		 path = new JsonPath(JsonPayload.payload());
	}
	
	
	
	@Test(priority=1,enabled=false)
	public void printNumberOfCourses() {
		
		int courseCount = path.getInt("courses.size()");

		System.out.println("courseCount : " + courseCount);
	}

	@Test(priority=2,enabled=false)
	public void printPurchaseAmount() {
      int purchaseAmount=  path.getInt("dashboard.purchaseAmount");
      System.out.println("purchaseAmount :" + purchaseAmount);
	}

	
	@Test(priority=3,enabled=false)
	public void printTitleoffirstcourse() {

	      String firstCourseName=  path.get("courses.title[0]");
	      System.out.println("firstCourseName : " + firstCourseName);
	      
	}
	
	
	@Test(priority=4,enabled=false)
	public void printAllCouresTitleAndTheirRespectivePrice() {
   
		
		int courseCont= path.getInt("courses.size()");    
		
            for (int i = 0; i < courseCont; i++) {
				
            String allCoursesName=	path.get("courses["+i+"].title");
            
            System.out.println("allCoursesName : " + allCoursesName);
        	
            int allCoursesPrice=	path.getInt("courses["+i+"].price");
            
            
           
            System.out.println("allCoursesPrice : " + allCoursesPrice);
           
			}	      
	}
	
	@Test(priority=5,enabled=false)
	public void printNumberCopiesSoldByRPA() {
	   String ActualCourse="RPA";
		int couseCount=path.getInt("courses.size()");   
		for (int i = 0; i < couseCount; i++) {
		 String titleOfCourse=path.get("courses["+i+"].title");	
		 if (titleOfCourse.equalsIgnoreCase(ActualCourse)) {
			int copiesCount=path.getInt("courses["+i+"].copies");
			System.out.println(copiesCount);
		}
		 
		 
		}
	}
	
	
	@Test(priority=6,enabled=true)
	public void verifySumOfAllCoursePricesMatchesWithPurchaseAmount() {
	   int sumOfpurchaseAmount=0;
		int coursesCount=path.getInt("courses.size()");   
		
		for (int i = 0; i < coursesCount; i++) {
		int coursesPrice=path.getInt("courses["+i+"].price");
		int coursesCopie=path.getInt("courses["+i+"].copies");
		
		int amount=coursesPrice*coursesCopie;
		
		sumOfpurchaseAmount=sumOfpurchaseAmount+amount;
			
		}
		System.out.println("sumOfpurchaseAmount: " + sumOfpurchaseAmount);
		int purchaseAmount= path.getInt("dashboard.purchaseAmount");
		System.out.println("purchaseAmount : " + purchaseAmount);
		
		Assert.assertEquals(purchaseAmount, sumOfpurchaseAmount);
		}
	
	
	
	              
	       
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

