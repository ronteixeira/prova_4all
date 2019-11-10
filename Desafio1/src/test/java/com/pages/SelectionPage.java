package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectionPage {
	private WebDriver driver;

	public SelectionPage(WebDriver driver) {
		this.driver = driver;
	}

	public SelectionPage open() {
		driver.get("https://shopcart-challenge.4all.com");
		return this;
	}

	public void SelectCategory(String categoryName) {
		WebElement openCategory = driver.findElement(By.id("open-categories-btn"));
		openCategory.click();
		WebElement selectCategory = driver.findElement(By.xpath("//*[contains(text(), '"+categoryName+"')]"));
		selectCategory.click();
	}
	
	public void SelectProducts(String productName) {
		WebElement product = driver.findElement(By.xpath("//*[contains(text(), '"+productName+"')]//../../..//button"));
		product.click();
	}
	
	public void confirmationMessage() {
		boolean successMessage = driver.findElement(By.className("Toastify__toast-body")).isDisplayed();
		System.out.println(successMessage);
	}
	
	public void ClickButton(String buttonId) {
		WebElement button = driver.findElement(By.id(buttonId));
		button.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}