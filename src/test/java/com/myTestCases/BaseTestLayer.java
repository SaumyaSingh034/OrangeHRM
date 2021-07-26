package com.myTestCases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.myPages.BasePage;
import com.myPages.BasePageClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestLayer {
	
	WebDriver driver;
	public BasePage page;
	public Properties prop;
	
	public BaseTestLayer()
	{
		prop = new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Selenium\\FrameworkPractice\\POM_OOPS_Concept_In_HybridFramework\\src\\main\\"
					+ "java\\com\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@BeforeMethod
	//@Parameters(value = {"browser"})
	public void setUp()
	{
		String browser = "chrome";
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("fireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Check the browser");
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		driver.manage().window().maximize();
		
		page = new BasePageClass(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
