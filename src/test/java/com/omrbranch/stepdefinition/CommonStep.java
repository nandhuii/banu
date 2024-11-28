package com.omrbranch.stepdefinition;



import org.junit.Assert;

import com.omrbranch.baseclass.BaseClass;

import io.cucumber.java.en.Then;

public class CommonStep  extends BaseClass{
	@Then("User should verify the status code is {int}")
	public void userShouldVerifyTheStatusCodeIs(Integer expectedStatuscode) {
		int statuscode = getStatusCode(TC001_LoginStep.globalData.getResponse());
		System.out.println(statuscode);
	Assert.assertEquals("verify Statuscode",statuscode, 200);
	}
	
}
