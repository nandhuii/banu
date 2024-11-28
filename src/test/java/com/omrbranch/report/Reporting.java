package com.omrbranch.report;
	import java.io.File;
	import java.util.ArrayList;
	import java.util.List;

	import net.masterthought.cucumber.Configuration;
	import net.masterthought.cucumber.ReportBuilder;

	public class Reporting {
		public static void generateJVMReprot(String jsonFileReport) {

			// 1.mention the path of jvm report where to store?
			File file = new File("C:\\Users\\wel\\eclipse-workspace\\CucumberSamples\\target");
			// 2. create the object for configuration class
			Configuration configuration = new Configuration(file, "omr Automation");
			// 3.pass the k,v as Details-browser,os,versions,sprint
			configuration.addClassifications("os", "win11");
			configuration.addClassifications("browser", "chrome");
			configuration.addClassifications("browser version", "104");
			configuration.addClassifications("sprint", "34");
	//4.create the object for reportBuilder class to read res from JSON file
			List<String> jsonFiles = new ArrayList<>();
			jsonFiles.add(jsonFileReport);
			ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
			// 5. generate the JVM report
			builder.generateReports();

		}
	}


