package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = "src/main/resources/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        tags = "@Smoke",
        monochrome = true,
        stepNotifications = true
)
public class TestRunner {
}