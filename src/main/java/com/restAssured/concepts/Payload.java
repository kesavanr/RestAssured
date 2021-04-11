package com.restAssured.concepts;

public class Payload {
	public static String createRepo() {
		return "{\r\n" + 
				"    \"name\": \"Repo_REST1\",\r\n" + 
				"    \"description\": \"This is your first repository\",\r\n" + 
				"    \"homepage\": \"https://github.com\",\r\n" + 
				"    \"private\": false,\r\n" + 
				"    \"has_issues\": true,\r\n" + 
				"    \"has_projects\": true,\r\n" + 
				"    \"has_wiki\": true\r\n" + 
				"}";
	}
	
	public static String employeeDetails() {
		return "{\r\n" + 
				"	\"name\":\"kesavan\",\r\n" + 
				"	\"age\":\"36\",\r\n" + 
				"	\"Professional\":\"QA\",\r\n" + 
				"	\"framework\":\"cucumber\",\r\n" + 
				"	\"totalExp\":\"9\",\r\n" + 
				"	\"Experience\" :[\r\n" + 
				"		{\r\n" + 
				"			\"year\" :\"2006-2010\",\r\n" + 
				"			\"company\":\"SSPL\",\r\n" + 
				"			\"exp\":\"4\",\r\n" + 
				"			\"deparments\" :[\r\n" + 
				"				{\r\n" + 
				"				\"dept\":\"developer\",\r\n" + 
				"				\"totalEmployee\":\"15\"\r\n" + 
				"				}\r\n" + 
				"			]\r\n" + 
				"		},\r\n" + 
				"		{\r\n" + 
				"			\"year\" :\"2010-2015\",\r\n" + 
				"			\"company\":\"Ameritech\",\r\n" + 
				"			\"exp\":\"5\",\r\n" + 
				"			\"deparments\" :[\r\n" + 
				"				{\r\n" + 
				"					\"dept\":\"grafix\",\r\n" + 
				"					\"totalEmployee\":\"25\"\r\n" + 
				"				},\r\n" + 
				"				{\r\n" + 
				"					\"dept\":\"software\",\r\n" + 
				"					\"totalEmployee\":\"10\"\r\n" + 
				"				}\r\n" + 
				"			]\r\n" + 
				"		}\r\n" + 
				"	]\r\n" + 
				"}";
	}
	
	public static String replaceAllRepositoryTopics() {
		return "{\r\n" + 
				"    \"names\":\r\n" + 
				"    [\r\n" + 
				"        \"selenium2\",\r\n" + 
				"        \"maven2\",\r\n" + 
				"        \"cucumber2\"\r\n" + 
				"    ]\r\n" + 
				"}";
	}
}
