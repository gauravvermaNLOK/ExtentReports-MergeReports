package com.gaurav.mergereports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.JsonFormatter;

public class TestSuite1 {
	ExtentReports extentReports = null;
	@BeforeSuite
	public void setup1()
	{
		//Create object of ExtentReports
		extentReports = new ExtentReports();
		//ExtentSparkReporter is to communicate the path of HTML report to ExtentReports object
		ExtentSparkReporter spark = new ExtentSparkReporter("TS1_Spark.html");
		
		//Create Json Directory which will store Json format of results
		String strJsonDir = Util.createDirectoryForJsonReport();
		//JsonFormatter is to communicate the path of HTML report to ExtentReports object
		JsonFormatter jsonFormatter = new JsonFormatter(strJsonDir + "/TS1_Spark.json");
		//Pass ExtentSparkReporter and JsonFormatter object to ExtentReport. That is how we tell ExtentReports
		//Where HTML Report and JSON report should be stored
		extentReports.attachReporter(jsonFormatter, spark);
	}
		
	@Test
	public void test1()
	{
		extentReports.createTest("TS1_TC1").pass("TS1_TC1->Expected: True | Actual: True");
	}
	
	@Test
	public void test2()
	{
		extentReports.createTest("TS1_TC2").fail("TS1_TC2->Expected: True | Actual: False");
	}
	
	@AfterSuite
	public void tearDown()
	{
		extentReports.flush();
	}
}