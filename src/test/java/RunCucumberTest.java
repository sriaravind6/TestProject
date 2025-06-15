import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SelectClasspathResource("features")
@IncludeTags("smoke")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty,junit:target/cucumber-reports/Cucumber.xml")
public class RunCucumberTest {
}