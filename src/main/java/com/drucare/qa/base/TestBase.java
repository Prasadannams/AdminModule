package com.drucare.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.drucare.qa.helpers.PageHelpers;
import com.drucare.qa.pages.MyProfilePage;
import com.drucare.qa.util.TestUtil;
import com.drucare.qa.util.TestUtil.Browser;
import com.google.common.util.concurrent.Uninterruptibles;
import com.paulhammant.ngwebdriver.NgWebDriver;
import com.drucare.qa.util.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static FileInputStream ip;

	public static String CONFIG_FILE_PATH = "";

	private static void getConfigFilePath() {
		if (CONFIG_FILE_PATH.equals("")) {
			FileInputStream ip;
			try {
				ip = new FileInputStream(
						System.getProperty("user.dir") + "/src/main/java/com/drucare/qa/config/config.properties");
				prop = new Properties();
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				ip = new FileInputStream(CONFIG_FILE_PATH);
				prop = new Properties();
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public TestBase() {
		getConfigFilePath();
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase(Browser.CHROME.toString())) {
			System.setProperty("webdriver.chrome.silentOutput", "true");
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver.silentOutput", "true");
			// ChromeOptions
			ChromeOptions options = new ChromeOptions();
			// open Browser in maximized mode
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			// options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--no-sandbox");
			driver = new ChromeDriver(options);
			NgWebDriver ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
			ngWebDriver.waitForAngularRequestsToFinish();
		} else if (browserName.equalsIgnoreCase(Browser.FF.toString())) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			browserName.equalsIgnoreCase(Browser.EDGE.toString());
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);

		driver.navigate().to(prop.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail("TEST CASE FAILED IS " + result.getName());
			test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.capture4Fail_Base64()).build());
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.fail("TEST CASE SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("TEST CASE PASSED IS " + result.getName());
			test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.capture4Pass_Base64()).build());
		}
		try {
			new PageHelpers(driver).takeScreenshotAtEndOfTest();
			new MyProfilePage(driver).LogOut();
			Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}
		if (Objects.nonNull(driver)) {
			driver.quit();
			driver = null;
		}
	}

	@BeforeSuite(alwaysRun = true)
	public void ExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/ExtentReport/AutomationTestResult.html");
		ExtentSparkReporter failedSpark = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/ExtentReport/failed-tests.html").filter().statusFilter()
						.as(new Status[] { Status.FAIL, Status.SKIP, Status.WARNING }).apply();
		failedSpark.config().setDocumentTitle("Failed Tests");

		extent = new ExtentReports();
		extent.attachReporter(reporter, failedSpark);

		extent.setSystemInfo("Product", "DrucareONE");
		extent.setSystemInfo("Linux", "20.04");
		extent.setSystemInfo("Project Manager", "Purushottam Reddy");
		extent.setSystemInfo("Team Lead", "Rabbani Syed");
		extent.setSystemInfo("Tester Name", "Asif Shaik");
	}

	@AfterSuite(alwaysRun = true)
	public void FlushReports() {
		extent.flush();
	}

}
