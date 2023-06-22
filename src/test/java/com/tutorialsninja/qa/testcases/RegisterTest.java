package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.uttils.utilities;

public class RegisterTest extends Base {
	public WebDriver driver;
	RegisterPage registerPage;

	public RegisterTest() {
		super();
	}

	@BeforeMethod()
	public void setup() {
		driver = intialbrowserandOpenApplicationURL(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		registerPage=homepage.navigatetoHomepage();

	}

	@AfterMethod()
	public void teardown()

	{
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyRegisterAccountWithMandatoryFields() {
		AccountSuccessPage accountSuccessPage=registerPage.register(dataprop.getProperty("fname"),dataprop.getProperty("lname"),utilities.generateEmailWithTimestamps(),dataprop.getProperty("telephone"),prop.getProperty("validpassword"),prop.getProperty("validpassword"));
		String actualHeading = accountSuccessPage.verifyRegisterMessage();
		Assert.assertEquals(actualHeading, dataprop.getProperty("registeredmessage"), "Account is not created");
	}

	@Test(priority = 2)
	public void verifyRegisterAccountWithAllFields() {	
		AccountSuccessPage accountSuccessPage =registerPage.registerwithallFields(dataprop.getProperty("fname"),dataprop.getProperty("lname"),utilities.generateEmailWithTimestamps(),dataprop.getProperty("telephone"),prop.getProperty("validpassword"),prop.getProperty("validpassword"));
		Assert.assertEquals(accountSuccessPage.verifyRegisterMessage(), dataprop.getProperty("registeredmessage"), "Account is not created");
	}

	@Test(priority = 3)
	public void verifyRegisterAccountWithExistingEmail() {
		registerPage.register(dataprop.getProperty("fname"),dataprop.getProperty("lname"),prop.getProperty("validusername"),dataprop.getProperty("telephone"),prop.getProperty("validpassword"),prop.getProperty("validpassword"));
		Assert.assertEquals(registerPage.verifyRegisterwarningMessage(), dataprop.getProperty("registeredwarningmessage"),
				"Account is alreday existing");
	}

	@Test(priority = 4)
	public void verifyRegisterAccountWithoutAnyDetails() {
		
		registerPage.clickOnContinueButton();
		Assert.assertEquals(registerPage.verifyprivacywarningmessage(), dataprop.getProperty("privacywarning"),"Blank data is paased");
		Assert.assertEquals(registerPage.verifyfnamewarningmessage(), dataprop.getProperty("fnamewarning"),"Blank first name is paased");
		Assert.assertEquals(registerPage.verifylnamewarningmessage(), dataprop.getProperty("lnamewarning"),"Blank Lat name is paased");
		Assert.assertEquals(registerPage.verifyemailwarningmessage(), dataprop.getProperty("emailwarning"),"Blank email  is paased");
		Assert.assertEquals(registerPage.verifytelephonewarningmessage(), dataprop.getProperty("telephonewarning"),"Blank telephone  is paased");
		Assert.assertEquals(registerPage.verifypasswordwarningmessage(), dataprop.getProperty("pwdwarning"), "Blank password  is paased");
	}
}
