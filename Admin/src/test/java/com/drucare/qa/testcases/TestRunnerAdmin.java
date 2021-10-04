package com.drucare.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import com.drucare.qa.ExtentReportListener.ExtentReporterNG;
import com.drucare.qa.analyzer.Transformer;
import com.drucare.qa.base.TestBase;
import com.drucare.qa.util.TestUtil;

public class TestRunnerAdmin {

	static TestNG testNg;
	static String testDataExcelSheetPath = "";
	static String suiteName = "regression";

	public static void main(String[] args) {

		TestUtil.TESTDATA_SHEET_PATH = args[0];
		TestBase.CONFIG_FILE_PATH = args[1];
		suiteName = args[2];

		ExtentReporterNG ext = new ExtentReporterNG();
		Transformer trans = new Transformer();

		testNg = new TestNG();

		// Define a List
		List<String> suites = new ArrayList<String>();

		if (suiteName.equalsIgnoreCase("sanity")) {
			suites.add(System.getProperty("user.dir") + "/testngsanity.xml");
		} else if (suiteName.equalsIgnoreCase("regression")) {
			suites.add(System.getProperty("user.dir") + "/testng.xml");
		} else {
			System.out.println("Enter Valid Option");
		}

		// Add testNg.xml files

		// Set the suites to run
		testNg.setTestSuites(suites);

		testNg.addListener(ext);
		testNg.addListener(trans);

		testNg.run();

		/*
		 * testNg.setTestClasses(new Class[] { BranchManagementTest.class,
		 * UserManagementPageTest.class, RoleManagementPageTest.class,
		 * UserLogsPageTest.class, StatutoryCalendarLicencePageTest.class,
		 * StatutoryCalendarAgreementsPageTest.class });
		 */

	}

}
