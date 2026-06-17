package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
            sparkReporter.config().setReportName("Test Execution Report");

            extentReports = new ExtentReports();
            extentReports.attachReporter(sparkReporter);

            extentReports.setSystemInfo("Project", "OrangeHRM Automation");
            extentReports.setSystemInfo("Automation", "Selenium + TestNG");
            extentReports.setSystemInfo("Browser", "Chrome");
            extentReports.setSystemInfo("Tester", "Sudhanshu");
        }

        return extentReports;
    }
}