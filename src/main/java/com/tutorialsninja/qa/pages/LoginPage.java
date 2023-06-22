package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//objects
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement passwordtext;
	
	@FindBy(xpath="//input[@value=\"Login\"]")
	private WebElement loginbutton;
	
	@FindBy(xpath="//body/div[@id='account-login']/div[1]")
	private WebElement EmailPasswordwarning;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//actions
	public void enterEmail(String emailtext)
	{
		email.sendKeys(emailtext);
	}
	public void enterPassword(String pwd)
	{
		passwordtext.sendKeys(pwd);
	}
	public AccountPage clickonLoginButton(String emailtext ,String pwd)
	{
		email.sendKeys(emailtext);
		passwordtext.sendKeys(pwd);
		loginbutton.click();
		return new AccountPage(driver);
	}
	
	
	public AccountPage clickOnLogin()
	{
		loginbutton.click();
		return new AccountPage(driver);
	}
	public String getEmailPwdwaringmessage()
	{
		String warningtext=EmailPasswordwarning.getText();
		return warningtext;
	}
	
}
