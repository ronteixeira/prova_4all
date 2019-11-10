package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FinishSell {
	private WebDriver driver;

	public boolean isLoaded() {
		return driver.findElement(By.id("merchant-name")).isDisplayed();
	}

	public void addProduct(String productName, int clickTimes) {
		for (int i = 0; i < clickTimes; i++) {
			WebElement product = driver.findElement(By.xpath("//*[contains(text(), '"+productName+"')]//../div[1]/div[2]"));
			product.click();
		}
	}

	public void ClickButtonName(String buttonName) {
		WebElement button = driver.findElement(By.xpath("//*.contains[text(), '"+buttonName+"']"));
		button.click();
	}
	
	public String ValidadeSuccessMessage() {
		WebElement successMessage = driver.findElement(By.xpath("//*.contains[text(), 'Pedido realizado com sucesso!']"));
		return successMessage.getText();
	}

}
