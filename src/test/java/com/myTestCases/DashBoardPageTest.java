package com.myTestCases;

import org.testng.annotations.Test;

import com.myPages.DashBoardPage;
import com.myPages.LoginPage;

import junit.framework.Assert;

public class DashBoardPageTest extends BaseTestLayer{
	
	DashBoardPage dashboard;
	
	@Test(priority=1)
	public void getTitleOfPage() throws InterruptedException
	{
		
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
		page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		String title = dashboard.getInstance(DashBoardPage.class).titleOfPage();
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void printCountOfMainMenuItems() throws InterruptedException
	{
		page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		int count = dashboard.getInstance(DashBoardPage.class).getMainMenuItems();
		System.out.println("Count of Items :: "+count);
		Assert.assertEquals(count, 11);
	}
	
	@Test(priority=3)
	public void printNameOfMainMenuItems() throws InterruptedException
	{
		page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.getInstance(DashBoardPage.class).printNameOfMainMenuItems();
	}
	
	@Test(priority=4)
	public void printDashBoardItems() throws InterruptedException
	{
		page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard = page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
		dashboard.getInstance(DashBoardPage.class).printNameOfDashBoardItems();
	}
	
	

}
