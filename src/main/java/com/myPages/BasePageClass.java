package com.myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePageClass extends BasePage {

	public BasePageClass(WebDriver driver) {
		super(driver);

	}

	@Override
	public String getPageTitle() {
		return driver.getTitle();

	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;

		} catch (Exception e) {
			System.out.println("Oops, seems like someexception occured : : " + e
					+ " seems like the locator we are working on might" + " have some issue :: " + locator.toString());
			e.printStackTrace();
		}
		return element;

	}

	@Override
	public void waitForElementPresent(By locator) {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Some exception/error occured while waiting  for the element " + locator.toString());
			e.printStackTrace();
		}

	}

	@Override
	public void waitForVisibilityOfPageTitle(String title) {

		try {
			wait.until(ExpectedConditions.titleContains(title));
		} catch (Exception e) {
			System.out.println("Some issue with waiting of title " + title);
			e.printStackTrace();
		}

	}

}
