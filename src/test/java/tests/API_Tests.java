package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.ApiApp;
import base.BaseTest;
import domain.RequestModel;
import io.restassured.response.Response;
import utils.JsonUtils;
import utils.Log;


public class API_Tests extends BaseTest {
	
	@Test
	public void requestGetCall() {
		
		Response res = ApiApp.get("https://jsonplaceholder.typicode.com/todos/1");
		Log.info(res.body().asPrettyString());
		
	}
	
	@Test
	public void requestPostCall() {
		
		RequestModel request = new RequestModel(2,"abc","def",4); 
		Log.info("Request : "+ JsonUtils.convertToJson(request));
		Response res = ApiApp.post("https://jsonplaceholder.typicode.com/posts",JsonUtils.convertToJson(request));		
		Log.info("Response : " + res.body().asPrettyString());
		RequestModel actualResponse = JsonUtils.convertJsonToObject(res.getBody().asPrettyString(), RequestModel.class);
		
		RequestModel expectedResponse = new RequestModel(100,"abc","def",4); 
		
		boolean status = actualResponse.equals(expectedResponse);
		
		Assert.assertTrue(status, "API validation failed!");
		
//		SoftAssert softAssert = new SoftAssert();
//		softAssert.assertEquals(status, status);
//		softAssert.assertAll("Failed!");
		
		
	}
	
}
