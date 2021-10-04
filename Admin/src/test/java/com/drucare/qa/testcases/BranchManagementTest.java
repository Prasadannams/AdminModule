package com.drucare.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.drucare.qa.base.TestBase;
import com.drucare.qa.pages.BranchManagement;
import com.drucare.qa.pages.HomePage;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.pages.SignInPage;
import com.drucare.qa.util.TestUtil;

public class BranchManagementTest extends TestBase {

	SignInPage signinpage;
	HomePage homePage;
	MyProfilePage myprofilepage;
	BranchManagement branchManagement;

	public BranchManagementTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		initialization();
		homePage = new HomePage(driver);
		signinpage = new SignInPage(driver);
		myprofilepage = new MyProfilePage(driver);
		branchManagement = new BranchManagement(driver);
	}

//	// Verify Branch Management screen
//
//	@Test(priority = 1)
//	public void checkBranchManagementScreen() {
//		test = extent.createTest("clickOnAddNewBranch_HO");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
//		myprofilepage.BranchManagement();
//		branchManagement.switchToFrame();
//		branchManagement.checkAddNewBranch();
//	}
//
//	// Verify Create new Button under Branch Management.
//
//	@Test(priority = 2)
//	public void clickOnAddNewBranch() {
//		test = extent.createTest("clickOnAddNewBranch_HO");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
//		myprofilepage.BranchManagement();
//		branchManagement.switchToFrame();
//		branchManagement.clickOnAddNewBranch();
//		branchManagement.CheckAddBranch_RegionlOfcPopUp();
//	}
//	// Select 'Zonal office'.
//
//	@Test(priority = 3)
//	public void CreateZonalOffice() {
//		test = extent.createTest("CreateZonalOffice_HO");
//		homePage.loginObj();
//		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
//		myprofilepage.BranchManagement();
//		branchManagement.switchToFrame();
//		branchManagement.clickOnAddNewBranch();
//		branchManagement.clickOnZonalOffice();
//		branchManagement.selectHeadOffice();
//		branchManagement.clickOnSaveAndProceed();
//	}
	
	@DataProvider
	public Object[][] getZonalOfcCreationData() {
		String sheetName = "ZonalOfcCreation";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Create Branches based on all Organization Types
	/*
	 * Hospital
	 * 
	 * Practitioner
	 * 
	 * Diagnostics
	 * 
	 * Pharmacy
	 * 
	 * School
	 * 
	 * Warehouse
	 * 
	 * Opticals
	 * 
	 * Others
	 */	

	@Test(priority = 4, groups = { "sanity" }, dataProvider = "getZonalOfcCreationData")
	public void createZonalOffice(String OrgName, String Prefix, String OrgTypeId, String HospitalType, String NoOfBeds,
			String DiagnosticType, String ContactName, String WebsiteAddress, String AddressLineOne, String LocalityNm,
			String CityNm, String DistrictNm, String StateNm, String Pincode, String CountryNm, String ContactNo,
			String ContactNoOne, String OrgEmailId, String EmpEmailId, String EmpMobileNo, String EmpUserNm,
			String GstNo, String PanNo, String CinNo, String DmHmNo, String RohiniNo) {
		test = extent.createTest("CreateZonalOffice_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.clickOnAddNewBranch();
		branchManagement.clickOnZonalOffice();
		branchManagement.selectHeadOffice();
		branchManagement.clickOnSaveAndProceed();
		branchManagement.OrgName(OrgName);
		branchManagement.Prefix(Prefix);
		branchManagement.OrgTypeId(OrgTypeId, HospitalType, NoOfBeds, DiagnosticType);
		branchManagement.ContactName(ContactName);
		branchManagement.WebsiteAddress(WebsiteAddress);
		branchManagement.AddressLineOne(AddressLineOne);
		branchManagement.LocalityNm(LocalityNm);
		branchManagement.CityNm(CityNm);
		branchManagement.DistrictNm(DistrictNm);
		branchManagement.StateNm(StateNm);
		branchManagement.Pincode(Pincode);
		branchManagement.CountryNm(CountryNm);
		branchManagement.ContactNo(ContactNoOne);
		branchManagement.ContactNoOne(ContactNoOne);
		branchManagement.OrgEmailId(OrgEmailId);
		branchManagement.EmpEmailId(EmpEmailId);
		branchManagement.EmpMobileNo(EmpMobileNo);
		branchManagement.EmpUserNm(EmpUserNm);
		branchManagement.GstNo(GstNo);
		branchManagement.PanNo(PanNo);
		branchManagement.CinNo(CinNo);
		branchManagement.DmHmNo(DmHmNo);
		branchManagement.RohiniNo(RohiniNo);
		branchManagement.clickOnAddBranch();
		branchManagement.clickOnSearchBox();
	}

	@DataProvider
	public Object[][] getZonalOfcValidationsData() {
		String sheetName = "ZonalOffice_Validations";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Validate TextBoxes under Zonal Office Org. details

	@Test(priority = 5, dataProvider = "getZonalOfcValidationsData")
	public void ValidateOrgDetails(String OrgName, String Prefix, String ContactName, String WebsiteAddress,
			String AddressLine, String LocalityName, String CityName, String DistrictName, String Pincode,
			String ContactNo, String ContactNoOne, String OrgEmailId, String EmpEmailId, String EmpMobileNo,
			String GstNo, String PanNo, String CinNo, String DmHmNo, String RohiniNo) {
		test = extent.createTest("ValidateOrgDetails_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.clickOnAddNewBranch();
		branchManagement.clickOnZonalOffice();
		branchManagement.selectHeadOffice();
		branchManagement.clickOnSaveAndProceed();
		branchManagement.validateOrgName(OrgName);
		branchManagement.validatePrefix(Prefix);
		branchManagement.validateContactNm(ContactName);
		branchManagement.validateWebsiteAddress(WebsiteAddress);
		branchManagement.validateAddressLineOne(AddressLine);
		branchManagement.validateLocalityNm(LocalityName);
		branchManagement.validateCityName(CityName);
		branchManagement.validateDistrictName(DistrictName);
		branchManagement.validatePincode(Pincode);
		branchManagement.validatecontactNo(ContactNo);
		branchManagement.validatecontactNoOne(ContactNoOne);
		branchManagement.validateOrgEmailId(OrgEmailId);
		branchManagement.validateEmpEmailId(EmpEmailId);
		branchManagement.validateEmpMobileNo(EmpMobileNo);
		branchManagement.validateGstNo(GstNo);
		branchManagement.validatePanNo(PanNo);
		branchManagement.validateCinNo(CinNo);
		branchManagement.validateDmHmNo(DmHmNo);
		branchManagement.validateRohiniNo(RohiniNo);
	}

	@DataProvider
	public Object[][] getZonalOffice_PlaceHoldersData() {
		String sheetName = "ZonalOffice_PlaceHolders";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Verify Placeholders under Zonal Office Org. details

	@Test(priority = 6)
	public void checkOrgNamePlaceholder() {
		test = extent.createTest("CheckOrgNamePlaceholder_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.clickOnAddNewBranch();
		branchManagement.clickOnZonalOffice();
		branchManagement.selectHeadOffice();
		branchManagement.clickOnSaveAndProceed();
		branchManagement.checkZonalOfficePlaceholder();
	}

	@DataProvider
	public Object[][] getZonalOfc_UpdateData() {
		String sheetName = "ZonalOfc_Update";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Verify user can Edit & Update Branch Details.

	@Test(priority = 7, groups = { "sanity" }, dataProvider = "getZonalOfc_UpdateData")
	public void updateBranch(String SearchBranch, String OrgName, String Prefix, String OrgTypeId, String HospitalType,
			String NoOfBeds, String DiagnosticType, String ContactName, String WebsiteAddress, String AddressLineOne,
			String LocalityNm, String CityNm, String DistrictNm, String StateNm, String Pincode, String CountryNm,
			String ContactNo, String ContactNoOne, String OrgEmailId, String EmpEmailId, String EmpMobileNo,
			String GstNo, String PanNo, String CinNo, String DmHmNo, String RohiniNo) {
		test = extent.createTest("UpdateBranch_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.searchBranches(SearchBranch);
		branchManagement.clickOnAnyBranch();
		branchManagement.clickOnEdit();
		branchManagement.OrgName(OrgName);
		branchManagement.Prefix(Prefix);
		branchManagement.OrgTypeId(OrgTypeId, HospitalType, NoOfBeds, DiagnosticType);
		branchManagement.ContactName(ContactName);
		branchManagement.WebsiteAddress(WebsiteAddress);
		branchManagement.AddressLineOne(AddressLineOne);
		branchManagement.LocalityNm(LocalityNm);
		branchManagement.CityNm(CityNm);
		branchManagement.DistrictNm(DistrictNm);
		branchManagement.StateNm(StateNm);
		branchManagement.Pincode(Pincode);
		branchManagement.CountryNm(CountryNm);
		branchManagement.ContactNo(ContactNoOne);
		branchManagement.ContactNoOne(ContactNoOne);
		branchManagement.OrgEmailId(OrgEmailId);
		branchManagement.EmpEmailId(EmpEmailId);
		branchManagement.EmpMobileNo(EmpMobileNo);
		branchManagement.GstNo(GstNo);
		branchManagement.PanNo(PanNo);
		branchManagement.CinNo(CinNo);
		branchManagement.DmHmNo(DmHmNo);
		branchManagement.RohiniNo(RohiniNo);
		branchManagement.updateDetails();
		branchManagement.clickOnSearchBox();
	}

	@DataProvider
	public Object[][] getSearchBranchData() {
		String sheetName = "SearchBranch";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Deactivating Branch

	@Test(priority = 8, groups = { "sanity" }, dataProvider = "getSearchBranchData")
	public void DeactivateBranch(String SearchBranch) {
		test = extent.createTest("DeactivateBranch_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.searchBranches(SearchBranch);
		branchManagement.clickOnAnyBranch();
		branchManagement.ActiveDeactiveBranch();
	}

	// Activating Branch

	@Test(priority = 9, groups = { "sanity" }, dataProvider = "getSearchBranchData")
	public void ActivateBranch(String SearchBranch) {
		test = extent.createTest("ActivateBranch_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.searchBranches(SearchBranch);
		branchManagement.clickOnAnyBranch();
		branchManagement.ActiveDeactiveBranch();
	}

	@DataProvider
	public Object[][] getHeadOfc_UpdateData() {
		String sheetName = "HeadOfc_Update";
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	// Verify user can Edit & Update Head office details

	@Test(priority = 10, groups = { "sanity" }, dataProvider = "getHeadOfc_UpdateData")
	public void updateHeadOffice(String OrgName, String Prefix, String OrgTypeId, String HospitalType, String NoOfBeds,
			String DiagnosticType, String ContactName, String WebsiteAddress, String AddressLineOne, String LocalityNm,
			String CityNm, String DistrictNm, String StateNm, String Pincode, String CountryNm, String ContactNo,
			String ContactNoOne, String OrgEmailId, String EmpEmailId, String EmpMobileNo, String GstNo, String PanNo,
			String CinNo, String DmHmNo, String RohiniNo) {
		test = extent.createTest("UpdateHeadOffice");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.EditHeadOfc();
		branchManagement.OrgName(OrgName);
		branchManagement.Prefix(Prefix);
		branchManagement.OrgTypeId(OrgTypeId, HospitalType, NoOfBeds, DiagnosticType);
		branchManagement.ContactName(ContactName);
		branchManagement.WebsiteAddress(WebsiteAddress);
		branchManagement.AddressLineOne(AddressLineOne);
		branchManagement.LocalityNm(LocalityNm);
		branchManagement.CityNm(CityNm);
		branchManagement.DistrictNm(DistrictNm);
		branchManagement.StateNm(StateNm);
		branchManagement.Pincode(Pincode);
		branchManagement.CountryNm(CountryNm);
		branchManagement.ContactNo(ContactNoOne);
		branchManagement.ContactNoOne(ContactNoOne);
		branchManagement.OrgEmailId(OrgEmailId);
		branchManagement.EmpEmailId(EmpEmailId);
		branchManagement.EmpMobileNo(EmpMobileNo);
		branchManagement.GstNo(GstNo);
		branchManagement.PanNo(PanNo);
		branchManagement.CinNo(CinNo);
		branchManagement.DmHmNo(DmHmNo);
		branchManagement.RohiniNo(RohiniNo);
		branchManagement.updateDetails();
		branchManagement.clickOnSearchBox();
	}

	// Deleting Branch

	@Test(priority = 11, dataProvider = "getSearchBranchData")
	public void DeleteBranch(String SearchBranch) {
		test = extent.createTest("DeleteBranch_HO");
		homePage.loginObj();
		signinpage.verifylogin(prop.getProperty("HOusername"), prop.getProperty("HOpassword"));
		myprofilepage.BranchManagement();
		branchManagement.switchToFrame();
		branchManagement.searchBranches(SearchBranch);
		branchManagement.clickOnAnyBranch();
		branchManagement.deleteBranch();
	}

}
