package com.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.pages.FinishSell;
import com.pages.SelectionPage;

public class DrinksTest {
	public WebDriver driver;
	private SelectionPage selectionPage;
	private FinishSell finishSell;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Teste\\Eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@After
	public void tearDown(ITestResult testResult) throws Exception {
		if(testResult.getStatus() == ITestResult.FAILURE){
			new CaptureSS(driver).captureSS(testResult.getName());
		}
		driver.quit();
	}

	@Test
	public void test() {
		selectionPage = new SelectionPage(driver);
		selectionPage.open();
		selectionPage.SelectCategory("Bebidas");
		selectionPage.SelectProducts("Coca-cola lata");
		selectionPage.confirmationMessage();
		selectionPage.SelectProducts("Fanta uva lata");
		selectionPage.confirmationMessage();
		selectionPage.SelectProducts("Água mineral sem gás");
		selectionPage.confirmationMessage();
		selectionPage.SelectCategory("Todos");
		selectionPage.SelectProducts("Rissole médio");
		selectionPage.confirmationMessage();
		selectionPage.ClickButton("cart-btn");
		assertEquals("BELLA GULA", finishSell.isLoaded());
		finishSell.addProduct("Rissole médio", '9');
		finishSell.addProduct("Rissole médio", '5');
		finishSell.quantityItems("Coca-cola lata");
		finishSell.quantityItems("Fanta uva lata");
		finishSell.quantityItems("Água mineral sem gás");
		finishSell.ClickButtonName("Finalizar Compra");
		assertEquals("Pedido realizado com sucesso!", finishSell.ValidadeSuccessMessage());
		finishSell.ClickButtonName("Fechar");
		driver.close();
	}

}
