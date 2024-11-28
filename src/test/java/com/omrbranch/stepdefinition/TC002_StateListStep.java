package com.omrbranch.stepdefinition;


import java.util.ArrayList;
import com.omrbranch.AddAddress.Datum;
import com.omrbranch.AddAddress.StateListAndCityList_Output_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class TC002_StateListStep extends BaseClass {
	
	@Given("User add headers for to StateList")
	public void userAddHeadersForToStateList() {
	   addHeader("accept", "application/json");
	}
	@When("User send {string} request for StateList endpoint")
	public void userSendRequestForStateListEndpoint(String string) {
		Response response = addReqType("GET", Endpoints.STATELIST);
		TC001_LoginStep.globalData.setResponse(response);
	}
	@Then("User should verify the stateList response message matches {string} and saved state id")
	public void userShouldVerifyTheStateListResponseMessageMatchesAndSavedStateId(String string) {
		StateListAndCityList_Output_Pojo output_Pojo = TC001_LoginStep.globalData.getResponse().as(StateListAndCityList_Output_Pojo.class);
	ArrayList<Datum> data = output_Pojo.getData();
	for (Datum dat : data) {
		String name = dat.getName();
		System.out.println("hello");
		if(name.equals("Tamil Nadu")) {
			int id = dat.getId();
			String valueOf = String.valueOf(id);
			TC001_LoginStep.globalData.setId(id);
			TC001_LoginStep.globalData.setValueOf(valueOf);
			System.out.println(valueOf);
			break;
			
		}
		
	}
	}
	
}
