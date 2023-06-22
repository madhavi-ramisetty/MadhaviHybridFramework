package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends Base {
	public WebDriver driver;
	SearchPage searchPage;
	HomePage homepage;

	public SearchTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		driver = intialbrowserandOpenApplicationURL(prop.getProperty("browser"));
		 homepage = new HomePage(driver);
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void searchWithValidProduct() {
		searchPage=homepage.entersearchbutton(dataprop.getProperty("validproduct"));
		Assert.assertTrue(homepage.clickonsearchbutton().displayStatusofValidProduct());
	}

	@Test(priority = 2)
	public void searchWithInValidProduct() {
		searchPage=homepage.entersearchbutton(dataprop.getProperty("invalidproduct"));
		Assert.assertTrue(searchPage.displayStatusofinValidProduct().contains(dataprop.getProperty("noproductmessage")), "Expected  message is dispayed");
	}

	@Test(priority = 3)
	public void searchWithOutProduct() {
		searchPage =homepage.clickonsearchbutton();
		Assert.assertTrue(searchPage.displayStatusofinValidProduct().contains(dataprop.getProperty("noproductmessage")), "Expected  message is dispayed");
	}
}
