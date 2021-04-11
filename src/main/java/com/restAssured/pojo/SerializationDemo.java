package com.restAssured.pojo;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDemo {
	public static void main(String[] args) throws JsonProcessingException {
		SerializationDemo sd = new SerializationDemo();
		//sd.payLoad();
		sd.payLoadAdvanced();
	}

	public void payLoad() throws JsonProcessingException {
		String name = "kesavan";
		int age = 36;
		String Professional = "QA";
		String framework = "cucumber";
		int totalExp = 9;

		PayLoad pl = new PayLoad(name, age, Professional, framework, totalExp);

		ObjectMapper objMap = new ObjectMapper();
		String json = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(pl);
		System.out.println(json);
	}

	public void payLoadAdvanced() throws JsonProcessingException {
		String name = "kesavan";
		int age = 36;
		String professional = "QA";

		List<String> framework = new ArrayList<String>();
		framework.add("cucumber");
		framework.add("java");
		framework.add("selenium");

		int totalExp = 0;

		PayLoadAdvanced payLoadAdv = new PayLoadAdvanced(name, age, professional, framework, totalExp);

		ObjectMapper objMap = new ObjectMapper();
		String json = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(payLoadAdv);
		System.out.println(json);
	}
}
