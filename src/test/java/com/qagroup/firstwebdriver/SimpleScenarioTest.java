package com.qagroup.firstwebdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;

public class SimpleScenarioTest {

	private WebDriver webDriver;

	@BeforeMethod
	public void setUp() {
		// Finds path to the root directory of the project
		String baseDir = System.getProperty("user.dir");
		// Sets path to the chromedriver.exe file
		System.setProperty("webdriver.chrome.driver", baseDir + "\\src\\main\\resources\\webdriver\\chromedriver.exe");
		// Starts Chrome browser
		webDriver = new ChromeDriver();
		// Sets implicit timeout to wait for web elements in case they are not
		// rendered yet
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testDownloadsPageTitle() {
		navigateToSeleniumDownloads();

		// Verifies that title as shown on browser tab is equal to the expected
		// value
		Assert.assertEquals(webDriver.getTitle(), "Downloads");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (webDriver != null)
			webDriver.quit();
	}

	@Step
	private void navigateToSeleniumDownloads() {
		openGoogle();
		searchFor("selenium ide");
		selectLinkByText("Selenium IDE Plugins");
		selectDownloadTab();
	}

	@Step("Open Google")
	private void openGoogle() {
		webDriver.get("https://www.google.com.ua/");
	}

	@Step("Search for \"{0}\"")
	private void searchFor(String query) {
		webDriver.findElement(By.id("lst-ib")).sendKeys(query);
		webDriver.findElement(By.name("btnG")).click();
	}

	@Step("Select Link by Text \"{0}\"")
	private void selectLinkByText(String linkText) {
		webDriver.findElement(By.linkText(linkText)).click();
	}

	@Step("Select 'Download' tab")
	private void selectDownloadTab() {
		webDriver.findElement(By.cssSelector("#menu_download > a")).click();
	}
}
