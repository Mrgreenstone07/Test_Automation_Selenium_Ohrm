package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentManager;

public class ExtentTestListener implements ITestListener {

    private static final ExtentReports extentReports = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite execution started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test passed");
        
        Object currentClass = result.getInstance();
        BaseTest baseTest = (BaseTest) currentClass;
        String screenshotPath = baseTest.captureScreenshot(result.getMethod().getMethodName());

        try {
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            extentTest.get().warning("Screenshot could not be attached: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        Object currentClass = result.getInstance();
        BaseTest baseTest = (BaseTest) currentClass;

        String screenshotPath = baseTest.captureScreenshot(result.getMethod().getMethodName());

        try {
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            extentTest.get().warning("Screenshot could not be attached: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        System.out.println("Extent report generated successfully");
    }
}