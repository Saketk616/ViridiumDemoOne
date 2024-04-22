package com.viridium.qa.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.viridium.qa.pages.LoginPage;
import com.viridium.qa.pages.ProjectDashboardPage;
import com.viridium.qa.utils.ExtentReporter;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	Actions act;
	public static String url="https://kb-dev-ui.azurewebsites.net/#";
	public ProjectDashboardPage projectDashboard;
	public static String browser;
	public static ExtentReports extentReport;
	
	public WebDriver intializeBrowserAndOpenApplicationURL(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		else if(browserName.equalsIgnoreCase("headlesschrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			driver = new ChromeDriver(options);
		}
		else {
			System.out.println("Please enter correct browser name");
		}
		browser=getBrowserName(driver);
		driver.manage().window().maximize();
		System.out.println("Window size: "+driver.manage().window().getSize());
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		act=new Actions(driver);	
		return driver;
	}
	
	@BeforeClass
	@Parameters("browser_name")
	public void openBrowserCreateProject(String browser_name) {
//		String browser_name="chrome";
		
		
		try {
			driver=intializeBrowserAndOpenApplicationURL(browser_name);
			projectDashboard= new ProjectDashboardPage(driver);
			LoginPage loginPage= new LoginPage(driver);
			loginPage.login("mahesh.mundfane@iauro.com","MaheshM@123#");
			
			}catch (Throwable e) {e.printStackTrace();}
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public static String getBrowserName(WebDriver driver) {
        if (driver instanceof ChromeDriver) {
            return "Chrome";
        } else if (driver instanceof FirefoxDriver) {
            return "Firefox";
        } else if (driver instanceof SafariDriver) {
            return "Safari";
        } else if (driver instanceof EdgeDriver) {
            return "Edge";
        } else {
            return "Unknown";
        }
    }
	
	@BeforeSuite
	public static void startExtentReporter() {
		extentReport =ExtentReporter.generateExtentReport();
		System.out.println("Created report");
		
	}
	
	@AfterSuite
	public static void closeExtentReporter() {
		extentReport.flush();
		System.out.println("Flushed report");
	}


}
