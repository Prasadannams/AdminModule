package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.pages.StatutoryCalendarLicencePage;
import com.drucare.qa.util.TestUtil;

public class StatutoryCalendarLicenceTest extends TestBase {

	HomePage homePage;
	SignInPage signinpage;
	MyProfilePage myprofilepage;
	StatutoryCalendarLicencePage scl;

	public StatutoryCalendarLicenceTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		scl = new StatutoryCalendarLicencePage(driver);
	}

	@DataProvider
	public Object[][] getLicenceTestData() {
		String sheetName = "CreateNewLicence";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Creating New Licence
	@Test(groups = {
			"sanity" }, priority = 1, description = "Creating New Licence", dataProvider = "getLicenceTestData")
	public void createNewLicenceTest(String LicenceNumber, String monthOfIssue, String monthOfExpiry,
			String SetExpiryReminderInDays, String Remarks, String uploadDocuments, String Name, String Email,
			String MobileNumber, String Website, String Address, String City, String District, String State,
			String Pincode, String Country) {
		test = extent.createTest("CreateNewLicence_StatutoryCalendarLicence");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		scl.switchToFrame();
		scl.btnAddNewLicence();
		scl.enterLicence();
		scl.enterLicenceNo(LicenceNumber);
		scl.dateOfIssue(monthOfIssue);
		scl.dateOfExpiry(monthOfExpiry);
		scl.remindDays(SetExpiryReminderInDays);
		scl.remarks(Remarks);
		scl.browseFiles(uploadDocuments);
		scl.IssuingAuthority(Name, Email, MobileNumber, Website, Address, City, District, State, Pincode, Country);
		scl.clickOnAddLicenseBtn();
	}

	// Licence Update
	@DataProvider
	public Object[][] getLicenceEditTestData() {
		String sheetName = "UpdateLicense";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(groups = { "sanity" }, priority = 2, description = "UpdateLicence", dataProvider = "getLicenceEditTestData")
	public void licenceUpdateTest(String LicenseNm, String LicenceNumber, String monthOfIssue, String monthOfExpiry,
			String SetExpiryReminderInDays, String Remarks, String uploadDocuments, String Name, String Email,
			String MobileNumber, String Website, String Address, String City, String District, String State,
			String Pincode, String Country) {
		test = extent.createTest("LicenceUpdate_StatutoryCalendarLicence");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		scl.switchToFrame();
		scl.editLicence();
		scl.updateLicence(LicenseNm);
		scl.enterLicenceNo(LicenceNumber);
		scl.dateOfIssue(monthOfIssue);
		scl.dateOfExpiry(monthOfExpiry);
		scl.remindDays(SetExpiryReminderInDays);
		scl.remarks(Remarks);
		scl.browseFiles(uploadDocuments);
		scl.IssuingAuthority(Name, Email, MobileNumber, Website, Address, City, District, State, Pincode, Country);
		scl.clickUpdateLicenseBtn();
	}

	@Test(priority = 3, description = "Download License")
	public void downloadLicenseTest() {
		test = extent.createTest("DownloadLicense_StatutoryCalendarLicence");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		scl.switchToFrame();
		scl.downloadLicense();
	}

	@Test(priority = 4, description = "Delete License")
	public void deleteLicenseTest() {
		test = extent.createTest("DeleteLicense_StatutoryCalendarLicence");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		scl.switchToFrame();
		scl.deleteLicense();
	}
}
