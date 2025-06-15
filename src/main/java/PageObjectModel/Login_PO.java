package PageObjectModel;

import Common.CommonHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Login_PO extends CommonHelper {
    @FindBy(xpath = "//input[@id='signInName']")
    public WebElement emailTxtBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTxtBox;
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInBtnOnSignInPage;
    @FindBy(xpath = "//div[@data-testid='SearchBarUI']/parent::div/parent::div/following-sibling::div//li/a[@aria-label='Orders & Returns']/../preceding-sibling::li//button//div[@data-testid='Text_myaccount']")
    public WebElement myAccountBtn;
//    ===========================================Methods======================================
    public void loginToTheApplication(String email, String password) {
        clickAndSetInput(emailTxtBox,getDataFromPropertyFile(email));
        clickAndSetInput(passwordTxtBox,getDataFromPropertyFile(password));
        moveToElementCenterAndClick(signInBtnOnSignInPage);
        Assert.assertTrue(isElementDisplayed(myAccountBtn,10));
        sleep(5000);
    }

}
