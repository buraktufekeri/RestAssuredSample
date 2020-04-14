package com.utilities.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.utilities.helper.Configuration;
import com.utilities.listeners.ExtentManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    protected static Configuration configurationGet = Configuration.getInstance();
    protected final static Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        switch (configurationGet.getEnvironment()) {
            case "int":
                logger.info("Suite Before Run : " + "Restful Service Environment int");
                break;
            case "uat":
                logger.info("Suite Before Run : " + "Restful Service Environment uat");
                break;
        }

        logger.info("RestAssured Test Automation");

        try {
            ExtentReports extentReports = ExtentManager.getReporter();
            extentReports.addSystemInfo("RestAssured ", "Restful Service Test Automation");
        } catch (Exception parseExp) {
            parseExp.printStackTrace();
        }

        logger.info("Installation finish");
    }

    @BeforeMethod
    public static void beforeMethod(){
    }

    @AfterMethod
    public static void afterMethod(){
    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown(){
        if (configurationGet.getEnvironment().equals("int") || configurationGet.getEnvironment().equals("uat"))
            logger.info("Test Finish\n");
    }
}