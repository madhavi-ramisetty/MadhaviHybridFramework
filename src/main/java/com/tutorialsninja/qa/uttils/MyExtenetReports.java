package com.tutorialsninja.qa.uttils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyExtenetReports {

	public static ExtentReports generateExtentReport() {
		ExtentReports extentreport = new ExtentReports();

		File extendreportfile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentreport.html" );
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(extendreportfile);
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("tutorialninja test automation results");
		sparkreporter.config().setDocumentTitle("Test report");
		sparkreporter.config().setTimeStampFormat("dd//mm/yyyy hh:mm:ss");
		extentreport.attachReporter(sparkreporter);
		
		Properties configprop = new Properties();
			File configfile = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
			try {
				FileInputStream configfis = new FileInputStream(configfile);
				configprop.load(configfis);
			} catch (Throwable e) {
				e.printStackTrace();
			}
			extentreport.setSystemInfo("URL", configprop.getProperty("url"));	
			extentreport.setSystemInfo("browsername", configprop.getProperty("browser"));
			extentreport.setSystemInfo("email", configprop.getProperty("validusername"));	
			extentreport.setSystemInfo("OS", System.getProperty("os.name"));
			extentreport.setSystemInfo("JAVA VERSION", System.getProperty("java.version"));
			extentreport.setSystemInfo("username", System.getProperty("user.name"));
			return extentreport;
	}

}
