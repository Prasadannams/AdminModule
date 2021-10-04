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

public class RoleManagementPage {

	WebDriver _driver;
	PageHelpers pageHelpers = null;

	Logger logger = Logger.getLogger(RoleManagementPage.class);

	@FindBy(xpath = "//a[text()='Role Management']")
	WebElement tab_RoleManagement;

	@FindBy(xpath = "//button[contains(text(), 'Add new role')]")
	WebElement addNewRoleBtn;

	@FindBy(xpath = "//span[text()='Edit']")
	WebElement editBtn;

	@FindBy(xpath = "//input[contains(@formcontrolname, 'searchText')]")
	WebElement searchRole;

	@FindBy(xpath = "//div[@class='row m-0 p-t-8 p-b-8']")
	List<WebElement> selectRole;

	@FindBy(xpath = "//h1[contains(text(), 'Create role')]")
	WebElement header_CreateRole;

	@FindBy(xpath = "//h2[contains(text(), 'Role details')]//following::button[1]")
	WebElement editRoleDetails;

	@FindBy(xpath = "//div[text()='Select user or add custom tag']//following::span[1]")
	WebElement removeTag;

	@FindBy(xpath = "//button[contains(text(), 'Update')]")
	WebElement updateRoleDetails;

	@FindBy(xpath = "//*[@formcontrolname='roleNm']")
	WebElement roleTxt;

	@FindBy(xpath = "//ng-select[@formcontrolname='tagsList']")
	WebElement tagsListLink;

	@FindBy(xpath = "//div[contains(text(), 'Create new tag')]")
	WebElement createNewTag;

	@FindBy(xpath = "//input[@formcontrolname='tagNm']")
	WebElement tagNameTxt;

	@FindBy(xpath = "//a[contains(text(), 'Add')]")
	WebElement addBtn;

	@FindBy(xpath = "//div[contains(text(), 'Select user or add custom tag')]")
	WebElement selectUser;

	@FindBy(xpath = "//div[text()='Select user or add custom tag']//following::div[1]//input[1]")
	WebElement selectUserTxt;

	@FindBy(xpath = "//div[@class='ng-dropdown-panel-items scroll-host']//child::div[@role='option']//div")
	WebElement selectUserTxtVal;

	@FindBy(xpath = "//p[text()='TAG IS ALREADY EXIST']")
	WebElement TagAlreadyExist;

	@FindBy(xpath = "//textarea[@formcontrolname='roleDescription']")
	WebElement descriptionTxt;

	@FindBy(xpath = "//div[contains(@formarrayname, 'modulesList')]//li//img")
	List<WebElement> allServices;

	@FindBy(xpath = "//button[contains(text(), 'Proceed')]")
	WebElement ProceedBtn;

	@FindBy(xpath = "//h2[contains(text(), 'Screen permissions')]//following::h4")
	List<WebElement> selectScreens;

	@FindBy(xpath = "//label[text()='All']")
	List<WebElement> selectAll;

	@FindBy(xpath = "//h2[contains(text(), 'Screen permissions')]//following::h4[text()='MIS']")
	WebElement MIS;

	@FindBy(xpath = "//label[text()='Show']")
	WebElement showDashboard;

	@FindBy(xpath = "//h2[contains(text(), 'Screen permissions')]//following::button[text()='Create role']")
	WebElement createRole;

	@FindBy(xpath = "//p[text()='The given role name is already exist. Please enter another role name']")
	WebElement RoleAlreadyExisted;

	@FindBy(xpath = "//span[@class='slider round']")
	WebElement Deactive_Role;

	@FindBy(xpath = "//button[text()='Yes I‘m sure']")
	WebElement btn_YesImSure;

	@FindBy(xpath = "//p[contains(text(), 'has been activated & moved to active list')]")
	WebElement toast_activated;

	@FindBy(xpath = "//p[contains(text(), 'has been deactivated & moved to inactive list')]")
	WebElement toast_deactivated;

	@FindBy(xpath = "//select[@id='filterBy']")
	WebElement drpdwn_FilterBy;

	@FindBy(xpath = "//div[@class='row m-0 p-t-8 p-b-8']")
	List<WebElement> inactiveRoles;

	@FindBy(xpath = "//label[text()='Inactive']//following::span[1]")
	WebElement ActiveRole;

