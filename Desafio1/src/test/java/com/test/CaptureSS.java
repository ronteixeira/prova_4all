package com.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class CaptureSS {
	private WebDriver driver;
		
	public CaptureSS (WebDriver driver) {
		this.driver = driver;
	}
	
	public void captureSS(String finishedSell) throws IOException {
		try {
			File ssFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssFile, new File("Screenshots\\"+finishedSell+".png"));
		}
		catch (Exception error) {
			System.out.println("Execution error:"+error.getMessage());
		}
	}

}
