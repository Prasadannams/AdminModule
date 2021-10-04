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

public class BranchManagement {

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	Logger logger = Logger.getLogger(BranchManagement.class);

	// Xpath for 'Add new branch' when any Branch is created.
	@FindBy(xpath = "//button[text()='Add new branch']")
	WebElement btn_AddNewBranch;

	@FindBy(xpath = "//div[@class='menu-radio-group']//label[3]")
	WebElement ZonalOffice;

	@FindBy(xpath = "//label[@for='head-office']")
	WebElement rdoBtn_Head_Office;

	@FindBy(xpath = "//button[text()='Save and proceed']")
	WebElement btn_SaveAndProceed;

	@FindBy(xpath = "//h1[text()='Add branch/ Regional office']")
	WebElement popUp_AddBrnchRegionlOfc;

	@FindBy(xpath = "//input[@placeholder='Organisation name']")
	WebElement txtBx_OrgName;

	@FindBy(xpath = "//input[@placeholder='Organisation prefix']")
	WebElement txtBx_Prefix;

	@FindBy(xpath = "//ng-select[@formcontrolname='orgTypeId']")
	WebElement drpdwn_orgTypeId;

	@FindBy(xpath = "//ng-select[@formcontrolname='orgTypeId']//input[1]")
	WebElement txtBx_orgTypeId;

	@FindBy(xpath = "//ng-select[@formcontrolname='orgTypeId']//descendant::input[contains(@aria-activedescendant, 'a')]")
	WebElement OrgTypeIdEntered;

	@FindBy(xpath = "//label[text()='Single speciality']")
	WebElement rdoBtn_SingleSpeciality;

	@FindBy(xpath = "//label[text()='Multi speciality']")
	WebElement rdoBtn_MultiSpeciality;

	@FindBy(xpath = "//input[@formcontrolname='noOfBeds']")
	WebElement txtBx_NoOfBeds;

	@FindBy(xpath = "//label[text()='Laboratory']")
	WebElement rdoBtn_Laboratory;

	@FindBy(xpath = "//label[text()='Radiology']")
	WebElement rdoBtn_Radiology;

	@FindBy(xpath = "//label[text()='Both']")
	WebElement rdoBtn_Both;

	@FindBy(xpath = "//input[@formcontrolname='contactNm']")
	WebElement txtBx_contactNm;

	@FindBy(xpath = "//input[@formcontrolname='websiteAddress']")
	WebElement txtBx_WebsiteAddress;

	@FindBy(xpath = "//input[@formcontrolname='addressLine1']")
	WebElement txtBx_addressLineOne;

	@FindBy(xpath = "//input[@formcontrolname='localityNm']")
	WebElement txtBx_localityNm;

	@FindBy(xpath = "//input[@formcontrolname='cityNm']")
	WebElement txtBx_cityNm;

