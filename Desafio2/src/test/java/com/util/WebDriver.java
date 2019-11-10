package com.util;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriver{

	private static WebDriver driver = null;
	static String driverPath = "D:\\Teste\\Eclipse";
	
	public void getDriver(String browser) throws Exception{
		
		if (driver == null) {
			
			if (browser.equalsIgnoreCase("FIREFOX")){
				System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
				driver = new FirefoxDriver();
			}

			else if (browser.equalsIgnoreCase("CHROME")) {
				System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe"); 
				driver = new ChromeDriver();
			}
			
			else if (browser.equalsIgnoreCase("OPERA")){
		        System.setProperty("webdriver.chrome.driver", driverPath+"operadriver.exe");
		        driver = new OperaDriver();
			}
			else {
				throw new Exception("Browser name incorrect");
			}
		}
		return driver;
	}	
}
