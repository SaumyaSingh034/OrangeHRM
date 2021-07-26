package com.myPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashBoardPage extends BasePageClass{

	public DashBoardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By mainMenuItems = By.xpath("//*[@id='mainMenuFirstLevelUnorderedList']/li/a/b");
	private By dashboardDetails = By.xpath("//table[@class='quickLaungeContainer']/tbody/tr/td/div/a/span");

	/**
	 * @return the mainMenuItems
	 */
	public String titleOfPage()
	{
		return driver.getTitle();
	}
	public Integer getMainMenuItems() {
		List<WebElement> items = driver.findElements(mainMenuItems);
		return items.size();
		
	}
	public List<String> getNamesOfMainMenuItems()
	{
		List<WebElement> items = driver.findElements(mainMenuItems);
		List<String> mainMenuItemName = new ArrayList<String>();
		for(int i=0;i<items.size();i++)
		{
			String itemName = items.get(i).getText();
			System.out.println(itemName);
			mainMenuItemName.add(itemName);
			
		}
		return mainMenuItemName;
	}
	
	public List<String> getNamesOfDashbaordMenu()
	{
		List<WebElement> dahboard = driver.findElements(dashboardDetails);
		List<String> dashBoardName = new ArrayList<String>();
		for(int i=0;i<dahboard.size();i++)
		{
			String itemName = dahboard.get(i).getText();
			System.out.println(itemName);
			dashBoardName.add(itemName);
			
		}
		return dashBoardName;
	}
	
	//public actions
	
	public void printNameOfMainMenuItems()
	{
		System.out.println(getNamesOfMainMenuItems());
	}
	
	public void printNameOfDashBoardItems()
	{
		System.out.println(getNamesOfDashbaordMenu());
	}

	

}
