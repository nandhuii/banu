package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import com.omrbranch.AddAddress.SearchProduct_Input_Pojo;
import com.omrbranch.AddAddress.SearchProduct_Output;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC005_ProductSearchStep extends BaseClass {
	
	@Given("User add headers for search product")
	public void userAddHeadersForSearchProduct() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept"," application/json");
		Header h2=new Header("Content-Type"," application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	}
	@When("User add request body for search product {string}")
	public void userAddRequestBodyForSearchProduct(String string) {
		SearchProduct_Input_Pojo searchProduct=new SearchProduct_Input_Pojo(string);
		addBody(searchProduct);
	}
	@When("User send {string} request for search product endpoint")
	public void userSendRequestForSearchProductEndpoint(String string) {
		Response response = addReqType("POST",Endpoints.PRODUCTLIST);
		TC001_LoginStep.globalData.setResponse(response);
	}
	@Then("User should verify the search product response message matches {string} and category id saved")
	public void userShouldVerifyTheSearchProductResponseMessageMatchesAndCategoryIdSaved(String string) {
		SearchProduct_Output productOutput = TC001_LoginStep.globalData.getResponse().as(SearchProduct_Output.class);
		String message = productOutput.getMessage();
		System.out.println(message);
		Assert.assertEquals("verify ok msg",message, "OK");
	}



}
