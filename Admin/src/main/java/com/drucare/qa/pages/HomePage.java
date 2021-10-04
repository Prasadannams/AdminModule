package com.drucare.qa.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.helpers.PageHelpers;
import com.google.common.util.concurrent.Uninterruptibles;

public class HomePage extends TestBase {
	Logger logger = Logger.getLogger(HomePage.class);

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	// PageFactory/Object Repository
	@FindBy(xpath = "//button[contains(text(),'Login')]")
	@CacheLookup
	WebElement homePageLogin;

	@FindBy(xpath = "//h1[text()='Your connection is not private']//following::button[3]")
	WebElement btnAdvanced;

	@FindBy(xpath = "//h1[text()='Your connection is not private']//following::a[5]")
	WebElement QALink;

	public HomePage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	public void loginObj() {
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		try {
			btnAdvanced.click();
			QALink.click();
		} catch (Throwable e) {
			logger.info(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(homePageLogin);
	}
}
