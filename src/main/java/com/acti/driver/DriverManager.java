package com.acti.driver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Script: DriverManager
 * Description: This class manages all the driver instances and also a parent class for other classes which uses driver
 * Developed By: Shantosh
 * Approved By: Mohit
 * Developed Date : 2023-11-04
 */

public class DriverManager {
	
	public static WebDriver driver;
	static Properties prop;
	
	/*
	 * constructor to load the properties file
	 */
	public DriverManager() {
		try
		{
			File file = new File("./src/test/resources/config/config.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("unable to load the properties file "+e.getMessage());
			e.printStackTrace();
		}	
	}
	
	/*
	 * initApplication method to get the browser properties file value and lauch the browser accordingly
	 */
	public void initApplication() {
		String browser = prop.getProperty("browser");
		System.out.println("browser selected "+browser);
		
		if(browser.trim().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.trim().equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.trim().equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("browser not supported. please check the config.properties file");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		getAppURL();
		
	}
	
	public void getAppURL()
	{
		String url = prop.getProperty("url");
		driver.get(url);
	}
	
	public void quitBrowser()
	{
		driver.close();
	}

}
