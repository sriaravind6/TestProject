package stepDefinitions;

import Common.CommonHelper;
import Common.WebPropertyHelpper;
import io.cucumber.java.en.Given;


public class HomePage_SD extends CommonHelper {
    @Given("user launch bowser and open the {string}")
    public void user_launch_browser_and_open_the(String url) {// Initialize the driver
        driver.get(getDataFromPropertyFile(url));
    }

}