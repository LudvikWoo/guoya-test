package com.guoyasoft.tools.http;

import org.testng.annotations.DataProvider;

import com.guoyasoft.tools.csv.CSVReader;

public class ApacheHttpDataProvider {

	@DataProvider(name="loginUser")
	public static Object[][] getLoginUser(){
		Object[][] objs=CSVReader.readCSV("src/main/java/com/guoyasoft/tools/http/loginUsers.csv");
		return objs;
	}
}
