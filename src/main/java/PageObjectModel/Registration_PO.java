package PageObjectModel;

import Common.CommonHelper;
import Common.WebPropertyHelpper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Registration_PO extends CommonHelper {
    CommonHelper common = new CommonHelper();
    @FindBy(xpath = "//td[@class='login_register']")
    public WebElement registrationBtn;
    @FindBy(id = "username")
    public WebElement userNameTxt;
    @FindBy(id = "password")
    public WebElement passwordTxt;
    @FindBy(id = "re_password")
    public WebElement rePasswordTxt;
    @FindBy(id = "full_name")
    public WebElement fullNameTxt;
    @FindBy(id = "email_add")
    public WebElement emailTxt;
    @FindBy(id = "tnc_box")
    public WebElement checkBox;
    @FindBy(xpath = "//input[@value='Register']")
    public WebElement registerBtn;
    @FindBy(xpath = "//span[@class='register_msg']")
    public WebElement registerationSucessMsgTxt;
    @FindBy(xpath = "//a[text()='Click here to login']")
    public WebElement clickHereToLoginBtn;


    //=============================Methods============================================//

    public void createNewAccount() throws InterruptedException {
        common.clickOnElement(registrationBtn);
        common.clickAndSetInput(userNameTxt,getRandomUserName());
        common.clickAndSetInput(passwordTxt, WebPropertyHelpper.getDataFromPropertyFile("commonPasscode"));
        common.clickAndSetInput(rePasswordTxt, WebPropertyHelpper.getDataFromPropertyFile("commonPasscode"));
        common.clickAndSetInput(fullNameTxt,getRandomAlpha(7).toUpperCase());
        common.clickAndSetInput(emailTxt,getRandomUserId());
        sleep(10000);
        common.clickOnElement(checkBox);
        common.clickOnElement(registerBtn);
        sleep(10000);
        Assert.assertTrue(isElementDisplayed(clickHereToLoginBtn,10),"Element not displayed");
        Assert.assertEquals(driver.getCurrentUrl(),"https://adactinhotelapp.com/Register.php","user not registered");
    }
}