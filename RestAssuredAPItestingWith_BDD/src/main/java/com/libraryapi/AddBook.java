package com.libraryapi;

import java.io.IOException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.excelutils.ExcelUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddBook {
	String url = "http://216.10.245.166";

	public String excelsheetPath = System.getProperty("user.dir") + "/UserData/EmployeeDetails.xlsx";
	public String excelsheet = "Sheet1";
	ExcelUtils excelUtils = new ExcelUtils();
	int rc,cc;

	@Test(dataProvider = "setData")
	public void addNewBookToLibrary(String name, String isbn, String aisle, String author) throws IOException{
	    boolean res = false;
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		JSONObject obj = new JSONObject(BookLibraryPayload.payload(name, isbn, aisle, author));
		httpRequest.body(obj.toString());

		Response httpResponse = httpRequest.request(Method.POST, "/Library/Addbook.php");
		int statuscode = httpResponse.statusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);

		if (res==true) {
			excelUtils.setCellData(excelsheet, excelsheet, rc, cc, "pass");
		}
		else {
			excelUtils.setCellData(excelsheet, excelsheet, rc, cc, "Fail");
		}
	}

	// type1
	/*
	 * @DataProvider public Object[][] setDataForAddBook() { return new
	 * Object[][]{{"learn1","rre","ss2","Ashwin"}}; }
	 */

	// type2
	/*
	 * @DataProvider public Object[][] SetDataForAddBook() { Object[][] data=new
	 * Object[2][4]; data[0][0]="learn2"; data[0][1]="dde5"; data[0][2]="dd34";
	 * data[0][3]="Ashwin";
	 * 
	 * data[1][0]="learn33"; data[1][1]="pp4"; data[1][2]="333";
	 * data[1][3]="Ashish";
	 * 
	 * 
	 * return data; }
	 */

	@DataProvider
	public Object[][] setData() throws IOException {
		
		System.out.println("excelsheetPath:" + excelsheetPath);
		System.out.println("excelsheet:" + excelsheet);
		 rc = excelUtils.getRowCount(excelsheetPath, excelsheet);
		 cc = excelUtils.getCellCount(excelsheetPath, excelsheet, 1);
		System.out.println("rc:" + rc);
		System.out.println("cc:" + cc);
		Object[][] data = new Object[rc][cc];
		for (int i = 1; i <= rc; i++) {
			data[i - 1][0] = excelUtils.getCellData(excelsheetPath, excelsheet, i, 0).trim();
			data[i - 1][1] = excelUtils.getCellData(excelsheetPath, excelsheet, i, 1).trim();
			data[i - 1][2] = excelUtils.getCellData(excelsheetPath, excelsheet, i, 2).trim();
			data[i - 1][3] = excelUtils.getCellData(excelsheetPath, excelsheet, i, 3).trim();
		}
		return data;
	}

}
