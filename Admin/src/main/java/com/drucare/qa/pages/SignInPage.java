package com.drucare.qa.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.helpers.PageHelpers;
import com.google.common.util.concurrent.Uninterruptibles;

public class SignInPage extends TestBase {

	Logger logger = Logger.getLogger(SignInPage.class);

	PageHelpers pageHelpers = null;
	WebDriver _driver;

	// PageFactory/Object Repository
	@FindBy(xpath = "//*[@id='UserName']")
	WebElement usernameTxt;

	@FindBy(xpath = "//*[@placeholder='Enter your password']")
	WebElement passwordTxt;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement logoutOfOtherDevice;

	@FindBy(xpath = "//h4[text()='Log out of other device?']//following::button[2]")
	WebElement btn_LogoutOfOtherDevice;

	// Initializing PageObjects/PageFactory/OR
	public SignInPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void verifylogin(String un, String pwd) {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		pageHelpers.SendKeysToWebElement(usernameTxt, un);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		pageHelpers.SendKeysToWebElement(passwordTxt, pwd);
		pageHelpers.clickOnUsingActions(loginBtn);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		try {
			if (logoutOfOtherDevice.isDisplayed()) {
				pageHelpers.ClickWebElement(logoutOfOtherDevice);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}
}
