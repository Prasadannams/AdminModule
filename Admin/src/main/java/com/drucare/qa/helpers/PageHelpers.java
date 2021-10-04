package com.drucare.qa.helpers;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.drucare.qa.base.TestBase;
import com.google.common.util.concurrent.Uninterruptibles;

public class PageHelpers extends TestBase {
	public JavascriptExecutor javaScript;
	public Workbook book;
	public Sheet sheet;
	public Actions actions;
	public Select select;
	public Alert alert;
	public Robot robot;
	PageHelpers pageHelpers;

	Logger logger = Logger.getLogger(PageHelpers.class);
	SoftAssert softAssert = new SoftAssert();

	WebDriver driver = null;
	WebDriverWait wait = null;

	public PageHelpers(WebDriver driverObj) {
		this.driver = driverObj;
		wait = new WebDriverWait(driver, 15);
	}

	// To Click WebElement if it is Clickable
	public void ClickWebElement(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
	}

	// To Click WebElement if it is Visible
	public void ClickWebElementVisibile(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.click();
	}

	// get Text
	public void GetText(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		String newline = System.lineSeparator();
		logger.info(newline + "---------------> " + ele.getText());

	}

	// To Click WebElement try catch block
	public void ClickWebElementTryCatch(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// To Enter Text if it is visible
	public void SendKeysVisibile(WebElement ele, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.clear();
		ele.sendKeys(text);
	}

	// To Enter Text if it is Clickable
	public void SendKeysToWebElement(WebElement ele, String text) {
		wait.until(ExpectedConditions.visibilityOf(ele));
		ele.clear();
		ele.sendKeys(text);
	}

	// Enter Text Without Clear the Text field
	public void SendKeysWithoutClear(WebElement ele, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys(text);
	}

	// Enter Text Without Clear the Text field
	public void ClearValueFromTextbox(WebElement ele) {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		ele.clear();
	}

	public void fn_CloseNewTab() {
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "w");
	}

