package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePageClass {

	// Page Locators
	private By username = By.id("txtUsername");
	private By password = By.id("txtPassword");
	private By loginBtn = By.id("btnLogin");
	private By forgetPasswd = By.xpath("//*[text()='Forgot your password?']");
	private By companyLogo = By.xpath("//img[contains(@src,'/webres_6051af48107ce6.31500353/')]");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// getters

	/**
	 * @return the username
	 */
	public WebElement getUsername() {
		return getElement(username);
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return getElement(password);
	}

	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}

	/**
	 * @return the forgetPasswd
	 */
	public WebElement getForgetPasswd() {
		return getElement(forgetPasswd);
	}

	/**
	 * @return the companyLogo
	 */
	public WebElement getCompanyLogo() {
		return getElement(companyLogo);
	}
	
	// public methods/actions
	
	public String getTitleOfLoginPage()
	{
		return getPageTitle();
	}
	
	public DashBoardPage loginWithValidCredentials(String user, String pwd) throws InterruptedException
	{
		getUsername().sendKeys(user);
		Thread.sleep(9000);
		getPassword().sendKeys(pwd);
		Thread.sleep(9000);
		getLoginBtn().click();
		Thread.sleep(9000);
		return getInstance(DashBoardPage.class);
	}
	
	public Boolean forgetPassword()
	{
		return getForgetPasswd().isDisplayed();
	}

}
