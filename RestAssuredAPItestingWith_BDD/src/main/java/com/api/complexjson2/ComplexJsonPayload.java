package com.api.complexjson2;

public class ComplexJsonPayload {

	
	public static String payloadComplexJSON1() {
		
		String payloadExample1="{\"FirstName\":\"John\",\r\n" + 
				"\"LastName\":\"Cena\",\r\n" + 
				"\"age\":26,\r\n" + 
				"\"address\":\r\n" + 
				"{\r\n" + 
				"    \"Street\":\"America\",\r\n" + 
				"    \"City\":\"Chicago\",\r\n" + 
				"    \"Postalcode\":\"630610\"\r\n" + 
				"},\r\n" + 
				"\"PhoneNumbers\":[\r\n" + 
				"    {\"type\":\"personal\",\r\n" + 
				"    \"ContactNo\":\"9937243596\"\r\n" + 
				"    },\r\n" + 
				"     {\"type\":\"Home\",\r\n" + 
				"    \"ContactNo\":\"8977201530\"\r\n" + 
				"    }\r\n" + 
				"]\r\n" + 
				"}\r\n" + 
				"";
		
		return payloadExample1;
	}
	
	
	public static String payloadComplexJSON2() {
		
		String payloadExample2="{ \"Books\":\r\n" + 
				"  [\r\n" + 
				"    {\r\n" + 
				"      \"title\":\"Prefessional Javascript\",\r\n" + 
				"       \"authors\":[\"Nichoal C.Zakas\"],\r\n" + 
				"       \"Edition\":3,\r\n" + 
				"       \"year\":2011\r\n" + 
				"    },\r\n" + 
				"    \r\n" + 
				"     {\r\n" + 
				"      \"title\":\"Prefessional Javascript\",\r\n" + 
				"       \"authors\":[\"Nichoal C.Zakas\"],\r\n" + 
				"       \"Edition\":2,\r\n" + 
				"       \"year\":2009\r\n" + 
				"    },\r\n" + 
				"     {\r\n" + 
				"      \"title\":\"Prefessional Ajax\",\r\n" + 
				"       \"authors\":[\"Nichoal C.Zakas\",\"Jerymy Mcpeak\",\"Joe Fawcett\"],\r\n" + 
				"       \"Edition\":1,\r\n" + 
				"       \"year\":2008\r\n" + 
				"    }\r\n" + 
				"    ]\r\n" + 
				"}";
		
		return payloadExample2;
	}
	
	
}
