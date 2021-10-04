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

public class StatutoryCalendarLicencePage {

	Logger logger = Logger.getLogger(StatutoryCalendarLicencePage.class);

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	@FindBy(xpath = "//button[contains(text(), ' Add new licence ')]")
	WebElement btnAddLicence;

	@FindBy(xpath = "//p[text()='1.']//following::button[2]")
	WebElement editLicence;

	@FindBy(xpath = "//p[text()='1.']//following::button[1]")
	WebElement downloadLicenceIcon;

	@FindBy(xpath = "//span[text()='Select all']")
	WebElement selectAllLicences;

	@FindBy(xpath = "//button[text()='Download']")
	WebElement downloadLicencesBtn;

	@FindBy(xpath = "//p[text()='1.']//following::button[3]")
	WebElement deleteLicenceIcon;

	@FindBy(xpath = "//button[text()='Yes I‘m sure']")
	WebElement deleteLicencesYes;

	@FindBy(xpath = "//input[@placeholder='Search licences here']")
	WebElement searchLicences;

	@FindBy(xpath = "//ng-select[@formcontrolname='licenseNm']")
	WebElement drpdwn_LicenceName;

	@FindBy(xpath = "//ng-select[@formcontrolname='licenseNm']//descendant::span[@title='Clear all']")
	WebElement clearAll;

	@FindBy(xpath = "//div[text()='Enter licence name']//following::input[1]")
	WebElement enterLicence;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	List<WebElement> selectLicence;

	@FindBy(xpath = "//input[@formcontrolname='licenseRegisterNo']")
	WebElement enterLicenceNo;

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

	@FindBy(xpath = "//button[contains(text(), ' Add license ')]")
	WebElement addLicense;

	@FindBy(xpath = "//button[text()=' Update licence ']")
	WebElement updateLicense;

	@FindBy(xpath = "//a[text()='Statutory Calendar']")
	WebElement statutoryCalendar;

	// Initializing PageObjects/PageFactory/OR
	public StatutoryCalendarLicencePage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void switchToFrame() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.switchToFrame(0);
	}

	public void editLicence() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(editLicence);
	}

	public void btnAddNewLicence() {
		pageHelpers.ClickWebElement(btnAddLicence);
	}

	public void enterLicence() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(drpdwn_LicenceName);
		for (int i = 0; i < selectLicence.size(); i++) {
			logger.info(selectLicence.get(i).getText());
			pageHelpers.ClickWebElement(selectLicence.get(i));
			if (i < 1) {
				break;
			}
		}
	}

	public void updateLicence(String LicenseNm) {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(drpdwn_LicenceName);
		pageHelpers.ClickWebElement(clearAll);
		pageHelpers.SendKeysToWebElement(enterLicence, LicenseNm);
		pageHelpers.sendKeysEnter(enterLicence);
	}

	public void enterLicenceNo(String LicenceNumber) {
		pageHelpers.SendKeysToWebElement(enterLicenceNo, LicenceNumber);
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

	// File Upload-->Linux

//	public void browseFiles(String uploadDocuments) { //
//		pageHelpers.ClickWebElement(browseFiles);
//		try {
//			Uninterruptibles.sleepUninterruptibly(9, TimeUnit.SECONDS);
//			pageHelpers.StringSelection(uploadDocuments);
//			Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//			pageHelpers.RobotClassEnterClick();
//			Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
//		} catch (Exception e) {
//		}
//	}

	// File Upload -->Windows

	public void browseFiles(String uploadDocuments) {
		pageHelpers.ClickWebElement(browseFiles);
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
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

	public void clickOnAddLicenseBtn() {
		pageHelpers.clickOnUsingActions(addLicense);
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(searchLicences);
	}

	public void clickUpdateLicenseBtn() {
		pageHelpers.clickOnUsingActions(updateLicense);
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(searchLicences);
	}

	public void downloadLicense() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(downloadLicenceIcon);
		pageHelpers.ClickWebElement(selectAllLicences);
		if (downloadLicencesBtn.isEnabled()) {
			pageHelpers.ClickWebElement(downloadLicencesBtn);
			Uninterruptibles.sleepUninterruptibly(7, TimeUnit.SECONDS);
		} else {
			logger.warn("Attachments not available");
		}
	}

	public void deleteLicense() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.ClickWebElement(deleteLicenceIcon);
		if (deleteLicencesYes.isEnabled()) {
			pageHelpers.ClickWebElement(deleteLicencesYes);
		} else {
			logger.warn("Button disabled License not deleted");
		}
	}
}
