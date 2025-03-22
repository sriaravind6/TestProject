package stepDefinitions;

import Common.CommonHelper;
import Common.WebPropertyHelpper;
import PageObjectModel.HomePage_PO;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.fail;


public class HomePage_SD extends CommonHelper {
    HomePage_PO homePagePo = PageFactory.initElements(driver, HomePage_PO.class);
    @Given("user launch bowser and open the {string}")
    public void user_launch_browser_and_open_the(String url) {// Initialize the driver
        driver.get(getDataFromPropertyFile(url));
    }

    @Given("user click on the {string} button")
    public void user_click_on_the_button(String buttonName) {
        switch (buttonName) {
            case "Sign In / Register":
                homePagePo.clickOnSignInBtn();
                break;
            case "Orders & Returns":
                homePagePo.clickOnOrdersAndReturnsBtn();
                break;
            case "Cart":
                homePagePo.clickOnCartBtn();
                break;
            case "Shop":
                homePagePo.clickOnShopBtn();
                break;
            default:
                fail("Button not found");
        }
    }

    @Given("user should be navigated to the Sign in page")
    public void user_should_be_navigated_to_the_sign_in_page() {
        homePagePo.userShouldBeNavigatedToTheSignInPage();
    }
}