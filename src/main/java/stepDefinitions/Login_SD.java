package stepDefinitions;

import Common.CommonHelper;
import PageObjectModel.Login_PO;
import Utils.ExtentReportManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class Login_SD extends CommonHelper {
    Login_PO loginPo = PageFactory.initElements(driver,Login_PO.class);
    @Then("user login with vaild credintials {string} and {string}")
    public void user_login_with_vaild_credintials_and(String email, String pass) {
       loginPo. loginToTheApplication(email,pass);
    }

}
