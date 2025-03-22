package stepDefinitions;

import Common.CommonHelper;
import PageObjectModel.Registration_PO;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

public class Registration_SD extends CommonHelper {
    Registration_PO registration_po = PageFactory.initElements(driver, Registration_PO.class);
    @Given("user create an account from home page")
    public void userCreateAnAccountFromTheHomePage() throws InterruptedException {
        registration_po.createNewAccount();
    }
}