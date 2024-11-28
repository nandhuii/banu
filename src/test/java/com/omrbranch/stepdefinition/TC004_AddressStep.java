package com.omrbranch.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;


import com.omrbranch.AddAddress.AddUserAddress_Output_Pojo;
import com.omrbranch.AddAddress.DeleteAddress;
import com.omrbranch.AddAddress.GetUserAddress_Input_Pojo;
import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.endpoints.Endpoints;
import com.omrbranch.payload.address.AddressPayload;
import com.omrbranch.pojo.address.AddUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Input_Pojo;
import com.omrbranch.pojo.address.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC004_AddressStep extends BaseClass{
	AddressPayload payload=new AddressPayload();
	@Given("User add header and bearer authorization for accessing address endpoints")
	public void userAddHeaderAndBearerAuthorizationForAccessingAddressEndpoints() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept","application/josn");
		Header h2=new Header("Authorization","Bearer "+TC001_LoginStep.globalData.getLogToken());
	
		Header h3=new Header("Content-Type","application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	}
	@When("User add request body for add new address {string},{string},{string},{string},{string},{string},{string},{string},{string},and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String fistName, String lastName, String mobileNo,
			String apptName, String stateId, String cityId, String countryId, String zipCode, String address,String addressType) {
		AddUserAddress_Input_Pojo addressPayload = payload.addAddressPayload(fistName,lastName,mobileNo,apptName,stateId, cityId, countryId,  zipCode,  address, addressType);
		addBody(addressPayload);
	}
	@When("User send {string} request for addUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String string) {
	   Response response = addReqType("POST",Endpoints.ADDADDRESS);
	   TC001_LoginStep.globalData.setResponse(response);
	   
	}

	@Then("User should verify the addUserAddress response message matches {string} and get the address id saved")
	public void userShouldVerifyTheAddUserAddressResponseMessageMatchesAndGetTheAddressIdSaved(String string) {
		AddUserAddress_Output_Pojo userAddress_Output_Pojo = TC001_LoginStep.globalData.getResponse().as(AddUserAddress_Output_Pojo.class);
		String message = userAddress_Output_Pojo.getMessage();
		 String address_id = userAddress_Output_Pojo.getAddress_id();
		String value = String.valueOf(address_id);
		TC001_LoginStep.globalData.setAddress(value);
		System.out.println(message);
		Assert.assertEquals("verify Address added succesfully",message, "Address added successfully");
	}
	

	@When("User add request body to update new address {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userAddRequestBodyToUpdateNewAddressAnd(String addressId, String fistName, String lastName,String mobileNo,
			String apptName, String stateId, String cityId,String countryId, String zipCode, String address,String addressType) {
	UpdateUserAddress_Input_Pojo updateAddressPayload = payload.updateAddressPayload(addressId, fistName, lastName, mobileNo, apptName, 
			stateId, cityId, countryId, zipCode, address, addressType);
	addBody(updateAddressPayload);
	}
	@When("User send {string} request for update addUserAddress endpoint")
	public void userSendRequestForUpdateAddUserAddressEndpoint(String string) {
		Response reqType = addReqType("POST", Endpoints.UPDATEUSERADDRESS);
		TC001_LoginStep.globalData.setResponse(reqType);
	}
	
	
	@Then("User verify the update address response message matches {string}")
	public void userVerifyTheUpdateAddressResponseMessageMatches(String string) {
		UpdateUserAddress_Output_Pojo updateUser_Output = TC001_LoginStep.globalData.getResponse().as(UpdateUserAddress_Output_Pojo.class);
		String message = updateUser_Output.getMessage();
		System.out.println(message);
		Assert.assertEquals("verify Address added succesfully",message, "Address updated successfully");
	}
	
	@Given("User add Headers and Bearer authorization for accessing Get address endpoints")
	public void userAddHeadersAndBearerAuthorizationForAccessingGetAddressEndpoints() {
		List<Header> listHeader=new ArrayList<>();
		Header h1=new Header("accept"," application/json");
		Header h2=new Header("Authorization","Bearer "+TC001_LoginStep.globalData);
		listHeader.add(h1);
		listHeader.add(h2);
		Headers headers=new Headers(listHeader);
		addHeaders(headers);
	}	
	
	@When("User Send {string} request for GetUserAddress endpoint")
	public void userSendRequestForGetUserAddressEndpoint(String string) {
		Response response = addReqType("GET",Endpoints.GETUSERADDRESS);
		TC001_LoginStep.globalData.setResponse(response);
	}
	
	@Then("User verify the GetUserAddress response message matches {string}")
	public void userVerifyTheGetUserAddressResponseMessageMatches(String string) {
		GetUserAddress_Input_Pojo userAddress =TC001_LoginStep.globalData.getResponse().as(GetUserAddress_Input_Pojo.class);
		String message = userAddress.getMessage();
		Assert.assertEquals(message, "OK", "verify ok msg");
	}
	@When("User add request body for address id")
	public void userAddRequestBodyForAddressId() {
		addBody(TC003_CityListStep.payloads.deleteAddress(TC001_LoginStep.globalData.getAddress()));
		
	}
	@When("User Send {string} request for DeleteAddress endpoint")
	public void userSendRequestForDeleteAddressEndpoint(String string) {
		Response response = addReqType("DELETE",Endpoints.DELETEUSERADDRESS);
	TC001_LoginStep.globalData.setResponse(response);
	}
	@Then("User verify the DeleteAddress response message matches {string}")
	public void userVerifyTheDeleteAddressResponseMessageMatches(String string) {
		DeleteAddress deleteAddress = TC001_LoginStep.globalData.getResponse().as(DeleteAddress.class);
		String message = deleteAddress.getMessage();
	Assert.assertEquals("verify deleted msg",message,"Address deleted successfully");		

	}










	


}
