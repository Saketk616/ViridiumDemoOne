package com.viridium.qa.listeners;

import java.io.File;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.viridium.qa.utils.ExtentReporter;


public class ListenersOne implements ITestListener {
	ExtentReports extentReport;
	ExtentTest extentTest;
	
	@BeforeSuite
	@Override
	public void onStart(ITestContext context) {
		
		extentReport =ExtentReporter.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		extentTest = extentReport.createTest(testName);
		extentTest.log(Status.INFO,testName+" started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.PASS,testName+" got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getName();
		System.out.println("Inside on test failure listener");
		WebDriver driver=null;
		System.out.println("initialized driver= null");

		try {
			System.out.println("inside try block");
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		
			System.out.println("got driver from method");
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			System.out.println("inside catch");
			e.printStackTrace();
			System.out.println("printed stack trace");
		}
		System.out.println("outside try catch, driver is :"+driver);
		//File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File srcScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		System.out.println("taken screenshot");
		
		try {
			System.out.println("inside try for file handler");
			FileHandler.copy(srcScreenshot, new File(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png"));
			System.out.println("copied screenshot source to destination");
		} catch (IOException e) {
			System.out.println("inside exception for file handler");
			e.printStackTrace();
			System.out.println("printed stack trace for file handler");
		}
		System.out.println("screenshot done");
		extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png");
		System.out.println("attached screenshot to extent report");
		extentTest.log(Status.INFO, result.getThrowable());
		System.out.println("loged info");
		extentTest.log(Status.FAIL, testName+" got failed");
		System.out.println("marked test as fail");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"  got skipped");
	}

	@AfterSuite
	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

}
