package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
WebDriver driver;
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement fnamefield;
	
	@FindBy(id="input-lastname")
	private WebElement lnamefield;
	
	@FindBy(id="input-email")
	private WebElement emailfield;
	
	@FindBy(id="input-telephone")
	private WebElement telephonefield;
	
	@FindBy(id="input-password")
	private WebElement passwordfield;
	
	@FindBy(id="input-confirm")
	private WebElement passwordconfirmfield;
	
	@FindBy(name="agree")
	private WebElement agreefield;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name=\"newsletter\"][@value='1']")
	private WebElement newletterButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement Registeredwarningmessage;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement Privacywarningmessage;
	
	@FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement Fanmewarningmessage;
	
	@FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement Lanmewarningmessage;
	
	@FindBy(xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement Emailwarningmessage;
	
	@FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement Telephonewarninggmessage;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement Passwordwarninggmessage;
	
	
	//fnamewarning
	


	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//actions
	
	public void enterfname(String fnamenext)
	{
		fnamefield.sendKeys(fnamenext);
	}
	public void enterlname(String lnamenext)
	{
		lnamefield.sendKeys(lnamenext);
	}
	public void enteremail(String emailtext)
	{
		emailfield.sendKeys(emailtext);
	}
	public void entertelephone(String telephonetext)
	{
		telephonefield.sendKeys(telephonetext);
	}
	public void enterpassword(String passwordtext)
	{
		passwordfield.sendKeys(passwordtext);
	}
	public void enterconfirmpassword(String confirmedpasswordtext)
	{
		passwordconfirmfield.sendKeys(confirmedpasswordtext);
	}
	
	public void clickagreebox()
	{
		agreefield.click();
	}
	
	public AccountSuccessPage clickOnContinueButton()
	{
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	public void clickOnnewletterButton()
	{
		newletterButton.click();
	}
	public String verifyRegisterwarningMessage() {
		String registerwarningMeassge = Registeredwarningmessage.getText();
		return registerwarningMeassge;
	}
	public String verifyprivacywarningmessage() {
		String privacywarningMeassge = Privacywarningmessage.getText();
		return privacywarningMeassge;
	}
	public String verifyfnamewarningmessage() {
		String fanmewarningmessage = Fanmewarningmessage.getText();
		return fanmewarningmessage;
	}
	
	public String verifylnamewarningmessage() {
		String lanmewarningmessage = Lanmewarningmessage.getText();
		return lanmewarningmessage;
	}
	public String verifyemailwarningmessage() {
		String emailwarningmessage = Emailwarningmessage.getText();
		return emailwarningmessage;
	}
	public String verifytelephonewarningmessage() {
		String telephonewarninggmessage = Telephonewarninggmessage.getText();
		return telephonewarninggmessage;
	}
	
	public String verifypasswordwarningmessage() {
		String passwordwarninggmessage = Passwordwarninggmessage.getText();
		return passwordwarninggmessage;
	}
	public AccountSuccessPage register(String fnamenext,String lnamenext,String emailtext,String telephonetext,String passwordtext,String confirmedpasswordtext) {
		fnamefield.sendKeys(fnamenext);
		lnamefield.sendKeys(lnamenext);
		emailfield.sendKeys(emailtext);
		telephonefield.sendKeys(telephonetext);
		passwordfield.sendKeys(passwordtext);
		passwordconfirmfield.sendKeys(confirmedpasswordtext);
		newletterButton.click();
		agreefield.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	public AccountSuccessPage registerwithallFields(String fnamenext,String lnamenext,String emailtext,String telephonetext,String passwordtext,String confirmedpasswordtext) 
	{
		fnamefield.sendKeys(fnamenext);
		lnamefield.sendKeys(lnamenext);
		emailfield.sendKeys(emailtext);
		telephonefield.sendKeys(telephonetext);
		passwordfield.sendKeys(passwordtext);
		passwordconfirmfield.sendKeys(confirmedpasswordtext);
		agreefield.click();
		continueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	
	
}
