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

public class StatutoryCalendarAgreementsPage {

	Logger logger = Logger.getLogger(StatutoryCalendarAgreementsPage.class);

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	@FindBy(xpath = "//div[contains(text(), 'Agreements')]")
	WebElement AgreementsTab;

	@FindBy(xpath = "//h2[text()='List of agreements']")
	WebElement ListOfAgreements;

	@FindBy(xpath = "//button[@mattooltip='Edit']")
	List<WebElement> edit;

	@FindBy(xpath = "//p[text()='1.']//following::button[1]")
	WebElement download;

	@FindBy(xpath = "//li[@formarrayname='downloadUrl']//descendant::label[1]")
	WebElement checkAttachments;

	@FindBy(xpath = "//span[text()='Select all']")
	WebElement selectAllAgrements;

	@FindBy(xpath = "//button[text()='Download']")
	WebElement downloadAgrements;

	@FindBy(xpath = "//p[text()='1.']//following::button[3]")
	WebElement delete;

	@FindBy(xpath = "//button[text()='Yes I‘m sure']")
	WebElement deleteAgreementYes;

	@FindBy(xpath = "//button[contains(text(), 'Add new agreement')]")
	WebElement btnAddNewAgreement;

	@FindBy(xpath = "//input[@placeholder='Enter agreement name']")
	WebElement enterAgreement;

	@FindBy(xpath = "//input[@placeholder='Enter agreement number']")
	WebElement enterAgreementNo;

	@FindBy(xpath = "//input[@placeholder='Date of issue']")
	WebElement dateOfIssue;

	@FindBy(xpath = "//input[@placeholder='Date of expiry']")
	WebElement dateOfExpiry;

	@FindBy(xpath = "//tbody[@class='mat-calendar-body']//td")
	WebElement checkMonth;

	@FindBy(xpath = "//div[text()='1']")
	WebElement issueOnFirst;

	@FindBy(xpath = "//button[@aria-label='Next month']")
	WebElement nextMonth;

	@FindBy(xpath = "//input[@formcontrolname='remindDays']")
	WebElement remindDays;

	@FindBy(xpath = "//textarea[contains(@placeholder, 'Enter your remarks here..')]")
	WebElement remarks;

	@FindBy(xpath = "//span[text()='Browse']")
	WebElement browseFiles;

	@FindBy(xpath = "//div[@class='file-upload']")
	WebElement input_browseFiles;

	@FindBy(xpath = "//*[@placeholder='Enter full name here']")
	WebElement fullName;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	WebElement emailId;

	@FindBy(xpath = "//*[@placeholder='Mobile number']")
	WebElement MobileNo;

	@FindBy(xpath = "//*[@formcontrolname='websiteAddress']")
	WebElement websiteAddress;

	@FindBy(xpath = "//*[@formcontrolname='addressLine1']")
	WebElement addressLine1;

	@FindBy(xpath = "//*[@formcontrolname='cityNm']")
	WebElement cityNm;

