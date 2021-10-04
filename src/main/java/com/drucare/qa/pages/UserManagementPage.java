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

public class UserManagementPage {

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	Logger logger = Logger.getLogger(UserManagementPage.class);

	@FindBy(xpath = "//a[contains(text(),'User Management')]")
	WebElement userManagement;

	@FindBy(xpath = "//h2[text()='User management']")
	WebElement UserManagementScreen;

	@FindBy(xpath = "//p[contains(text(), 'username should be alphanumerics and lower case letters')]")
	WebElement errorMsg;

	@FindBy(xpath = "//button[contains(text(), 'Add new user')]")
	WebElement Addnewuser;

	@FindBy(xpath = "//span[@class='slider round']")
	WebElement Deactive_User;

	@FindBy(xpath = "//label[text()='Inactive']//following::span[1]")
	WebElement ActiveUser;

	@FindBy(xpath = "//button[text()='Yes I‘m sure']")
	WebElement btn_YesImSure;

	@FindBy(xpath = "//p[contains(text(),'has been deactivated & moved to inactive list')]")
	WebElement toast_Deactivated;

	@FindBy(xpath = "//p[contains(text(),'has been activated & moved to active list')]")
	WebElement toast_Activated;

	@FindBy(xpath = "//select[@id='filterBy']")
	WebElement drpdwn_FilterBy;

	@FindBy(xpath = "//select[@id='sortBy']")
	WebElement drpdwn_sortBy;

	@FindBy(xpath = "//div[@class='row p-t-8 p-b-8']")
	List<WebElement> inactiveUsers;

	/*
	 * @FindBy(xpath = "//span[contains(@class,'ico edit-icon')]") WebElement Edit;
	 */

	@FindBy(xpath = "//span[contains(text(), 'Edit')]")
	WebElement Edit;

	@FindBy(xpath = "//h1[contains(text(), 'Add new user')]")
	WebElement header_AddNewUser;

	@FindBy(xpath = "//h1[contains(text(), 'Update user')]")
	WebElement header_UpdateUser;

	@FindBy(xpath = "//select[@formcontrolname='honorificNm']")
	WebElement TitleDropDown;

	@FindBy(xpath = "//input[@formcontrolname='firstNm']")
	WebElement FirstNm;

	@FindBy(xpath = "//input[@formcontrolname='lastNm']")
	WebElement LastNm;

	@FindBy(xpath = "//label[@for='male']")
	WebElement MaleGender;
	@FindBy(xpath = "//label[@for='female']")
	WebElement FemaleGender;
	@FindBy(xpath = "//label[@for='others']")
	WebElement OthersGender;

	@FindBy(xpath = "//input[@formcontrolname='emailId']")
	WebElement EmailId;

	@FindBy(xpath = "//input[@placeholder='Mobile number']")
	WebElement MobileNumber;

	@FindBy(xpath = "//ng-select[@formcontrolname='empLanguagesList']")
	WebElement EmpLanguagesList;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	List<WebElement> totalLanguages;

	@FindBy(xpath = "//ng-select[@bindlabel='designation']")
	WebElement Designation;

	@FindBy(xpath = "//h2[contains(text(), 'Professional details')]")
	WebElement professionalDetails;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	List<WebElement> links_Designation;

	@FindBy(xpath = "//ng-select[@bindlabel='designation']//descendant::input[1]")
	WebElement EnterDesignation;

	@FindBy(xpath = "//ng-select[@bindlabel='designation']//ng-dropdown-panel//span[1]")
	WebElement selectDesignation;

	@FindBy(xpath = "//label[@for='salaryBased']")
	WebElement salaryBased;
	@FindBy(xpath = "//label[@for='fullTimeConsultant']")
	WebElement fullTimeConsultant;
	@FindBy(xpath = "//label[@for='guestConsultant']")
	WebElement guestConsultant;

	@FindBy(xpath = "//input[@formcontrolname='isTelehealthRequired']//parent::label//child::span[@class='slider round']")
	WebElement TelehealthRdoBtn;

	@FindBy(xpath = "//ng-select[@bindlabel='specialityNm']")
	WebElement SpecialityNm;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	List<WebElement> links_SpecialityNm;

	@FindBy(xpath = "//ng-select[@bindlabel='deptNm']")
	WebElement DeptNm;

	@FindBy(xpath = "//span[@class='ng-option-label ng-star-inserted']")
	List<WebElement> links_DeptNm;

	@FindBy(id = "qualifications")
	WebElement Qualifications;

	@FindBy(id = "yearsOfExperience")
	WebElement YearsOfExperience;

	@FindBy(xpath = "//*[@formcontrolname='empCode']")
	WebElement EmpCode;