	public RoleManagementPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
		pageHelpers = new PageHelpers(_driver);
	}

	public void switchToFrame() {
		pageHelpers.switchToFrame(0);
	}

	public void clickOnAddnewrole() {
		pageHelpers.ClickWebElement(addNewRoleBtn);
	}

	public void clickOnEdit() {
		pageHelpers.scrollIntoElementByJavaScript(editBtn, _driver);
		pageHelpers.JsClick(editBtn);
	}

	public void SearchRole(String SearchRole) {
		pageHelpers.SendKeysToWebElement(searchRole, SearchRole);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void selectSearchedRole() {
		pageHelpers.breakListOfWebElements(selectRole);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
	}

	public void editRoleDetails() {
		pageHelpers.ClickWebElement(editRoleDetails);
	}

	public void removeExistingTag() {
		pageHelpers.ClickWebElement(removeTag);
	}

	public void updateRoleDetails() {
		pageHelpers.ClickWebElement(updateRoleDetails);
	}

	public void checkCreateRoleHeader() {
		pageHelpers.WebElementIsDisplayed(header_CreateRole);
	}

	public void RoleDetails(String roleName, String tagName, String description) {
		Uninterruptibles.sleepUninterruptibly(6, TimeUnit.SECONDS);
		pageHelpers.scrollIntoElementByJavaScript(roleTxt, _driver);
		pageHelpers.SendKeysToWebElement(roleTxt, roleName);
		pageHelpers.scrollIntoElementByJavaScript(tagsListLink, _driver);
		pageHelpers.ClickWebElement(tagsListLink);
		pageHelpers.ClickWebElement(createNewTag);
		pageHelpers.scrollIntoElementByJavaScript(tagNameTxt, _driver);
		pageHelpers.ClickWebElement(tagNameTxt);
		pageHelpers.SendKeysToWebElement(tagNameTxt, tagName);
		pageHelpers.ClickWebElement(addBtn);
		pageHelpers.ClickWebElement(tagsListLink);
		pageHelpers.SendKeysToWebElement(selectUserTxt, tagName);
		pageHelpers.ClickWebElement(selectUserTxtVal);
		pageHelpers.isDisplayedClick(selectUser);
//		try {
//			if(TagAlreadyExist.isDisplayed()) {			
//				logger.info("->'TAG IS ALREADY EXIST'<-");			
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		pageHelpers.scrollIntoElementByJavaScript(descriptionTxt, _driver);
		pageHelpers.SendKeysToWebElement(descriptionTxt, description);
	}

	public void selectServices() {
		try {
			pageHelpers.ListOfWebElements(allServices);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ProceedBtn() {
		pageHelpers.ClickWebElement(ProceedBtn);
	}

	public void selectAllScreens() {
		pageHelpers.pageReadyState();
		try {
			pageHelpers.ListOfWebElements(selectScreens);
			// Thread.sleep(300);
			pageHelpers.ListOfWebElements(selectAll);
			if (showDashboard.isDisplayed()) {
				pageHelpers.ClickWebElement(showDashboard);
			}
		} catch (Exception e) {
		}
	}

	public void clickCreateRole() {
		pageHelpers.scrollIntoElementByJavaScript(createRole, _driver);
		pageHelpers.isElementEnabledClick(createRole);
		pageHelpers.AssertFalse(RoleAlreadyExisted,
				"=>'The given role name is already exist. Please enter another role name'<=");
		// logger.info("->The given role name is already exist. Please enter another
		// role name'<-");
		pageHelpers.scrollIntoElementByJavaScript(drpdwn_FilterBy, _driver);
		pageHelpers.ClickWebElement(drpdwn_FilterBy);
	}

	public void DeactiveRole() {
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.JsClick(Deactive_Role);
		pageHelpers.ClickWebElement(btn_YesImSure);
		pageHelpers.AssertTrue(toast_deactivated);
		logger.info("=>User Deactivated<=");
	}

	public void ActivateRole() {
		pageHelpers.staticDropDownByVisibleText(drpdwn_FilterBy, "Inactive roles");
		pageHelpers.breakListOfWebElements(inactiveRoles);
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		pageHelpers.JsClick(ActiveRole);
		pageHelpers.ClickWebElement(btn_YesImSure);
		pageHelpers.AssertTrue(toast_activated);
		logger.info("=>User Activated<=");

	}

}