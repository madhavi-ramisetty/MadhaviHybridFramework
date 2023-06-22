package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.uttils.utilities;

public class LoginTest extends Base {

	public LoginTest() {
		super();
	}

	public WebDriver driver;
	LoginPage loginpage;

	@BeforeMethod()
	public void setup() {
		driver = intialbrowserandOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		loginpage = homepage.navigateTOloginPage();
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "validcredentials")
	public void verifyLoginWithValidCredentials(String email, String password) {
		AccountPage accountPage = loginpage.clickonLoginButton(email, password);
		Assert.assertTrue(accountPage.accountinformationtext());
	}

	@DataProvider(name = "validcredentials")
	public Object[][] supply() {
		Object[][] data = utilities.getTestDataFromExcel("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredential() {
		loginpage.clickonLoginButton(utilities.generateEmailWithTimestamps(),dataprop.getProperty("invalidpassword"));
		Assert.assertTrue(loginpage.getEmailPwdwaringmessage().contains("abcd"),
				"Expected waring message is dispayed");
		//Assert.assertTrue(loginpage.getEmailPwdwaringmessage().contains(dataprop.getProperty("emailpwdwarning")),"Expected waring message is dispayed");
	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailandValidPassword() {
		loginpage.clickonLoginButton(utilities.generateEmailWithTimestamps(),prop.getProperty("validpassword"));
		Assert.assertTrue(loginpage.getEmailPwdwaringmessage().contains(dataprop.getProperty("emailpwdwarning")),
				"Expected waring message is dispayed");	
	}

	@Test(priority = 4)
	public void verifyLoginWithvalidEmailandInvalidPassword() {
		loginpage.clickonLoginButton(prop.getProperty("validusername"), dataprop.getProperty("invalidpassword"));
		Assert.assertTrue(loginpage.getEmailPwdwaringmessage().contains(dataprop.getProperty("emailpwdwarning")),
				"Expected waring message is dispayed");
	}

	@Test(priority = 5)
	public void verifyLoginWithOutCredential() {
		loginpage.clickOnLogin();
		Assert.assertTrue(loginpage.getEmailPwdwaringmessage().contains(dataprop.getProperty("emailpwdwarning")),
				"Expected waring message is dispayed");
	}

}
