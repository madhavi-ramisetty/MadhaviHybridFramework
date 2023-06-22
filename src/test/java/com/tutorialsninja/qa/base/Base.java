package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.uttils.utilities;

public class Base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	public  Base() {
		 prop = new Properties();
		File f = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		dataprop = new Properties();
		File datafile = new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis = new FileInputStream(datafile);
		dataprop.load(datafis);
		}catch(Throwable e)
		{
			e.printStackTrace();
		}
	}

	public WebDriver intialbrowserandOpenApplicationURL(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.IMPLICIT_WAIT_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.pageload_timeout));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
