package PageObjectModel;

import Common.CommonHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class Registration_PO extends CommonHelper {
//    CommonHelper common = new CommonHelper();
    public static String signInUser;
    @FindBy(xpath = "//h1[@id='createAccountHeader']")
    public WebElement accountHeaderTxt;
    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTxtBox;
    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement passwordTxtBox;
    @FindBy(xpath = "//input[@id='reenterPassword']")
    public WebElement confirmPasswordTxtBox;
    @FindBy(xpath = "//button[@id='continue']")
    public WebElement continueBtn;
    @FindBy(xpath = "//h1[@automation-id='linkYourMembership']")
    public WebElement linkYourMembershipTxt;
    @FindBy(xpath = "//input[@id='shopAsNonMemberBtn']")
    public WebElement shopAsNonMemberBtn;
    @FindBy(xpath = "//div[@data-testid='SearchBarUI']/parent::div/parent::div/following-sibling::div//li/a[@aria-label='Orders & Returns']/../preceding-sibling::li//button//div[@data-testid='Text_myaccount']")
    public WebElement myAccountBtn;
    @FindBy(xpath="//a[@id='createAccount']")
    public WebElement createAccountBtn;


    //=============================Methods============================================//

    public void createNewAccount()  {
        signInUser = getRandomAlphaMailId().toLowerCase();
        System.out.println("User email: "+signInUser);
        Assert.assertTrue(clickOnElement(createAccountBtn),"Create account button not displayed");
        Assert.assertTrue(isElementDisplayed(accountHeaderTxt,10),"Account header not displayed");
        clickAndSetInput(emailTxtBox,signInUser);
        clickAndSetInput(passwordTxtBox,getDataFromPropertyFile("commonPasscode"));
        clickAndSetInput(confirmPasswordTxtBox,getDataFromPropertyFile("commonPasscode"));
        moveToElementCenterAndClick(continueBtn);
        waitForDOMLoad(30);
        isElementDisplayed(linkYourMembershipTxt,60);
        Assert.assertTrue(clickOnElement(shopAsNonMemberBtn),"Shop as non member button not displayed");
        Assert.assertTrue(isElementDisplayed(myAccountBtn,10),"My account button not displayed");
    }
}