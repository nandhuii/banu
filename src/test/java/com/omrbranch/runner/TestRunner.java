package com.omrbranch.runner;


	import org.junit.AfterClass;
	import org.junit.runner.RunWith;

import com.omrbranch.baseclass.BaseClass;
import com.omrbranch.report.Reporting;

import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;
	import io.cucumber.junit.CucumberOptions.SnippetType;

	@RunWith(Cucumber.class)
	@CucumberOptions(tags="@Login or @state or @city or @g or @i",stepNotifications = true, publish = true, snippets = SnippetType.CAMELCASE, monochrome = true, dryRun = false, plugin = {
			"pretty",
			"json:target\\output.json" },  glue = "com.omrbranch.stepdefinition", features = "src\\test\\resources")

	public class TestRunner extends BaseClass{
		@AfterClass
		public static void afterClass() {
			Reporting.generateJVMReprot(getProjectPath()+"\\target\\output.json" );
		}
	}


