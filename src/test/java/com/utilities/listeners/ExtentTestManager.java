package com.utilities.listeners;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static Map<Object, Object> extentTestMap = new HashMap<>();
    private static ExtentReports extentReports = ExtentManager.getReporter();

    public static synchronized /*ExtentTest*/ void startTest(String testName) {
        /*return*/ startTest(testName, "");
    }

    public static synchronized /*ExtentTest*/ void startTest(String testName, String description) {
        ExtentTest extentTest = extentReports.startTest(testName, description);
        /*return (ExtentTest) */extentTestMap.put(Thread.currentThread().getId(), extentTest);
    }

    public static synchronized ExtentTest getTest() {
        return (ExtentTest)extentTestMap.get(Thread.currentThread().getId());
    }

    public static synchronized void endTest() {
        extentReports.endTest((ExtentTest)extentTestMap.get(Thread.currentThread().getId()));
    }
}