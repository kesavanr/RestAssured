package com.restAssured.concepts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.spi.RegisterableService;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
/*import org.junit.Assert;
import org.junit.Test;*/
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import static org.hamcrest.Matchers.*;
/**
 * Hello world!
 *
 */
public class Get_Request extends ConfigDetails
{
	//@Test
    public void getRequest()
    {
        RestAssured.baseURI="https://reqres.in/";
		RequestSpecification given = RestAssured.given();
        Response response = given.get("/api/users/2");
        String asString = response.asString();
        System.out.println(asString);
        int statusCode = response.statusCode();
        System.out.println(statusCode);
        Assert.assertEquals(200, statusCode);
    }
    
    @Test(priority=1)
    public void getAllRepos() {
    	RestAssured.baseURI="https://api.github.com";
    	Response response = RestAssured.given().
    		accept(ContentType.JSON)
    		.header("Content-type", "application/json")
    		.contentType(ContentType.JSON) 
    		.auth().oauth2(git_accessToken)
    		//.log().all()
    	.when()
    		.get("/user/repos")
    	.then().assertThat().statusCode(200).log().body()
    	.body("name[0]", equalTo("AdactinCucumber"))
    	.extract().response();
    	//System.out.println(response.asString());
    	JsonPath jsonPath = response.jsonPath();
    	int si = jsonPath.getInt("name.size()");
    	for (int i = 0; i < si; i++) {
			String string = jsonPath.getString("name[" + i+ "]");
			System.out.println(string);
		}
	}
    
    //@Test(priority=2)
    public void createRepo() {
		RestAssured.baseURI="https://api.github.com";
		
		/*JSONObject req = new JSONObject();
		req.put("name", "Repo_REST1");
		req.put("description", "Creating from rest");
		req.put("homepage", "https://github.com");
		req.put("private", "true");
		req.put("has_issues", "true");
		req.put("has_projects", "true");
		req.put("has_wiki", "true");*/
		
		RestAssured.given()
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.header("content-type","application/json")
			//.body(req.toJSONString())
			.body(Payload.createRepo())
			.auth().oauth2(git_accessToken)
		.when()
			.post("/user/repos")
		.then()
		.assertThat().statusCode(201).log().body()
		.body("name", equalTo("Repo_REST1"));
		
		//.assertThat().statusCode(201).log().all().body("name", equalTo("Repo_REST1"));
		
		/*RequestSpecification given = RestAssured.given();
		RequestSender when = RestAssured.when();
		when.post().then().assertThat().statusCode(200).log().all();*/
	}
    
    //@Test(priority=3)
    public void getRepo() {
    	RestAssured.baseURI="https://api.github.com";
    	RestAssured.given()
    		.header("Content-type","application/json")
    		.header("accept","application/vnd.github.v3+json")
    		.accept(ContentType.JSON)
    		.contentType(ContentType.JSON)
    		.auth().oauth2(git_accessToken)
    	.when()
    		.get("/repos/" + git_username + "/" + git_repo + "")
    	.then()
    		.assertThat().statusCode(200).log().all();
	}
    
    //@Test(priority=4)
    public void updateRepo() {
		RestAssured.baseURI="https://api.github.com";
		
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("content-type", "application/json");
		
		JSONObject req = new JSONObject();
		req.put("private", "false");
		
		RestAssured.given()
			.headers(headers)
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.auth().oauth2(git_accessToken)
			.body(req.toJSONString())
		.when()
			.patch("/repos/" + git_username + "/" + git_repo+ "")
		.then()
			.assertThat().statusCode(200).log().all();
	}
    
    //@Test(priority=5)
    public void getAllReposTopic() {
    	JSONArray obj1 = new JSONArray();
    	obj1.add("selenium1");
    	obj1.add("cucumber1");
    	obj1.add("maven11");
    	obj1.add("cucumber-extent-report1");
    	//System.out.println(obj1);
    	
    	RestAssured.baseURI="https://api.github.com";
    	Response response = RestAssured.given()
    		.log().all()
    		.accept(ContentType.JSON)
    		.header("Content-type", "application/json")
    		.header("Accept", "application/vnd.github.mercy-preview+json")
    		.contentType(ContentType.JSON) 
    		.auth().oauth2(git_accessToken)
    	.when()
    		.get("/repos/" + git_username + "/Repo_PM2/topics")
    	//.then().log().all().assertThat().body("names", equalTo(obj1));
    		.then().log().all()
    		.assertThat()
    		.statusCode(200).extract().response();
    		//.body("names", equalTo(obj1)).extract().response();
    		//.body("names",  containsString("cucumber-extent-report1")).extract().response();
    		//.then().log().all();   
    	
    	String asString = response.asString();
    	
    	Headers headers = response.headers();
    	List<Header> asList = headers.asList();
    	for (Header header : asList) {
			System.out.println(header.getName() + " " + header.getValue());
		}
    	    	
    	System.out.println("----------------");
    	System.out.println(asString);
    	//Assert.assertEquals(actual, expected);
    	Assert.assertEquals(asString.contains("cucumber-extent-report1"), true);
	}
    
    //@Test
    public void replaceAllRepositoryTopics() {
		RestAssured.baseURI="https://api.github.com";
		
		/*Set<String> topics = new HashSet<String>();
		topics.add("\"selenium2\"");
		topics.add("\"maven2\"");
		topics.add("\"cucumber2\"");
		topics.add("\"cucumber-extent-report\"");*/
		
		JSONArray topics1 = new JSONArray();
		topics1.add("selenium1");
		topics1.add("maven1");
		topics1.add("cucumber1");
		topics1.add("cucumber-extent-report1");
		
		JSONObject req = new JSONObject();
		req.put("names", topics1);
		System.out.println(topics1);
		System.out.println(req.toJSONString());
		
		RestAssured.given()			
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.header("Content-Type", "application/json")
			.header("Accept", "application/vnd.github.mercy-preview+json")
			.auth().preemptive().oauth2(git_accessToken)
			.body(req.toJSONString())
			//.body(Payload.replaceAllRepositoryTopics())
		.when()
			.put("/repos/" + git_username + "/Repo_PM2/topics")
		.then()
			.assertThat().statusCode(200).log().all();
	}
    
    //@Test(priority=6)
    public void deleteRepo() {
		RestAssured.baseURI="https://api.github.com";
		RestAssured.given()
			.header("Content-type", "application/json")
			.header("accept", "application/vnd.github.v3+json")
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			.auth().oauth2(git_accessToken)
		.when()
			.delete("/repos/" + git_username + "/" + git_repo + "")
		.then()
			.assertThat().statusCode(204).log().all();
		
	}
}