	@FindBy(xpath = "//input[@formcontrolname='districtNm']")
	WebElement txtBx_districtNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='stateNm']")
	WebElement drpdwn_stateNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='stateNm']//input[1]")
	WebElement txtBx_stateNm;

	@FindBy(xpath = "//ng-select[@formcontrolname='stateNm']//descendant::input[contains(@aria-activedescendant, 'a')]")
	WebElement StateNmEntered;

	@FindBy(xpath = "//input[@formcontrolname='pincode']")
	WebElement txtBx_pincode;

	@FindBy(xpath = "//select[@formcontrolname='countryNm']")
	WebElement drpdwn_countryNm;

	@FindBy(xpath = "//input[@formcontrolname='contactNo']")
	WebElement txtBx_contactNo;

	@FindBy(xpath = "//input[@formcontrolname='contactNo1']")
	WebElement txtBx_contactNoOne;

	@FindBy(xpath = "//input[@formcontrolname='orgEmailId']")
	WebElement txtBx_orgEmailId;

	@FindBy(xpath = "//input[@formcontrolname='empEmailId']")
	WebElement txtBx_empEmailId;

	@FindBy(xpath = "//input[@formcontrolname='empMobileNo']")
	WebElement txtBx_empMobileNo;

	@FindBy(xpath = "//input[@formcontrolname='empUserNm']")
	WebElement txtBx_empUserNm;

	@FindBy(xpath = "//input[@formcontrolname='gstNo']")
	WebElement txtBx_gstNo;

	@FindBy(xpath = "//input[@formcontrolname='panNo']")
	WebElement txtBx_panNo;

	@FindBy(xpath = "//input[@formcontrolname='cinNo']")
	WebElement txtBx_cinNo;

	@FindBy(xpath = "//input[@formcontrolname='dmHmNo']")
	WebElement txtBx_dmHmNo;

	@FindBy(xpath = "//input[@formcontrolname='rohiniNo']")
	WebElement txtBx_rohiniNo;

	@FindBy(xpath = "//button[text()='Add branch']")
	WebElement btn_AddBranch;

	@FindBy(xpath = "//span[text()='Delete']")
	WebElement delete;

	@FindBy(xpath = "//h3[text()='Regional Offices & branches']//following::input[1]")
	WebElement txtBox_Search;

	@FindBy(xpath = "//div[@class='d-flex justify-content-between align-items-center title-padding']")
	List<WebElement> selectBranches;

	@FindBy(xpath = "//span[text()='Edit']")
	WebElement Edit;

	@FindBy(xpath = "//span[@class='slider round']")
	WebElement ActiveDeactiveBrnch;

	@FindBy(xpath = "//button[text()='Yes I‘m sure']")
	WebElement popUp_YesImSure;

	@FindBy(xpath = "//span[text()='Delete']")
	WebElement deleteBranch;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement btn_Update;

	@FindBy(xpath = "//button[text()=' Edit ']")
	WebElement btn_EditHeadOfc;

	// Initializing PageObjects/PageFactory/OR
	public BranchManagement(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void switchToFrame() {
		pageHelpers.switchToFrame(0);
	}

	public void checkAddNewBranch() {
		pageHelpers.highlightElementByJavaScript(btn_AddNewBranch, _driver);
	}

	public void clickOnAddNewBranch() {
		pageHelpers.ClickWebElement(btn_AddNewBranch);
	}

	public void CheckAddBranch_RegionlOfcPopUp() {
		pageHelpers.highlightElementByJavaScript(popUp_AddBrnchRegionlOfc, _driver);
	}

	public void clickOnZonalOffice() {
		pageHelpers.ClickWebElement(ZonalOffice);
	}

	public void selectHeadOffice() {
		pageHelpers.ClickWebElement(rdoBtn_Head_Office);
	}

	public void clickOnSaveAndProceed() {
		pageHelpers.ClickWebElement(btn_SaveAndProceed);
	}

	public void validateOrgName(String OrgName) {
		pageHelpers.SendKeysToWebElement(txtBx_OrgName, OrgName);
	}

	public void validatePrefix(String Prefix) {
		pageHelpers.SendKeysToWebElement(txtBx_Prefix, Prefix);
	}

	public void validateContactNm(String ContactName) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNm, ContactName);
	}

	public void validateWebsiteAddress(String WebsiteAddress) {
		pageHelpers.SendKeysToWebElement(txtBx_WebsiteAddress, WebsiteAddress);
	}

	public void validateAddressLineOne(String AddressLine) {
		pageHelpers.SendKeysToWebElement(txtBx_addressLineOne, AddressLine);
	}

	public void validateLocalityNm(String LocalityName) {
		pageHelpers.SendKeysToWebElement(txtBx_localityNm, LocalityName);
	}

	public void validateCityName(String CityName) {
		pageHelpers.SendKeysToWebElement(txtBx_cityNm, CityName);
	}

	public void validateDistrictName(String DistrictName) {
		pageHelpers.SendKeysToWebElement(txtBx_districtNm, DistrictName);
	}

	public void validatePincode(String Pincode) {
		pageHelpers.SendKeysToWebElement(txtBx_pincode, Pincode);
	}

	public void validatecontactNo(String ContactNo) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNo, ContactNo);
	}

	public void validatecontactNoOne(String ContactNoOne) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNoOne, ContactNoOne);
	}

	public void validateOrgEmailId(String OrgEmailId) {
		pageHelpers.SendKeysToWebElement(txtBx_orgEmailId, OrgEmailId);
	}

	public void validateEmpEmailId(String EmpEmailId) {
		pageHelpers.SendKeysToWebElement(txtBx_empEmailId, EmpEmailId);
	}

	public void validateEmpMobileNo(String EmpMobileNo) {
		pageHelpers.SendKeysToWebElement(txtBx_empMobileNo, EmpMobileNo);
	}

	public void validateGstNo(String GstNo) {
		pageHelpers.SendKeysToWebElement(txtBx_gstNo, GstNo);
	}

	public void validatePanNo(String PanNo) {
		pageHelpers.SendKeysToWebElement(txtBx_panNo, PanNo);
	}

	public void validateCinNo(String CinNo) {
		pageHelpers.SendKeysToWebElement(txtBx_cinNo, CinNo);
	}

	public void validateDmHmNo(String DmHmNo) {
		pageHelpers.SendKeysToWebElement(txtBx_dmHmNo, DmHmNo);
	}

	public void validateRohiniNo(String RohiniNo) {
		pageHelpers.SendKeysToWebElement(txtBx_rohiniNo, RohiniNo);
	}

	public void checkZonalOfficePlaceholder() {
		pageHelpers.getPlaceholder(txtBx_OrgName, "placeholder", "Organisation name");
		pageHelpers.getPlaceholder(txtBx_Prefix, "placeholder", "Organisation prefix");
		pageHelpers.getPlaceholder(txtBx_contactNm, "placeholder", "eg: Jhone");
		pageHelpers.getPlaceholder(txtBx_WebsiteAddress, "placeholder", "eg: drucare.com");
		pageHelpers.getPlaceholder(txtBx_addressLineOne, "placeholder", "eg: Plot 134");
		pageHelpers.getPlaceholder(txtBx_localityNm, "placeholder", "Locality");
		pageHelpers.getPlaceholder(txtBx_cityNm, "placeholder", "eg: Hyderabad");
		pageHelpers.getPlaceholder(txtBx_districtNm, "placeholder", "eg: RR District");
		pageHelpers.getPlaceholder(txtBx_pincode, "placeholder", "Pincode");
		pageHelpers.getPlaceholder(txtBx_contactNo, "placeholder", "eg: 1234567890");
		pageHelpers.getPlaceholder(txtBx_contactNoOne, "placeholder", "eg: 1234567890");
		pageHelpers.getPlaceholder(txtBx_orgEmailId, "placeholder", "abc@gmail.com");
		pageHelpers.getPlaceholder(txtBx_empEmailId, "placeholder", "eg: Admin1234@gmail.com");
		pageHelpers.getPlaceholder(txtBx_empMobileNo, "placeholder", "eg: 1234567890");
		pageHelpers.getPlaceholder(txtBx_empUserNm, "placeholder", "eg: SuperAdmin1234");
		pageHelpers.getPlaceholder(txtBx_panNo, "placeholder", "eg:ABCDE1234F");
		pageHelpers.getPlaceholder(txtBx_cinNo, "placeholder", "eg: 123456789");
		pageHelpers.getPlaceholder(txtBx_dmHmNo, "placeholder", "eg: 123456789");
		pageHelpers.getPlaceholder(txtBx_rohiniNo, "placeholder", "Rohini number");
	}

	public void OrgName(String OrgName) {
		pageHelpers.SendKeysToWebElement(txtBx_OrgName, OrgName);
	}

	public void Prefix(String Prefix) {
		pageHelpers.SendKeysToWebElement(txtBx_Prefix, Prefix);
	}

	public void OrgTypeId(String OrgTypeId, String HospitalType, String NoOfBeds, String DiagnosticType) {
		pageHelpers.ClickWebElement(drpdwn_orgTypeId);
		pageHelpers.SendKeysToWebElement(txtBx_orgTypeId, OrgTypeId);
		pageHelpers.AssertTrue(OrgTypeIdEntered);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		pageHelpers.EnterUsingActions();
		if (OrgTypeId.equalsIgnoreCase("Hospital")) {
			if (HospitalType.equalsIgnoreCase("Single speciality")) {
				pageHelpers.ClickWebElement(rdoBtn_SingleSpeciality);
				pageHelpers.SendKeysToWebElement(txtBx_NoOfBeds, NoOfBeds);
			} else {
				pageHelpers.ClickWebElement(rdoBtn_MultiSpeciality);
				pageHelpers.SendKeysToWebElement(txtBx_NoOfBeds, NoOfBeds);
			}
		} else if (OrgTypeId.equalsIgnoreCase("Practitioner")) {
			pageHelpers.SendKeysToWebElement(txtBx_NoOfBeds, NoOfBeds);
		} else if (OrgTypeId.equalsIgnoreCase("Diagnostics")) {
			if (DiagnosticType.equalsIgnoreCase("Laboratory")) {
				pageHelpers.ClickWebElement(rdoBtn_Laboratory);
			} else if (DiagnosticType.equalsIgnoreCase("Radiology")) {
				pageHelpers.ClickWebElement(rdoBtn_Radiology);
			} else {
				pageHelpers.ClickWebElement(rdoBtn_Both);
			}
		} else {
			logger.info("**********************************");
		}

	}

	public void ContactName(String ContactName) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNm, ContactName);
	}

	public void WebsiteAddress(String WebsiteAddress) {
		pageHelpers.SendKeysToWebElement(txtBx_WebsiteAddress, WebsiteAddress);
	}

	public void AddressLineOne(String AddressLineOne) {
		pageHelpers.SendKeysToWebElement(txtBx_addressLineOne, AddressLineOne);
	}

	public void LocalityNm(String LocalityNm) {
		pageHelpers.SendKeysToWebElement(txtBx_localityNm, LocalityNm);
	}

	public void CityNm(String CityNm) {
		pageHelpers.SendKeysToWebElement(txtBx_cityNm, CityNm);
	}

	public void DistrictNm(String DistrictNm) {
		pageHelpers.SendKeysToWebElement(txtBx_districtNm, DistrictNm);
	}

	public void StateNm(String StateNm) {
		pageHelpers.ClickWebElement(drpdwn_stateNm);
		pageHelpers.SendKeysToWebElement(txtBx_stateNm, StateNm);
		pageHelpers.AssertTrue(StateNmEntered);
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		pageHelpers.EnterUsingActions();
	}

	public void Pincode(String Pincode) {
		pageHelpers.SendKeysToWebElement(txtBx_pincode, Pincode);
	}

	public void CountryNm(String CountryNm) {
		pageHelpers.staticDropDownByVisibleText(drpdwn_countryNm, CountryNm);
	}

	public void ContactNo(String ContactNo) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNo, ContactNo);
	}

	public void ContactNoOne(String ContactNoOne) {
		pageHelpers.SendKeysToWebElement(txtBx_contactNoOne, ContactNoOne);
	}

	public void OrgEmailId(String OrgEmailId) {
		pageHelpers.SendKeysToWebElement(txtBx_orgEmailId, OrgEmailId);
	}

	public void EmpEmailId(String EmpEmailId) {
		pageHelpers.SendKeysToWebElement(txtBx_empEmailId, EmpEmailId);
	}

	public void EmpMobileNo(String EmpMobileNo) {
		pageHelpers.SendKeysToWebElement(txtBx_empMobileNo, EmpMobileNo);
	}

	public void EmpUserNm(String EmpUserNm) {
		pageHelpers.SendKeysToWebElement(txtBx_empUserNm, EmpUserNm);
	}

	public void GstNo(String GstNo) {
		pageHelpers.SendKeysToWebElement(txtBx_gstNo, GstNo);
	}

	public void PanNo(String PanNo) {
		pageHelpers.SendKeysToWebElement(txtBx_panNo, PanNo);
	}

	public void CinNo(String CinNo) {
		pageHelpers.SendKeysToWebElement(txtBx_cinNo, CinNo);
	}

	public void DmHmNo(String DmHmNo) {
		pageHelpers.SendKeysToWebElement(txtBx_dmHmNo, DmHmNo);
	}

	public void RohiniNo(String RohiniNo) {
		pageHelpers.SendKeysToWebElement(txtBx_rohiniNo, RohiniNo);
	}

	public void clickOnAddBranch() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.JsClick(btn_AddBranch);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void clickOnSearchBox() {
		pageHelpers.ClickWebElementTryCatch(txtBox_Search);
	}

	public void searchBranches(String SearchBranch) {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.sendKeysToJavaScript(txtBox_Search, _driver, SearchBranch);
		// pageHelpers.SendKeysToWebElement(txtBox_Search, SearchBranch);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void clickOnAnyBranch() {
		pageHelpers.breakListOfWebElements(selectBranches);
		Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
	}

	public void clickOnEdit() {
		pageHelpers.scrollIntoElementByJavaScript(Edit, _driver);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.JsClick(Edit);
	}

	public void ActiveDeactiveBranch() {
		pageHelpers.scrollIntoElementByJavaScript(ActiveDeactiveBrnch, _driver);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.JsClick(ActiveDeactiveBrnch);
		pageHelpers.JsClick(popUp_YesImSure);
	}

	public void deleteBranch() {
		pageHelpers.scrollIntoElementByJavaScript(deleteBranch, _driver);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.JsClick(deleteBranch);
		pageHelpers.JsClick(popUp_YesImSure);
	}

	public void updateDetails() {
		pageHelpers.JsClick(btn_Update);
	}

	public void EditHeadOfc() {
		pageHelpers.JsClick(btn_EditHeadOfc);
	}

}
