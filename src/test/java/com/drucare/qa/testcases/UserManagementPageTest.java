package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.pages.UserManagementPage;
import com.drucare.qa.util.TestUtil;

public class UserManagementPageTest extends TestBase {

	SignInPage signinpage;
	HomePage homePage;
	MyProfilePage myprofilepage;
	UserManagementPage usermanagementpage;

	public UserManagementPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		usermanagementpage = new UserManagementPage(driver);
	}

//	// Verify User management screen
//
//	@Test(priority = 0, description = "Check User Management screen")
//	public void checkUserManagementScreen() {
//		test = extent.createTest("UserManagementScreen_UserManagement");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
//		myprofilepage.UserManagement();
//		usermanagementpage.switchToFrame();
//		usermanagementpage.CheckUserManagementScreen();
//	}
//
//	// Verify 'Add new user' details by clicking 'Add new user'.
//
//	@Test(groups = { "sanity" }, priority = 1, description = "Check Add new user details")
//	public void ClickAddNewUser() {
//		test = extent.createTest("ClickAddNewUser_UserManagement");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
//		myprofilepage.UserManagement();
//		usermanagementpage.switchToFrame();
//		usermanagementpage.clickOnAddNewUser();
//	}

	@DataProvider
	public Object[][] getUserTestData() {
		String sheetName = "UserManagement";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Create User under User Management
	@Test(groups = { "sanity" }, priority = 2, description = "Creating Users", dataProvider = "getUserTestData")
	public void createNewUserTest(String title, String firstName, String lastName, String gender, String email,
			String mobile, String doctorType, String qualification, String yearsOfExperience, String empCode,
			String userName, String MCINumber, String feeValidDays, String feeValidVisits) {
		test = extent.createTest("CreateNewUserTest_UserManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserManagement();
		usermanagementpage.switchToFrame();
		usermanagementpage.clickOnAddNewUser();
		usermanagementpage.personalDetails(title, firstName, lastName, gender, email, mobile);
		usermanagementpage.professionalDetails(doctorType, qualification, yearsOfExperience, empCode, userName,
				MCINumber, feeValidDays, feeValidVisits);
		usermanagementpage.addRole();
		usermanagementpage.saveBtn();
	}

	@DataProvider
	public Object[][] getUserMangmnt_ValidationData() {
		String sheetName = "UserMangmnt_Validation";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Validate 'Add new user' details

	@Test(groups = { "sanity" }, priority = 3, dataProvider = "getUserMangmnt_ValidationData")
	public void validateAddNewUserDetails(String firstName, String lastName, String email, String mobile,
			String empCode, String userName) {
		test = extent.createTest("ValidateAddNewUserDetails_UserManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserManagement();
		usermanagementpage.switchToFrame();
		usermanagementpage.clickOnAddNewUser();
		usermanagementpage.validateAddNewUserDetails(firstName, lastName, email, mobile, empCode, userName);
	}

	@DataProvider
	public Object[][] getDruCareUserUpdateData() {
		String sheetName = "UpdateUser";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Update User under User Management

	@Test(groups = {
			"sanity" }, priority = 4, description = "Updating User", dependsOnMethods = "createNewUserTest", dataProvider = "getDruCareUserUpdateData")
	public void updateUserTest(String searchUser, String title, String firstName, String lastName, String gender,
			String email, String mobile) {
		test = extent.createTest("UpdateUser_UserManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserManagement();
		usermanagementpage.switchToFrame();
		usermanagementpage.searchUsers(searchUser);
		usermanagementpage.selectSearchedUser();
		usermanagementpage.clickOnEdit();
		usermanagementpage.checkUpdateUserHeader();
		usermanagementpage.personalDetails(title, firstName, lastName, gender, email, mobile);
		usermanagementpage.addRole();
		usermanagementpage.updateBtn();
		usermanagementpage.SearchBar();
	}

	@DataProvider
	public Object[][] getSearchUserData() {
		String sheetName = "SearchUser";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Deactivate User under User Management
	@Test(priority = 5, description = "Deactivate User", dependsOnMethods = "createNewUserTest", dataProvider = "getSearchUserData")
	public void DeactivateUser(String searchUser) {
		test = extent.createTest("DeactivateUser_UserManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserManagement();
		usermanagementpage.switchToFrame();
		usermanagementpage.searchUsers(searchUser);
		usermanagementpage.selectSearchedUser();
		usermanagementpage.DeactiveUser();
	}

	// Activate User under User Management

	@Test(priority = 6, dependsOnMethods = "DeactivateUser", dataProvider = "getSearchUserData")
	public void ActivateUser(String searchUser) {
		test = extent.createTest("ActivateUser_UserManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.UserManagement();
		usermanagementpage.switchToFrame();
		usermanagementpage.searchUsers(searchUser);
		usermanagementpage.ActivateUser();
	}

//	@DataProvider
//	public Object[][] getFilterBy_UserMangmntData() {
//		String sheetName = "FilterBy_UserMangmnt";
//		Object[][] data = TestUtil.getTestData(sheetName);
//		return data;
//	}
//
//	// Check FilterBy drop down under User Management
//	@Test(priority = 7, dataProvider = "getFilterBy_UserMangmntData")
//	public void filterBy(String FilterBy) {
//		test = extent.createTest("FilterByFunctionality_UserManagement");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
//		myprofilepage.UserManagement();
//		usermanagementpage.switchToFrame();
//		usermanagementpage.drpdwn_filterBy(FilterBy);
//	}

//	@DataProvider
//	public Object[][] getSortBy_UserMangmntData() {
//		String sheetName = "SortBy_UserMangmnt";
//		Object[][] data = TestUtil.getTestData(sheetName);
//		return data;
//	}
//
//	// Check SortBy drop down under User Management
//
//	@Test(priority = 8, dataProvider = "getSortBy_UserMangmntData")
//	public void SortBy(String SortBy) {
//		test = extent.createTest("SortByFunctionality_UserManagement");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
//		myprofilepage.UserManagement();
//		usermanagementpage.switchToFrame();
//		usermanagementpage.drpdwn_sortBy(SortBy);
//
//	}
}
