package com.drucare.qa.pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.drucare.qa.helpers.PageHelpers;
import com.google.common.util.concurrent.Uninterruptibles;

public class MyProfilePage {
	WebDriver _driver;
	PageHelpers pageHelpers = null;

	Logger logger = Logger.getLogger(MyProfilePage.class);

	@FindBy(xpath = "//div[text()='Change password']")
	WebElement changePassword;

	@FindBy(xpath = "//*[contains(@mattooltip, 'Menu')]")
	WebElement menuIcon;

	@FindBy(xpath = "//button[@class='dru-ico']")
	WebElement btn_DruIcon;

	@FindBy(xpath = "//span[@class='ico logout-feature-ico m-r-12']")
	WebElement logOut;

	// Admin module
	@FindBy(xpath = "//p[text()='Admin']")
	WebElement adminModue;

	@FindBy(xpath = "//li[contains(text(),' Branch Management ')]")
	WebElement BranchManagement;

	@FindBy(xpath = "//div[text()='Branch Management']")
	WebElement lnk_BranchManagement;

	@FindBy(xpath = "//div[contains(text(),'User Management')]")
	WebElement UserManagementLink;

	@FindBy(xpath = "//div[contains(text(), 'Role Management')]")
	WebElement roleManagementLink;

	@FindBy(xpath = "//div[contains(text(), 'User Logs')]")
	WebElement userLogsLink;

	@FindBy(xpath = "//div[contains(text(),'Statutory Calendar')]")
	WebElement statutoryCalendarLink;

	@FindBy(xpath = "//div[text()='Statutory Calendar']//following::div[text()='Settings']")
	WebElement settingsLink;

	// Appointment module
	@FindBy(xpath = "//p[text()='Appointment']")
	WebElement appointmentModule;

	@FindBy(xpath = "//p[text()='Appointment']//following::li[1]")
	WebElement appointmentLink;

	// Registration
	@FindBy(xpath = "//p[text()='Registration']")
	WebElement registrationModule;

	@FindBy(xpath = "//li[contains(text(), 'Patient Registration')]")
	WebElement PatientRegistration;

	// Billing
	@FindBy(xpath = "//p[contains(text()='Billing')]")
	WebElement billingModule;

	@FindBy(xpath = "//p[text()='EMR']")
	WebElement emrModule;

	@FindBy(xpath = "//p[text()='E-Prescription']")
	WebElement e_PrescriptionModule;

	@FindBy(xpath = "//p[text()='EMR-Ophthalmology']")
	WebElement emr_OphthalmologyModule;

	@FindBy(xpath = "//p[text()='GP EMR']")
	WebElement gpemrModule;

	@FindBy(xpath = "//p[text()='Ward']")
	WebElement wardModule;
	@FindBy(xpath = "//li[contains(text(), 'Bed Allocation')]")
	WebElement BedAllocation;

	@FindBy(xpath = "//p[text()='OT Management']")
	WebElement otManagementModule;

	@FindBy(xpath = "//p[text()='Nursing Care']")
	WebElement nursingCareModule;

	@FindBy(xpath = "//p[text()='Lab']")
	WebElement labModule;

	@FindBy(xpath = "//p[text()='Counselling']")
	WebElement counsellingModule;

	@FindBy(xpath = "//p[text()='Imaging']")
	WebElement imagingModule;

	@FindBy(xpath = "//p[text()='Communication']")
	WebElement communicationModule;

	@FindBy(xpath = "//p[text()='Pharmacy']")
	WebElement pharmacyModule;

	@FindBy(xpath = "//div[text()='Store Management']")
	WebElement storeManagement;

	@FindBy(xpath = "//div[text()='Vendor Management']")
	WebElement vendorManagement;

	@FindBy(xpath = "//div[text()='Branch Store Management']")
	WebElement BranchStoreManagement;

	@FindBy(xpath = "//div[text()='Store(OPD)']")
	WebElement StoreOPD;

	@FindBy(xpath = "//p[text()='Opticals']")
	WebElement opticalsModule;

	@FindBy(xpath = "//p[text()='MIS']")
	WebElement misModule;

	@FindBy(xpath = "//p[text()='Appointment (Beta Version)']")
	WebElement appointmentBetaModule;

	@FindBy(xpath = "//p[text()='Billing (New)']")
	WebElement billingNewModule;

	@FindBy(xpath = "//p[text()='GP EMR (Beta Version)']")
	WebElement gpemrBetaModule;
	@FindBy(xpath = "//li[contains(text(), 'Workbench')]")
	WebElement Workbench;

	@FindBy(xpath = "//p[text()='Lab (Beta Version)']")
	WebElement LabBetaModule;

	@FindBy(xpath = "//p[text()='Registration (New)']")
	WebElement registrationNewModule;

	@FindBy(xpath = "//p[text()='Vascular Registry']")
	WebElement vascularRegistryModule;

	@FindBy(xpath = "//p[text()='Reports']")
	WebElement reportsModule;

	@FindBy(xpath = "//li[contains(text(), 'Reports-Beta')]")
	WebElement reports_Beta;

	// Initializing PageObjects/PageFactory/OR
	public MyProfilePage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void verifyMyHomepgTitle() {
		pageHelpers.getPageTitleByJavaScript(_driver);
	}

	public void clickOnMenuIcon() {
		pageHelpers.ClickWebElement(menuIcon);
	}

	public void LogOut() {
		_driver.switchTo().defaultContent();
		pageHelpers.ClickWebElement(btn_DruIcon);
		pageHelpers.ClickWebElement(logOut);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void BranchManagement() {
		try {
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.JsClick(lnk_BranchManagement);
		} catch (Exception e) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.JsClick(lnk_BranchManagement);
		}
	}

	public void UserManagement() {
		try {
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.JsClick(UserManagementLink);
		} catch (Exception e) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.JsClick(UserManagementLink);
		}
	}

	public void RoleManagement() {
		try {
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(roleManagementLink);
		} catch (Exception e) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(roleManagementLink);
		}
	}

	public void UserLogs() {
		try {
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(userLogsLink);
		} catch (Exception e) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(userLogsLink);
		}
	}

	public void StatutoryCalendar() {
		try {
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(statutoryCalendarLink);
		} catch (Exception e) {
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
			pageHelpers.ClickWebElement(menuIcon);
			pageHelpers.ClickWebElement(adminModue);
			pageHelpers.ClickWebElement(statutoryCalendarLink);
		}
	}

	public void clickOnSettings() {
		pageHelpers.ClickWebElement(settingsLink);
	}

}
