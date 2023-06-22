package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[contains(text(),'My Account')]")
	private WebElement AccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement Login;
	
	@FindBy(linkText="Register")
	private WebElement Register;
	
	@FindBy(name="search")
	private WebElement searchboxfield;
	
	@FindBy(xpath="//*[@id=\"search\"]/span/button")
	private WebElement searchbutton;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//actions
	
	public void clikonmyaccount()
	{
		AccountDropMenu.click();
	}
	
	public LoginPage SelectLoginOption()
	{
		Login.click();
		return new LoginPage(driver);
	}
	public LoginPage navigateTOloginPage()
	{
		AccountDropMenu.click();
		Login.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage SelectRegisterOption()
	{
		Register.click();
		return new RegisterPage(driver);
	}
	public RegisterPage navigatetoHomepage()
	{
		AccountDropMenu.click();
		Register.click();
		return new RegisterPage(driver);
	}
	public void enterSearchfield(String enteredtext)
	{
		searchboxfield.sendKeys(enteredtext);
	}
	public SearchPage clickonsearchbutton()
	{
		searchbutton.click();
		return new SearchPage(driver);
	}
	public SearchPage entersearchbutton(String enteredtext)
	{
		searchboxfield.sendKeys(enteredtext);
		searchbutton.click();
		return new SearchPage(driver);
	}
}