	@FindBy(xpath = "//*[@formcontrolname='userNm']")
	WebElement UserNm;

	@FindBy(xpath = "//input[@formcontrolname='feeValidDays']")
	WebElement FeeValidDays;

	@FindBy(xpath = "//input[@formcontrolname='doctorRegisterNo']")
	WebElement doctorRegisterNo;

	@FindBy(xpath = "//input[@formcontrolname='feeValidVisits']")
	WebElement FeeValidVisits;

	@FindBy(xpath = "//input[@formcontrolname='isMobileAccessed']//parent::label//child::span[@class='slider round']")
	WebElement AccessToProviderMblApp;

	@FindBy(xpath = "//input[@formcontrolname='isIpLoginRestricted']//parent::label//child::span[@class='slider round']")
	WebElement SecurityRestrictionType;

	@FindBy(xpath = "//input[@formcontrolname='isMultifactorAuthEnabled']//parent::label//child::span[@class='slider round']")
	WebElement MultifactorAuth;

	@FindBy(xpath = "//select[@formcontrolname='filterType']")
	WebElement filterType;

	@FindBy(xpath = "//span[text()='Add']")
	List<WebElement> addRole;

	@FindBy(xpath = "//button[contains(text(), ' Save ')]")
	WebElement btnSave;

	@FindBy(xpath = "//p[text()='New user added! You can edit the user details anytime.']")
	WebElement NewUserAdded;

	@FindBy(xpath = "//button[contains(text(), 'Update')]")
	WebElement btnUpdate;

	@FindBy(xpath = "//input[contains(@placeholder, 'Search users')]")
	WebElement searchUsers;

	@FindBy(xpath = "//li[@class='m-l-8 m-r-8 ng-star-inserted']")
	WebElement selectSearchedUser;

	// Initializing PageObjects/PageFactory/OR
	public UserManagementPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	// Actions/Methods
	public void switchToFrame() {
		pageHelpers.switchToFrame(0);
	}

	public void CheckUserManagementScreen() {
		pageHelpers.highlightElementByJavaScript(UserManagementScreen, _driver);
		pageHelpers.AssertTrue(UserManagementScreen);
	}

	public void clickOnAddNewUser() {
		pageHelpers.ClickWebElement(Addnewuser);
	}

	public void clickOnEdit() {
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		pageHelpers.JsClick(Edit);
	}

	public void DeactiveUser() {
		pageHelpers.JsClick(Deactive_User);
		pageHelpers.ClickWebElement(btn_YesImSure);
		pageHelpers.AssertTrue(toast_Deactivated);
	}

	public void ActivateUser() {
		pageHelpers.staticDropDownByVisibleText(drpdwn_FilterBy, "Inactive users");
		pageHelpers.breakListOfWebElements(inactiveUsers);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.JsClick(ActiveUser);
		pageHelpers.ClickWebElement(btn_YesImSure);
		pageHelpers.AssertTrue(toast_Activated);
	}

	public void checkAddNewUserHeader() {
		pageHelpers.WebElementIsDisplayed(header_AddNewUser);
	}

	public void checkUpdateUserHeader() {
		pageHelpers.WebElementIsDisplayed(header_UpdateUser);
	}

	public void validateAddNewUserDetails(String firstName, String lastName, String email, String mobile,
			String empCode, String userName) {
		pageHelpers.ClickWebElement(FirstNm);
		pageHelpers.ClickWebElement(LastNm);
		pageHelpers.ClickWebElement(EmailId);
		pageHelpers.ClickWebElement(MobileNumber);
		pageHelpers.takeScreenshotAtEndOfTest();
		pageHelpers.ClickWebElement(Designation);
		pageHelpers.ClickWebElement(DeptNm);
		pageHelpers.ClickWebElement(EmpCode);
		pageHelpers.takeScreenshotAtEndOfTest();
		pageHelpers.ClickWebElement(UserNm);
		pageHelpers.SendKeysToWebElement(FirstNm, firstName);
		pageHelpers.SendKeysToWebElement(LastNm, lastName);
		pageHelpers.SendKeysToWebElement(EmailId, email);
		pageHelpers.SendKeysToWebElement(MobileNumber, mobile);
		pageHelpers.takeScreenshotAtEndOfTest();
		pageHelpers.SendKeysToWebElement(EmpCode, empCode);
		pageHelpers.SendKeysToWebElement(UserNm, userName);
	}

