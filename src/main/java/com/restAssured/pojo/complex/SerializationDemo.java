package com.restAssured.pojo.complex;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDemo {

	public static void main(String[] args) throws JsonProcessingException {
		String companyname = "abc techonologies";
		String location = "india";
		String status = "true";		
		int innogration = 2009;
		double annualIncome = 2000000.00;
		
		Departments departments = new Departments(10, 2, 5);
		Projects projects = new Projects("e-commerce", departments);
		
		Departments departments1 = new Departments(7, 4, 1);
		Projects projects1 = new Projects("healthcare", departments1);
		
		List<Projects> lstprojects = new ArrayList<Projects>();
		lstprojects.add(projects);
		lstprojects.add(projects1);
		PayLoad payLoad = new PayLoad(companyname, location, status, lstprojects, innogration, annualIncome);

		ObjectMapper objMap = new ObjectMapper();
		String json = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(payLoad);
		System.out.println(json);
	}

}
