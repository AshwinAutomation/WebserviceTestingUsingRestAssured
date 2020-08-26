package com.libraryapi;

import java.util.HashMap;
import java.util.Map;

public class BookLibraryPayload {

	public static Object payload(String name, String isbn, String aisle, String author) {
		Map<Object, Object> inputData = new HashMap<Object, Object>();
		inputData.put("name", "learn12");
		inputData.put("isbn", "ffr");
		inputData.put("aisle", "dd4");
		inputData.put("author", "abcs");
		return inputData;
	}

}