	public void personalDetails(String title, String firstName, String lastName, String gender, String email,
			String mobile) {
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		pageHelpers.staticDropDownByVisibleText(TitleDropDown, title);
		pageHelpers.SendKeysToWebElement(FirstNm, firstName);
		pageHelpers.SendKeysToWebElement(LastNm, lastName);
		if (gender.equalsIgnoreCase("Male")) {
			pageHelpers.ClickWebElement(MaleGender);
		} else if (gender.equalsIgnoreCase("Female")) {
			pageHelpers.ClickWebElement(FemaleGender);
		} else {
			pageHelpers.ClickWebElement(OthersGender);
		}
		pageHelpers.SendKeysToWebElement(EmailId, email);
		pageHelpers.SendKeysToWebElement(MobileNumber, mobile);

		try {
			pageHelpers.ClickWebElement(EmpLanguagesList);
			pageHelpers.ListOfWebElements(totalLanguages);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void professionalDetails(String doctorType, String qualification, String yearsOfExperience, String empCode,
			String userName, String MCINumber, String feeValidDays, String feeValidVisits) {
		try {
			pageHelpers.ClickWebElement(Designation);
			logger.info("Total number of Departments Are ==> " + links_Designation.size());
			for (int i = 0; i < links_Designation.size(); i++) {
				logger.info(links_Designation.get(i).getText());
				pageHelpers.scrollIntoElementByJavaScript(links_Designation.get(i), _driver);
				pageHelpers.ClickWebElement(links_Designation.get(i));
				pageHelpers.ClickWebElement(Designation);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		pageHelpers.ClickWebElement(professionalDetails);
		if (doctorType.equalsIgnoreCase("Salary-based")) {
			pageHelpers.JsClick(salaryBased);
		} else if (doctorType.equalsIgnoreCase("Full-time consultant")) {
			pageHelpers.JsClick(fullTimeConsultant);
		} else {
			pageHelpers.JsClick(guestConsultant);
		}

		/*
		 * if (pageHelpers.WebElementIsDisplayed(TelehealthRdoBtn)) {
		 * pageHelpers.ClickWebElement(TelehealthRdoBtn); }
		 */

		try {
			pageHelpers.ClickWebElement(SpecialityNm);
			logger.info("Number of Specialities Are ==> " + links_SpecialityNm.size());
			for (int i = 0; i < links_SpecialityNm.size(); i++) {
				logger.info(links_SpecialityNm.get(i).getText());
				pageHelpers.ClickWebElement(links_SpecialityNm.get(i));
				pageHelpers.EnterUsingActions();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		pageHelpers.TabUsingActions();
		try {
			pageHelpers.ClickWebElement(DeptNm);
			logger.info("Number of Departments Are ==> " + links_DeptNm.size());
			for (int i = 0; i < links_DeptNm.size(); i++) {
				logger.info(links_DeptNm.get(i).getText());
				pageHelpers.JsClick(links_DeptNm.get(i));
				pageHelpers.EnterUsingActions();
			}
			pageHelpers.TabUsingActions();
		} catch (Exception e) {
		}
		pageHelpers.SendKeysToWebElement(Qualifications, qualification);
		pageHelpers.SendKeysToWebElement(YearsOfExperience, yearsOfExperience);
		pageHelpers.SendKeysToWebElement(EmpCode, empCode);
		pageHelpers.SendKeysToWebElement(UserNm, userName);
		pageHelpers.SendKeysToWebElement(doctorRegisterNo, MCINumber);
		pageHelpers.SendKeysToWebElement(FeeValidDays, feeValidDays);
		pageHelpers.SendKeysToWebElement(FeeValidVisits, feeValidVisits);
		pageHelpers.ClickWebElement(AccessToProviderMblApp);
		pageHelpers.ClickWebElement(SecurityRestrictionType);
		pageHelpers.ClickWebElement(MultifactorAuth);
	}

	public void addRole() {
		try {
			pageHelpers.ListOfWebElements(addRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveBtn() {
		pageHelpers.ClickWebElement(btnSave);
		pageHelpers.AssertTrue(NewUserAdded);
	}

	public void SearchBar() {
		pageHelpers.ClickWebElement(searchUsers);
	}

	public void updateBtn() {
		if (btnUpdate.isEnabled()) {
			pageHelpers.ClickWebElement(btnUpdate);
			Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		}
	}

	public void searchUsers(String searchUser) {
		pageHelpers.SendKeysToWebElement(searchUsers, searchUser);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void selectSearchedUser() {
		pageHelpers.ClickWebElement(selectSearchedUser);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void drpdwn_filterBy(String FilterBy) {
		pageHelpers.staticDropDownByVisibleText(drpdwn_FilterBy, FilterBy);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void drpdwn_sortBy(String SortBy) {
		pageHelpers.staticDropDownByVisibleText(drpdwn_sortBy, SortBy);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
	}

}
