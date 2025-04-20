package com.gaurav.mergereports;

import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MergeReports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ExtentReports extentMerged = new ExtentReports();
	        ExtentSparkReporter mergedSpark = new ExtentSparkReporter("MergedReport.html");

	        // Get Directory path where JSON reports are stored
	        File jsonOPDirectory = new File(Util.createDirectoryForJsonReport());
	        
	        if (jsonOPDirectory.exists() && jsonOPDirectory.isDirectory()) {
	            File[] jsonFiles = jsonOPDirectory.listFiles();//Get all Json files
	            if (jsonFiles != null) {
	                for (File jsonFile : jsonFiles) { //Iterate through each json and merge them into extentMerged
	                    if (jsonFile.isFile() && jsonFile.getName().endsWith(".json")) {
	                        try {
	                            extentMerged.createDomainFromJsonArchive(jsonFile.getPath());
	                        } catch (IOException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            }
	        }

	        extentMerged.attachReporter(mergedSpark);
	        extentMerged.flush();

	        System.out.println("Merged report generated at: MergedReport.html");
	    }
}
