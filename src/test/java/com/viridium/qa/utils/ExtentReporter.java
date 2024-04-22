package com.viridium.qa.utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.viridium.qa.base.BaseClass;

public class ExtentReporter {
	
public static ExtentReports generateExtentReport() {
		
		ExtentReports extentReport= new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Viridium Automation Test Results");
		sparkReporter.config().setDocumentTitle("Viridium Automation");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
				
		extentReport.setSystemInfo("Application URL: ", BaseClass.url);
		extentReport.setSystemInfo("Browser Name: ", BaseClass.browser);
		extentReport.setSystemInfo("Operation System: ", System.getProperty("os.name"));
		extentReport.setSystemInfo("User Name: ", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version: ", System.getProperty("java.version"));
		
		return extentReport;
	}

}
