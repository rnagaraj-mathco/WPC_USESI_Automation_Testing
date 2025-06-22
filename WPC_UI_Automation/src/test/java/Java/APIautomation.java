package Java;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class APIautomation {
 
	public static void main(String[] args) {
  
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
  
		RestAssured.given().when().get("/posts/1").then().statusCode(200).time(Matchers.lessThan(5000L)).log().all();
  
  
 }
}

 
