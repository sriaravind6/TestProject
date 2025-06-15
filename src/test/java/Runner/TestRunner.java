package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        features = "src/main/resources/features",
        glue = {"stepDefinitions"},
        dryRun = false,
        tags = "@Login",
        monochrome = true,
        stepNotifications = true
)
public class TestRunner {
}