package com.utilities.helper;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunFailedTestCases implements IRetryAnalyzer {

    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            int maxRetryCount = 1;
            if (retryCount < maxRetryCount) {
                retryCount++;
                result.setStatus(ITestResult.FAILURE);
                String message = Thread.currentThread().getName() + ": Error in " + result.getName() + " Retrying "
                        + (maxRetryCount + 1 - retryCount) + " more times";
                System.out.println(message);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        }
        return false;
    }
}
