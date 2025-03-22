package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setupReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void flushReport() {
        extent.flush();
    }
}
