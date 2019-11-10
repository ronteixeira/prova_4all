package com.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.pages.SelectionPage;
import com.pages.FinishSell;
import com.test.CaptureSS;

public class DocesTest {
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
	public void addProductsTest() {
		selectionPage = new SelectionPage(driver);
		selectionPage.open();
		selectionPage.SelectCategory("Doces");
		selectionPage.SelectProducts("Brigadeiro");
		selectionPage.confirmationMessage();
		selectionPage.SelectProducts("Alfajor de chocolate");
		selectionPage.confirmationMessage();
		selectionPage.SelectCategory("Todos");
		selectionPage.ClickButton("cart-btn");
		assertEquals("BELLA GULA", finishSell.isLoaded());
		finishSell.addProduct("Brigadeiro", '4');
		finishSell.ClickButtonName("Finalizar Compra");
		assertEquals("Pedido realizado com sucesso!", finishSell.ValidadeSuccessMessage());

		
		
		finishSell.ClickButtonName("Fechar");
		driver.close();
	}

}
