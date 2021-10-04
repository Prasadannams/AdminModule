package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.pages.UserLogsPage;
import com.drucare.qa.util.TestUtil;

public class UserLogsPageTest extends TestBase {

	SignInPage signinpage;
	HomePage homePage;
	MyProfilePage myprofilepage;
	UserLogsPage userlogspage;

	public UserLogsPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		userlogspage = new UserLogsPage(driver);
	}

	@DataProvider
	public Object[][] getUserLogsData() {
		String sheetName = "UserLogs";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Search any user & check UserLogs.
	@Test(groups = { "sanity" }, priority = 1, dataProvider = "getUserLogsData")
	public void UserLogs(String SearchUsers, String Month) {
		test = extent.createTest("UserLogs");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserLogs();
		userlogspage.switchToFrame();
		userlogspage.UserLogs(SearchUsers, Month);

	}
}
