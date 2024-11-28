package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;


import com.omrbranch.AddAddress.Datum;
import com.omrbranch.AddAddress.StateListAndCityList_Output_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.CityList_Input_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC003_CityListStep extends BaseClass{
	public static AddressPayload payloads=new AddressPayload();
	@Given("User add header  for to get CityList")
	public void userAddHeaderForToGetCityList() {
	    List<Header> listHeader=new ArrayList<>();
	    Header h1=new Header("accept","application/json");
	    Header h2=new Header("Content-Type","application/json");
	    listHeader.add(h1);
	    listHeader.add(h2);
	    Headers headers=new Headers(listHeader);
		addHeaders(headers);
	    }
	@When("User add request body state id for  get city list")
	public void userAddRequestBodyStateIdForGetCityList() {
		AddressPayload payload=new AddressPayload();
		CityList_Input_Pojo cityPayload = payload.addCityPayload(TC001_LoginStep.globalData.getValueOf());
		addBody(cityPayload);
	}
	@When("User send {string} request for CityList endpoint")
	public void userSendRequestForCityListEndpoint(String string) {
		 Response response = addReqType("POST", Endpoints.CITYLIST);
		 TC001_LoginStep.globalData.setResponse(response);
	}
	@Then("User verify the cityList response message matches {string} and saved city id")
	public void userVerifyTheCityListResponseMessageMatchesAndSavedCityId(String string) {
		StateListAndCityList_Output_Pojo cityListInput = TC001_LoginStep.globalData.getResponse().as(StateListAndCityList_Output_Pojo.class);
		ArrayList<Datum> cityList1 = cityListInput.getData();
		for(Datum eachCityList:cityList1) {
			String name = eachCityList.getName();
			if(name.equals("Alandur")) {
			int	cityIdNum = eachCityList.getId();
			TC001_LoginStep.globalData.getCityIdNum();
				System.out.println(cityIdNum);
				break;
			}
	}



	}
}
