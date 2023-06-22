package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.uttils.MyExtenetReports;
import com.tutorialsninja.qa.uttils.utilities;

public class MyListeners implements ITestListener{
	
	//private static final String WebDriver = null;
	ExtentReports extentreports;
	ExtentTest extenttest;
	
	@Override
	public void onStart(ITestContext context) {
		 extentreports = MyExtenetReports.generateExtentReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		extenttest = extentreports.createTest(result.getName());
		extenttest.log(Status.INFO,result.getName()+"Started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		extenttest.log(Status.PASS, result.getName()+"test got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualpath=utilities.captureScreenshort(driver, result.getName());
		extenttest.addScreenCaptureFromPath(actualpath);
		extenttest.log(Status.FAIL, result.getName()+"test got failed");
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		extenttest.log(Status.SKIP, result.getName()+"test got skipped");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		extentreports.flush();
		File extendreportpathfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html" );
		try {
			Desktop.getDesktop().browse(extendreportpathfile.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
