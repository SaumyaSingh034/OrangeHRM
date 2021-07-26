package com.myPages;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 15);
	}
	
	//abstract methods :
	
	public abstract String getPageTitle();
	
	public abstract String getPageHeader(By locator);
	
	public abstract WebElement getElement(By locator);
	
	public abstract void waitForElementPresent(By locator);
	
	public abstract void waitForVisibilityOfPageTitle(String title);
	
	public <TPage extends BasePageClass> TPage getInstance(Class<TPage> pageClass)
	{
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		} catch (Exception e) {
		
		}
		return null;
		
	}
}
