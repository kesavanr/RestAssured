package com.restAssured.concepts;

import java.io.File;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import io.restassured.path.json.JsonPath;

public class SampleJSONParsing {
	public static void main(String[] args) throws Exception {
		SampleJSONParsing jp = new SampleJSONParsing();
		//jp.payLoad();
		jp.payLoadAdvanced();
	}
	
	private void payLoad() throws Exception {
		File f = new File(".\\src\\main\\java\\com\\restAssured\\concepts\\Payload.json");
		FileReader reader = new FileReader(f);
		JSONParser jp = new JSONParser();
		Object parse = jp.parse(reader);
		
		JSONObject jo = new JSONObject();
		jo=(JSONObject) parse;
		Object object = jo.get("framework");
		
		System.out.println(object.toString());
	}
	
	private void payLoadAdvanced() throws Exception {
		JsonPath jp = new JsonPath(Payload.employeeDetails());
		
		/*//Total number of exprienced
		int int1 = jp.getInt("Experience.size()");
		System.out.println("Total number of exprienced : " + int1);
		
		//get age of the employee
		int int2 = jp.getInt("age");
		System.out.println("get age of the employee : " + int2);
		
		//get the year of exprience in Ameritech
		Object object = jp.get("Experience.year[1]");
		System.out.println("get the year of exprience in Ameritech : " + object);*/
		
		//get the total number of employee from ameritech in software department 
		//Object object = jp.get("Experience.deparments[1].totalEmployee[1]");
		//System.out.println(object);
		System.out.println("======================");
		
		int cnt = jp.getInt("Experience.size");
		//System.out.println("here : " + cnt);
		
		for (int i = 0; i < cnt; i++) {
			Object year = jp.get("Experience.year[" + i + "]");
			Object company = jp.get("Experience.company[" + i + "]");
			int deparmentsSize = jp.getInt("Experience.deparments[" + i + "].size");
			System.out.println(year + "\n" + company);
			for (int j = 0; j < deparmentsSize; j++) {
				Object dept = jp.get("Experience.deparments[" + i + "].dept[" + j + "]");
				Object totalEmployee = jp.get("Experience.deparments[" + i + "].totalEmployee[" + j + "]");
				System.out.println(dept + "\t" + totalEmployee);
			}
			System.out.println();
		}
		System.out.println("======================");
		
		int totalExp = jp.getInt("totalExp");
		int cntExp=0;
		for (int i = 0; i < cnt; i++) {
			int exp = jp.getInt("Experience.exp[" + i + "]");
			cntExp += exp;
		}
		System.out.println("Result");
		System.out.println("totalExp :" + totalExp);
		System.out.println("cntExp :" + cntExp);
		System.out.println("======================");
	}


}