	public void fn_OpenNewTab(String taburl) {
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL + "t");
		driver.navigate().to(taburl);
	}

	// Soft Assert False
	public void SoftAssertFalse(WebElement ele, String Msg) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertFalse(value, Msg);
		softAssert.assertAll();
	}

	// Soft Assert False
	public void SoftAssertFalse(WebElement ele) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertFalse(value);
		softAssert.assertAll();
	}

	// Soft Assert True
	public void SoftAssertTrue(WebElement ele) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertTrue(value);
		softAssert.assertAll();
	}

	// Soft Assert True
	public void SoftAssertTrue(WebElement ele, String Msg) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		softAssert.assertTrue(value, Msg);
		softAssert.assertAll();
	}

	// Hard Assert False
	public void AssertFalse(WebElement ele, String Msg) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		Assert.assertFalse(value, Msg);
	}

	// Hard Assert False
	public void AssertFalse(WebElement ele) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		Assert.assertFalse(value);
	}

	// Hard Assert True
	public void AssertTrue(WebElement ele, String Msg) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		Assert.assertTrue(value, Msg);
	}

	// Hard Assert True
	public void AssertTrue(WebElement ele) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
		} catch (Exception e) {
		}
		Assert.assertTrue(value);
	}

	// Working on PlaceHolders
	public void getPlaceholder(WebElement ele, String attribute, String expPlaceholder) {
		String placeHolder = ele.getAttribute(attribute);
		logger.info(placeHolder);
		if (ele.getAttribute(attribute).equals(expPlaceholder)) {
			logger.info("The placeholder value is expected, ie : " + placeHolder);
		} else {
			logger.info("The placeholder value is not correct ---> " + placeHolder);
		}
	}

	// To Click List of WebElements using JavaScript Executor.
	public void JsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	// To check pageReadyState or Not.
	public void pageReadyState() {
		Wait<WebDriver> expWait = new WebDriverWait(driver, 30);
		expWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
	}

	// To Draw a Border for WebElement using JavaScript Executor.
	public void drawElementBorderByJavaScript(WebElement element, WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	// To Generate an Alert using JavaScript Executor.
	public void generateAlertByJavaScript(WebDriver driver, String alertMessage) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("alert('" + alertMessage + "')");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}

	// To Refresh Browser using JavaScript Executor.
	public void refreshBrowserByJavaScript(WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("history.go(0)");
	}

	// To Get Title of Page using JavaScript Executor.
	public void getPageTitleByJavaScript(WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		String pageTitle = javaScript.executeScript("return document.title;").toString();
		logger.info("The Title of the Page is ::: " + pageTitle);
	}

	// To Get Page Inner Text using JavaScript Executor.
	public void getPageInnerTextByJavaScript(WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		String pageText = javaScript.executeScript("return document.documentElement.innerText;").toString();
		logger.info("The Text of the Page is ::: " + pageText);
	}

	// To Scroll Down using JavaScript Executor.
	public void scrollDownPageByJavaScript(WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	// To Scroll Down
	public void scrollXaxis(int x) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(" + x + ", 0)");
	}

	// To Scroll Down & Up
	public void scrollDownAndUp(int x, int y) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(x, y)");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(x, y)");
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
	}

	// To Scroll into WebElement View using JavaScript Executor.
	public void scrollIntoElementByJavaScript(WebElement element, WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// To Send Input Data to Text Field using JavaScript Executor.
	public void sendKeysToJavaScript(WebElement element, WebDriver driver, String data) {
		javaScript = ((JavascriptExecutor) driver);
		element.clear();
		javaScript.executeScript("arguments[0].value='" + data + "'", element);
	}

	// To Select Calendar Date Or Data Picker using Java Script Executor.
	public void selectDateByJS(WebDriver driver, WebElement element, String dateValue) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].setAttribute('value','" + dateValue + "');", element);
	}

	// To Check Element is Displayed or No.
	public boolean WebElementIsDisplayed(WebElement ele) {
		boolean displayed = false;
		try {
			if (ele.isDisplayed()) {
				displayed = true;
			}
		} catch (Exception e) {
		}
		return displayed;
	}

	// To Click Element if it is Displayed.
	public boolean isDisplayedClick(WebElement ele) {
		boolean displayed = false;
		try {
			if (ele.isDisplayed()) {
				displayed = true;
				pageHelpers = new PageHelpers(driver);
				pageHelpers.JsClick(ele);
			}
		} catch (Exception e) {
		}
		return displayed;
	}

	// To Check Element is Selected or Not.
	public boolean WebElementIsSelected(WebElement ele) {
		boolean selected = false;
		try {
			if (ele.isSelected()) {
				selected = true;
			}
		} catch (Exception e) {
		}
		return selected;
	}

	// MultipleWindows
	public void MultipleWindows(int index) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(index));
	}

	// To Select a value from Drop Down by using SelectByVisibleText Method.
	public void staticDropDownByVisibleText(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByVisibleText(value);
	}

	// To Select a value from Drop Down by using SelectByIndex Method.
	public void staticDropDownByIndex(WebElement ele, int value) {
		select = new Select(ele);
		select.selectByIndex(value);
	}

	// To Select a value from Drop Down by using SelectByValue Method.
	public void staticDropDownByValue(WebElement ele, String value) {
		select = new Select(ele);
		select.selectByValue(value);
	}

	// Wait for Page Load
	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	// To Highlight WebElement using JavaScript Executor.
	public void highlightElementByJavaScript(WebElement element, WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		String backgroundColor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 2; i++) {
			changeColorByJavaScript("rgb(0, 200, 0)", element, driver);
			changeColorByJavaScript(backgroundColor, element, driver);
		}
	}

	// To Change Color of WebElement using JavaScript Executor.
	public void changeColorByJavaScript(String color, WebElement element, WebDriver driver) {
		javaScript = ((JavascriptExecutor) driver);
		javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
	}

	// To Switch into a Frame using Index.
	public void switchToFrame(int frame) {
		try {
			// Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
			driver.switchTo().frame(frame);
			logger.info("Navigated to Frame with Index ::: " + frame);
		} catch (NoSuchFrameException e) {
			logger.info("Unable to Locate Frame with Index ::: " + frame + e.getStackTrace());
		} catch (Exception e) {
			logger.info("Unable to Navigate to Frame with Index ::: " + frame + e.getStackTrace());
		}
	}

	// To Take Screenshot at End Of Test.
	public void takeScreenshotAtEndOfTest() {
		Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date dt = new Date();
		DateFormat df = new SimpleDateFormat("hh_mm_ss_dd_MM_yyyy");
		try {
			FileUtils.copyFile(scrFile,
					new File(System.getProperty("user.dir") + "/Results/" + df.format(dt) + ".png"));
		} catch (Exception e) {
		}
	}

	// Explicit Wait for Element To Be Visible.
	public void waitForElementToBeVisible(WebDriver driver, By locator, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void verify_Visibility(int time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			Reporter.log("Failed to Locate Element", true);
			Assert.fail();
		}
	}

	// To Check Element is Enabled or Not.
	public boolean isElementEnabled(WebElement element) {
		boolean elementEnabled = false;
		try {
			if (element.isEnabled()) {
				elementEnabled = true;
			}
		} catch (Exception e) {
		}
		return elementEnabled;
	}

	// To click Element is Enabled.
	public boolean isElementEnabledClick(WebElement element) {
		boolean elementEnabled = false;
		try {
			if (element.isEnabled()) {
				elementEnabled = true;
				pageHelpers = new PageHelpers(driver);
				pageHelpers.ClickWebElement(element);
			}
		} catch (Exception e) {
		}
		return elementEnabled;
	}

	// To Print all Values and Select a Required Value from Drop Down.
	public void selectDropDownValue(String xpathValue, String value) {
		List<WebElement> monthList = driver.findElements(By.xpath(xpathValue));
		for (int i = 0; i < monthList.size(); i++) {
			logger.info(monthList.get(i).getText());
			if (monthList.get(i).getText().equals(value)) {
				monthList.get(i).click();
				break;
			}
		}
	}

	// To Validate Drop Down Values.
	public void getOptionsFromDropDown(WebElement element) {
		Select select = new Select(element);
		List<WebElement> dropDownValues = select.getOptions();
		logger.info("Total Number of Values are ==> " + dropDownValues.size());
		for (WebElement dropDownValue : dropDownValues) {
			logger.info(dropDownValue.getText());
		}
	}

	// To Select Radio Button.
	public void selectRadioButton(List<WebElement> element, String value) {
		for (WebElement elements : element) {
			if (elements.getText().equalsIgnoreCase(value)) {
				elements.click();
				break;
			}
		}
	}

	// To Accept Alert Pop-Up.
	public void acceptAlertPopup() {
		try {
			alert = driver.switchTo().alert();
			logger.info(alert.getText());
			Thread.sleep(2000);
			alert.accept();
			logger.info("Alert Accepted Successfully");
		} catch (Exception e) {
			logger.info("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}

	// To Dismiss Alert Pop-Up.
	public void dismissAlertPopup() {
		try {
			alert = driver.switchTo().alert();
			logger.info(alert.getText());
			Thread.sleep(2000);
			alert.dismiss();
			logger.info("Alert Dismissed Successfully");
		} catch (Exception e) {
			logger.info("Something Went Wrong ==>> Please Check ::: " + e.getMessage());
		}
	}

	// To Click on Element using Actions Class.
	public void clickOnUsingActions(WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}

	// Click Enter Key using Actions Class.
	public void EnterUsingActions() {
		actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}

	// Click Enter Key using Actions Class.
	public void TabUsingActions() {
		actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// To Enter Value using Actions Class.
	public void SendKeysUsingActions(WebElement element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions = new Actions(driver);
		actions.moveToElement(element).click().sendKeys(text).build().perform();
	}

	// To MouseHover Value using Actions Class.
	public void mouseHoverUsingActions(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	// To Mouse Hover and Click or Select an Element using Actions Class.
	public void moveToElement(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	// To Perform Drag and Drop action using Actions Class - 1.
	public void dragAndDrop_1(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, destinationElement).pause(Duration.ofSeconds(2)).release().build().perform();
	}

	// To Perform Drag and Drop action using Actions Class - 2.
	public void dragAndDrop_2(WebDriver driver, WebElement sourceElement, WebElement destinationElement) {
		actions = new Actions(driver);
		actions.clickAndHold(sourceElement).pause(Duration.ofSeconds(2)).moveToElement(destinationElement)
				.pause(Duration.ofSeconds(2)).release().build().perform();
	}

	// To Perform Right Click action using Actions Class.
	public void rightClick(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.contextClick(element).build().perform();
	}

	// To perform Double Click action using Actions Class.
	public void doubleClick(WebDriver driver, WebElement element) {
		actions = new Actions(driver);
		actions.doubleClick(element).build().perform();
	}

	// scroll Down using Actions Class.
	public void scrollDownByActionsClass() {
		actions = new Actions(driver);
		actions.clickAndHold().sendKeys(Keys.ARROW_DOWN).build().perform();
		//sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	// Extent Report - 1.
	public String getSystemDate() {
		DateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// Extent Report - 2.
	public String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("_ddMMyyyy_HHmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty(prop.getProperty("currentDir")) + "/FailedTestsScreenshots/"
				+ screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	// Set Date For Log4J.
	public void setDateForLog4j() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
		System.setProperty("current_date", dateFormat.format(new Date()));
		PropertyConfigurator.configure("./src/main/resources/log4j.properties");
	}

	// Giving Keyboard inputs using RobotClass
	public void RobotClassTabClick() {
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);
		} catch (Exception e) {
		}
	}

	public void RobotClassEscapeClick() {
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			robot.delay(1000);
		} catch (Exception e) {
		}
	}

	// To click SHIFT+TAB Keys under KeyBoard
	public void RobotClassShiftPlusTabClick() {
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_SHIFT);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_SHIFT);
			robot.delay(1000);
		} catch (Exception e) {
		}
	}

	// Giving Keyboard inputs using RobotClass
	public void RobotClassEnterClick() {
		try {
			robot = new Robot();
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (Exception e) {
		}
	}

	// Working on windows based pop-up (File Upload)
	public void StringSelection(String uploadDocuments) {
		try {
			StringSelection myFile = new StringSelection(uploadDocuments);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(myFile, null);
			robot = new Robot();
			robot.delay(2000);
			// to press & release CONTROL+V
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
		} catch (Exception e) {
		}
	}

	public void robotCopyPaste() {
		// to press & release CONTROL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
	}

	// Giving Mouse inputs using RobotClass
	public void RobotClassMouseClick(int x, int y) {
		try {
			robot = new Robot();
			robot.mouseMove(x, y);
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		} catch (Exception e) {
		}
	}

	// Click List of Elements
	public void ListOfWebElements(List<WebElement> listOfElements) {
		logger.info("Number of elements:" + listOfElements.size());
		for (WebElement element : listOfElements) {
			pageHelpers = new PageHelpers(driver);
			pageHelpers.scrollIntoElementByJavaScript(element, driver);
			pageHelpers.JsClick(element);
		}
	}

	// To Match Value with List of Elements and Click on it.
	public void clickOnMatchingValueFromList(List<WebElement> listOfElements, String valueToBeMatched) {
		for (WebElement element : listOfElements) {
			if (element.getText().equalsIgnoreCase(valueToBeMatched)) {
				Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
				pageHelpers = new PageHelpers(driver);
				pageHelpers.clickOnUsingActions(element);
				// pageHelpers.JsClick(element);
				// pageHelpers.clickOn(driver, element, 15);
				break;
			}
		}
	}

	// Click Single Element from To List of Elements
	public void breakListOfWebElements(List<WebElement> listOfElements) {
		logger.info("Number of elements:" + listOfElements.size());
		for (WebElement element : listOfElements) {
			logger.info("Name of the element:" + element);
			pageHelpers = new PageHelpers(driver);
			pageHelpers.scrollIntoElementByJavaScript(element, driver);
			pageHelpers.JsClick(element);
			break;
		}
	}

	// DatePicker
	public void calendar(WebElement checkMonth, WebElement clickNextBtn, WebElement clickDate, String compareMonth) {
		String monthFirst = checkMonth.getText();
		logger.info(monthFirst);
		pageHelpers = new PageHelpers(driver);
		if (monthFirst.equalsIgnoreCase(compareMonth)) {
			pageHelpers.ClickWebElement(clickDate);
		} else {
			do {
				clickNextBtn.click();
				String monthSecond = checkMonth.getText();
				logger.info(monthSecond);
				if (monthSecond.equalsIgnoreCase(compareMonth)) {
					Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
					pageHelpers.JsClick(clickDate);
					break;
				}
			} while (true);
		}
	}

	public void sendKeysEnter(WebElement ele) {
		ele.sendKeys(Keys.ENTER);
	}

	public void sikuliClick(String ele) {
		Screen s = new Screen();
		Pattern obj = new Pattern(ele);
		try {
			s.wait(obj, 3000);
			s.click(obj);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}

	public void sikuliSendKeys(String ImgPath, String filePath) {
		Screen s = new Screen();
		Pattern obj = new Pattern(ImgPath);
		try {
			s.wait(obj, 3000);
			s.type(obj, filePath);
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
}
