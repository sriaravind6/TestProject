package stepDefinitions.Hooks;

import Common.CommonHelper;
import Common.WebPropertyHelpper;
import Utils.EmailUtil;
import Utils.ExtentReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Scenario;

public class Hooks extends CommonHelper {
    private WebDriver driver;

    // This method runs before each scenario
    @Before
    public void setup(Scenario scenario) {
        System.out.println("Launching the browser...");
        driver = WebPropertyHelpper.browserLaunch("chrome");
        driver.manage().window().maximize();
        ExtentReportManager.setupReport();
        ExtentReportManager.createTest(scenario.getName());
    }

    // This method runs after each scenario
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {  // Capture screenshot on failure
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        if (scenario.isFailed()) {
            ExtentReportManager.test.fail("Scenario Failed: " + scenario.getName());
        } else {
            ExtentReportManager.test.pass("Scenario Passed: " + scenario.getName());
        }
        ExtentReportManager.flushReport();
        System.out.println("Closing the browser...");
        if (scenario.isFailed()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Screenshot");
        }
        if (scenario.isFailed()) {
            ExtentReportManager.test.fail("Scenario Failed: " + scenario.getName());
        } else {
            ExtentReportManager.test.pass("Scenario Passed: " + scenario.getName());
        }
        ExtentReportManager.flushReport();
        System.out.println("Closing the browser...");
        driver.quit();

        // Send the Extent Report via email
        String reportPath = "target/ExtentReport.html";
        EmailUtil.sendEmailWithAttachment("aravindeee218@gmail.comq.com", "Test Report", "Please find the attached test report.", reportPath);

    }
}
