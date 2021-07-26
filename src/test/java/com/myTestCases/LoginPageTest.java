package com.myTestCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.myPages.DashBoardPage;
import com.myPages.LoginPage;

public class LoginPageTest extends BaseTestLayer{
	

	
	@Test(priority=1)
	public void getTitleOfPage()
	{
		String title = page.getInstance(LoginPage.class).getTitleOfLoginPage();
		System.out.println("Title of Page is :: "+title);
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void logintoApplication() throws InterruptedException
	{
		DashBoardPage dbPage = page.getInstance(LoginPage.class).loginWithValidCredentials(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=3)
	public void checkForgetLink()
	{
		Boolean forgetL = page.getInstance(LoginPage.class).forgetPassword();
		Assert.assertTrue(forgetL);
	}

}
