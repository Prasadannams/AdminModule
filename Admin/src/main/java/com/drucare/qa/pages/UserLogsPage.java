package com.drucare.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.drucare.qa.helpers.PageHelpers;
import com.google.common.util.concurrent.Uninterruptibles;

public class UserLogsPage {

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	Logger logger = Logger.getLogger(UserLogsPage.class);

	@FindBy(xpath = "//input[@placeholder='search users by name or employee ID']")
	WebElement userLogTxtBox;

	@FindBy(xpath = "//div[@class='row m-0 p-t-12 p-b-12']")
	List<WebElement> selectUser;

	@FindBy(xpath = "//span[@class='ico calender-ico calender-ico-pos']")
	List<WebElement> icon_Calender;

	@FindBy(xpath = "//td[contains(@class, 'mat-calendar-body-label')]")
	WebElement table_checkMonth;

	@FindBy(xpath = "//button[@aria-label='Previous month']")
	WebElement btn_PreviousMonth;

	@FindBy(xpath = "//div[text()='1']")
	WebElement firstDate;

	// Initializing PageObjects/PageFactory/OR
	public UserLogsPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void switchToFrame() {
		pageHelpers.switchToFrame(0);
	}

	public void UserLogs(String SearchUsers, String Month) {
		pageHelpers.SendKeysToWebElement(userLogTxtBox, SearchUsers);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.breakListOfWebElements(selectUser);
		pageHelpers.breakListOfWebElements(icon_Calender);
		pageHelpers.calendar(table_checkMonth, btn_PreviousMonth, firstDate, Month);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(firstDate);
		pageHelpers.EnterUsingActions();
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		pageHelpers.scrollDownByActionsClass();
	}

}
