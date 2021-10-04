package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.pages.StatutoryCalendarAgreementsPage;
import com.drucare.qa.util.TestUtil;

public class StatutoryCalendarAgreementsTest extends TestBase {

	HomePage homePage;
	SignInPage signinpage;
	MyProfilePage myprofilepage;
	StatutoryCalendarAgreementsPage sca;

	public StatutoryCalendarAgreementsTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		sca = new StatutoryCalendarAgreementsPage(driver);
	}

	// Creating New Agreement
	@DataProvider
	public Object[][] getAgreementTestData() {
		String sheetName = "CreateNewAgreement";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(groups = {
			"sanity" }, priority = 1, description = "Creating New Agreement", dataProvider = "getAgreementTestData")
	public void createNewAgreementTest(String AgreementName, String AgreementNumber, String monthOfIssue,
			String monthOfExpiry, String SetExpiryReminderInDays, String Remarks, String uploadDocuments, String Name,
			String Email, String MobileNumber, String Website, String Address, String City, String District,
			String State, String Pincode, String Country) {
		test = extent.createTest("CreateNewAgreement_StatutoryCalendarAgreements");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		sca.switchToFrame();
		sca.ClickOnAgreementsTab();
		sca.btnAddNewAgreement();
		sca.enterAgreement(AgreementName);
		sca.enterAgreementNo(AgreementNumber);
		sca.dateOfIssue(monthOfIssue);
		sca.dateOfExpiry(monthOfExpiry);
		sca.remindDays(SetExpiryReminderInDays);
		sca.remarks(Remarks);
		sca.browseFiles(uploadDocuments);
		sca.IssuingAuthority(Name, Email, MobileNumber, Website, Address, City, District, State, Pincode, Country);
		sca.clickAddAgreementBtn();
	}

	// Edit Agreement
	@DataProvider
	public Object[][] getAgreementEditTestData() {
		String sheetName = "EditAgreement";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(groups = {
			"sanity" }, priority = 2, description = "Edit Agreement", dataProvider = "getAgreementEditTestData")
	public void editAgreementTest(String AgreementName, String AgreementNumber, String monthOfIssue,
			String monthOfExpiry, String SetExpiryReminderInDays, String Remarks, String uploadDocuments, String Name,
			String Email, String MobileNumber, String Website, String Address, String City, String District,
			String State, String Pincode, String Country) {
		test = extent.createTest("EditAgreementTest_StatutoryCalendarAgreements");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		sca.switchToFrame();
		sca.ClickOnAgreementsTab();
		sca.editAgreement();
		sca.enterAgreement(AgreementName);
		sca.enterAgreementNo(AgreementNumber);
		sca.dateOfIssue(monthOfIssue);
		sca.dateOfExpiry(monthOfExpiry);
		sca.remindDays(SetExpiryReminderInDays);
		sca.remarks(Remarks);
		sca.browseFiles(uploadDocuments);
		sca.IssuingAuthority(Name, Email, MobileNumber, Website, Address, City, District, State, Pincode, Country);
		sca.clickUpdateAgreementBtn();
	}

	@Test(priority = 3, description = "Download Agreement")
	public void downloadAgreementTest() {
		test = extent.createTest("DownloadAgreement_StatutoryCalendarAgreements");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		sca.switchToFrame();
		sca.ClickOnAgreementsTab();
		sca.downloadAgreement();
	}

	@Test(priority = 4, description = "Delete Agreement")
	public void deleteAgreementTest() {
		test = extent.createTest("DeleteAgreement_StatutoryCalendarAgreements");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.StatutoryCalendar();
		sca.switchToFrame();
		sca.ClickOnAgreementsTab();
		sca.deleteAgreement();
	}
}