	@FindBy(xpath = "//*[@formcontrolname='districtNm']")
	WebElement districtNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='stateNm']//div")
	WebElement stateNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='stateNm']//div/div//div//input")
	WebElement enterStateNm;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//div//div//span")
	WebElement selectStateNm;

	@FindBy(xpath = "//*[@formcontrolname='pincode']")
	WebElement pincode;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryNm']//div")
	WebElement countryNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='countryNm']//div//div//div//input")
	WebElement enterCountryNm;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//following::div//div//span")
	WebElement selectcountryNm;

	@FindBy(xpath = "//button[text()=' Add agreement ']")
	WebElement addAgreement;

	@FindBy(xpath = "//button[text()='Update agreement']")
	WebElement updateAgreement;

	@FindBy(xpath = "//a[text()='Statutory Calendar']")
	WebElement statutoryCalendar;

	// Initializing PageObjects/PageFactory/OR
	public StatutoryCalendarAgreementsPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void switchToFrame() {
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.switchToFrame(0);
	}

	public void ClickOnAgreementsTab() {
		pageHelpers.ClickWebElement(AgreementsTab);
	}

	public void editAgreement() {
		pageHelpers.AssertTrue(ListOfAgreements);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		try {
			pageHelpers.breakListOfWebElements(edit);
		} catch (Exception e) {
			e.printStackTrace();
			pageHelpers.breakListOfWebElements(edit);
		}
	}

	public void btnAddNewAgreement() {
		pageHelpers.ClickWebElement(btnAddNewAgreement);
	}

	public void enterAgreement(String AgreementName) {
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		pageHelpers.SendKeysToWebElement(enterAgreement, AgreementName);
	}

	public void enterAgreementNo(String AgreementNumber) {
		pageHelpers.SendKeysToWebElement(enterAgreementNo, AgreementNumber);
	}

	public void dateOfIssue(String monthOfIssue) {
		pageHelpers.scrollIntoElementByJavaScript(dateOfIssue, _driver);
		pageHelpers.ClickWebElement(dateOfIssue);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.calendar(checkMonth, nextMonth, issueOnFirst, monthOfIssue);
	}

	public void dateOfExpiry(String monthOfExpiry) {
		pageHelpers.scrollIntoElementByJavaScript(dateOfExpiry, _driver);
		pageHelpers.ClickWebElement(dateOfExpiry);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.calendar(checkMonth, nextMonth, issueOnFirst, monthOfExpiry);
	}

	public void remindDays(String SetExpiryReminderInDays) {
		pageHelpers.SendKeysToWebElement(remindDays, SetExpiryReminderInDays);
	}

	public void remarks(String Remarks) {
		pageHelpers.SendKeysToWebElement(remarks, Remarks);
	}

//	 File Upload -->Linux

//	public void browseFiles(String uploadDocuments) {
//		pageHelpers.ClickWebElement(browseFiles);
//		Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
//		pageHelpers.StringSelection(uploadDocuments);
//		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//		pageHelpers.RobotClassEnterClick();
//		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
//	}

//	 File Upload -->Windows

	public void browseFiles(String uploadDocuments) {
		pageHelpers.ClickWebElement(browseFiles);
		Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
		pageHelpers.StringSelection(uploadDocuments);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.RobotClassTabClick();
		pageHelpers.RobotClassTabClick();
		pageHelpers.RobotClassEnterClick();
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);

	}

	public void IssuingAuthority(String Name, String Email, String MobileNumber, String Website, String Address,
			String City, String District, String State, String Pincode, String Country) {
		pageHelpers.SendKeysToWebElement(fullName, Name);

		pageHelpers.SendKeysToWebElement(emailId, Email);

		pageHelpers.SendKeysToWebElement(MobileNo, MobileNumber);

		pageHelpers.SendKeysToWebElement(websiteAddress, Website);

		pageHelpers.SendKeysToWebElement(addressLine1, Address);

		pageHelpers.SendKeysToWebElement(cityNm, City);

		pageHelpers.SendKeysToWebElement(districtNm, District);

		pageHelpers.clickOnUsingActions(stateNm);
		pageHelpers.SendKeysToWebElement(enterStateNm, State);
		pageHelpers.clickOnUsingActions(selectStateNm);

		pageHelpers.SendKeysToWebElement(pincode, Pincode);

		pageHelpers.clickOnUsingActions(countryNm);
		pageHelpers.SendKeysToWebElement(enterCountryNm, Country);
		pageHelpers.clickOnUsingActions(selectcountryNm);
	}

	public void clickAddAgreementBtn() {
		pageHelpers.clickOnUsingActions(addAgreement);
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		pageHelpers.scrollIntoElementByJavaScript(AgreementsTab, _driver);
		pageHelpers.ClickWebElement(AgreementsTab);
	}

	public void clickUpdateAgreementBtn() {
		pageHelpers.clickOnUsingActions(updateAgreement);
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		pageHelpers.scrollIntoElementByJavaScript(statutoryCalendar, _driver);
		pageHelpers.ClickWebElement(statutoryCalendar);
	}

	public void downloadAgreement() {
		Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(download);
		pageHelpers.ClickWebElement(selectAllAgrements);

		if (downloadAgrements.isEnabled()) {
			pageHelpers.ClickWebElement(downloadAgrements);
			Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		} else {
			logger.info("Attachments not available");
		}
	}

	public void deleteAgreement() {
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(delete);
		if (deleteAgreementYes.isEnabled()) {
			pageHelpers.ClickWebElement(deleteAgreementYes);
		} else {
			logger.warn("Button disabled Aggreement not deleted");
		}
	}
}
