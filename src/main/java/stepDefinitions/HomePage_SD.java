package stepDefinitions;

import Common.CommonHelper;
import Common.WebPropertyHelpper;
import PageObjectModel.HomePage_PO;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.fail;


public class HomePage_SD extends CommonHelper {
    HomePage_PO homePagePo = PageFactory.initElements(driver, HomePage_PO.class);
    @Given("user launch bowser and open the {string}")
    public void user_launch_browser_and_open_the(String url) {// Initialize the driver
        driver.get(getDataFromPropertyFile(url));
//        Cookie cookie1 = new Cookie.Builder("C_WHLOC", "USWA")
//                .domain("costco.com")
//                .path("/")
//                .isSecure(true)
//                .build();
//        Cookie cookie2 = new Cookie.Builder("STORELOCATION", "{%22storeLocation%22:{%22city%22:%22Seattle%22%2C%22zip%22:%2298134-2311%22}}")
//                .domain("costco.com")
//                .path("/")
//                .isSecure(true)
//                .build();
//        Cookie cookie3 = new Cookie.Builder("WAREHOUSEDELIVERY_WHS", "{%22distributionCenters%22:[%221250-3pl%22%2C%221321-wm%22%2C%221456-3pl%22%2C%22283-wm%22%2C%22561-wm%22%2C%22725-wm%22%2C%22731-wm%22%2C%22758-wm%22%2C%22759-wm%22%2C%22847_0-cor%22%2C%22847_0-cwt%22%2C%22847_0-edi%22%2C%22847_0-ehs%22%2C%22847_0-membership%22%2C%22847_0-mpt%22%2C%22847_0-spc%22%2C%22847_0-wm%22%2C%22847_1-cwt%22%2C%22847_1-edi%22%2C%22847_d-fis%22%2C%22847_lg_n1f-edi%22%2C%22847_NA-cor%22%2C%22847_NA-pharmacy%22%2C%22847_NA-wm%22%2C%22847_ss_u362-edi%22%2C%22847_wp_r458-edi%22%2C%22951-wm%22%2C%22952-wm%22%2C%229847-wcs%22]%2C%22groceryCenters%22:[%22115-bd%22]%2C%22nearestWarehouse%22:{%22catalog%22:%221-wh%22}%2C%22pickUpCenters%22:[]}")
//                .domain("costco.com")
//                .path("/")
//                .isSecure(true)
//                .build();
//
//        driver.manage().addCookie(cookie1);
//        driver.manage().addCookie(cookie2);
//        driver.manage().addCookie(cookie3);

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