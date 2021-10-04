package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.RoleManagementPage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.util.TestUtil;

public class RoleManagementPageTest extends TestBase {
	SignInPage signinpage;
	HomePage homePage;
	MyProfilePage myprofilepage;
	RoleManagementPage rm;
	TestUtil testUtil;

	public RoleManagementPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		rm = new RoleManagementPage(driver);
	}

	@DataProvider
	public Object[][] getRoleTestData() {
		String sheetName = "CreateRole";
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	// Create Role.
	@Test(groups = { "sanity" }, priority = 1, description = "Creating Roles", dataProvider = "getRoleTestData")
	public void createRoleTest(String roleName, String tagName, String description) {
		test = extent.createTest("CreateRole_RoleManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.RoleManagement();
		rm.switchToFrame();
		rm.clickOnAddnewrole();
		rm.checkCreateRoleHeader();
		rm.RoleDetails(roleName, tagName, description);
		rm.selectServices();
		rm.ProceedBtn();
		rm.selectAllScreens();
		rm.clickCreateRole();
	}

	// Updating Role.

	@DataProvider
	public Object[][] getRoleTestDataforUpdate() {
		String sheetName = "UpdateRole";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(groups = {
			"sanity" }, priority = 2, description = "Updating Role", dependsOnMethods = "createRoleTest", dataProvider = "getRoleTestDataforUpdate")
	public void editRole(String SearchRole, String roleName, String tagName, String description) {
		test = extent.createTest("EditRole_RoleManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.RoleManagement();
		rm.switchToFrame();
		rm.SearchRole(SearchRole);
		rm.selectSearchedRole();
		rm.clickOnEdit();
		rm.editRoleDetails();
		rm.removeExistingTag();
		rm.RoleDetails(roleName, tagName, description);
		rm.updateRoleDetails();
		rm.selectAllScreens();
		rm.clickCreateRole();
	}

	@DataProvider
	public Object[][] getSearchRoleData() {
		String sheetName = "SearchRole";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Deactivate Role.
	@Test(priority = 3, description = "Deactivate Role", dependsOnMethods = "createRoleTest", dataProvider = "getSearchRoleData")
	public void DeactivateRole(String SearchRole) {
		test = extent.createTest("DeactivateRole_RoleManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.RoleManagement();
		rm.switchToFrame();
		rm.SearchRole(SearchRole);
		rm.selectSearchedRole();
		rm.DeactiveRole();
	}

	// Activate Role.
	@Test(priority = 4, dependsOnMethods = "DeactivateRole", dataProvider = "getSearchRoleData")
	public void ActivateRole(String SearchRole) {
		test = extent.createTest("ActivateRole_RoleManagement");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		myprofilepage.RoleManagement();
		rm.switchToFrame();
		rm.SearchRole(SearchRole);
		rm.ActivateRole();
	}
}
