package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	WebDriver driver;

	// Objects
	@FindBy(xpath = "//*[@id=\"content\"]/h1")
	private WebElement registermessage;

	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions
	public String verifyRegisterMessage() {
		String registerMeassge = registermessage.getText();
		return registerMeassge;
	}

}
