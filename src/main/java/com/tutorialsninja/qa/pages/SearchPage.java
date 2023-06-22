package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	// Objects
	@FindBy(linkText = "HP LP3065")
	private WebElement validaproduct;
	
	@FindBy(xpath = "//*[@id='content']/p[2]")
	private WebElement invalidaproduct;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// actions
	public boolean displayStatusofValidProduct() {
		boolean dispaystatus=validaproduct.isDisplayed();
		return dispaystatus;
	}
	public String displayStatusofinValidProduct() {
		String invalidproducttext=invalidaproduct.getText();
		return invalidproducttext;
	}
}
