package com.omrbranch.stepdefinition;

import org.junit.Assert;
import com.omrbranch.GlobalData.GlobalData;
import com.omrbranch.Login.Login_Output_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC001_LoginStep extends BaseClass{
	public static GlobalData globalData=new GlobalData();
	@Given("User add header")
	public void userAddHeader() {
		addHeader("accept", "application/json");
	}
	@When("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {
		addBasicAuth("nandynandy.240799@gmail.com", "Nandhu@123");
	}
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String string) {
		Response response = addReqType("POST",Endpoints.LOGIN);
		globalData.setResponse(response);
	}
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void userShouldVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtokenSaved(String string) {
		Login_Output_Pojo login_Output= globalData.getResponse().as(Login_Output_Pojo.class);
		String first_name = login_Output.getData().getFirst_name();
		String logtoken = login_Output.getData().getLogtoken();
		globalData.setLogToken(logtoken);
		System.out.println(first_name);
		Assert.assertEquals("verify first name",first_name, "Nandhini");
	}
}
