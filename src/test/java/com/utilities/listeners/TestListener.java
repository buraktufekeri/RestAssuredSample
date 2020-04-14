package com.utilities.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.utilities.base.BaseTest;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult testResult) {
        ExtentTestManager.startTest(testResult.getTestClass().getName().split("Method")[1].replace(".","ClassName > "));
        logger.info("Test Start:" + testResult.getTestClass().getName());
    }

    @Override
    public void onTestSuccess(ITestResult testResult) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "MethodName > ".concat(testResult.getName()),"Test Succeeded");
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        ExtentTestManager.getTest().log(LogStatus.FAIL, "MethodName > ".concat(testResult.getName()), testResult.getThrowable().toString());
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        logger.info("Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult testResult) {
        ExtentTestManager.getTest().log(LogStatus.SKIP, "MethodName > ".concat(testResult.getName()), testResult.getThrowable().toString());
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        logger.info("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
        ExtentTestManager.getTest().log(LogStatus.UNKNOWN, "MethodName > ".concat(testResult.getName()), testResult.getThrowable().toString());
        ExtentManager.getReporter().endTest(ExtentTestManager.getTest());
        logger.fatal("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext testResult) {
        PropertyConfigurator.configure("properties/log4j.properties");
        logger.info("Start");
    }

    @Override
    public void onFinish(ITestContext testResult) {
        ExtentManager.getReporter().flush();
        logger.info("Finished");
    }
}
