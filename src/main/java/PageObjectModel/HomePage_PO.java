package PageObjectModel;

import Common.CommonHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage_PO extends CommonHelper {
    CommonHelper common = new CommonHelper();
    @FindBy(xpath = "//button[normalize-space()='Sign In']")
    public WebElement signInBtn;
    @FindBy(xpath="//button[@title='Sign In']")
    public WebElement signInBtnIcon;
    @FindBy(xpath="//div[@data-testid='SearchBarUI']/parent::div/parent::div/following-sibling::div//li/a[@aria-label='Orders & Returns']")
    public WebElement ordersAndReturnsBtn;
    @FindBy(xpath = "//div[@data-testid='SearchBarUI']/parent::div/parent::div/following-sibling::div//li/a[@aria-label='Orders & Returns']/parent::li/following-sibling::li/a[@aria-label='Cart']")
    public WebElement cartBtn;
    @FindBy(xpath="//nav[@data-testid='LinkList']//ul//li//button[@data-testid='Button_shop-menu-button']")
    public WebElement shopBtn;
    @FindBy(xpath="//h1[@id='signInHeader']")
    public WebElement signInHeaderTxt;
    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signInBtnOnSignInPage;
    @FindBy(xpath="//a[@id='createAccount']")
    public WebElement createAccountBtn;

//=======================================Methods============================================//
    public void clickOnSignInBtn() {
        Assert.assertTrue( common.clickOnElement(signInBtn),"signin button not displayed");
    }
    public void clickOnSignInIconBtn() {
        Assert.assertTrue( common.clickOnElement(signInBtnIcon),"signin icon button not displayed");
    }
    public void clickOnOrdersAndReturnsBtn() {
        Assert.assertTrue(common.clickOnElement(ordersAndReturnsBtn),"Orders and Returns button not displayed");
    }
    public void clickOnCartBtn() {
        Assert.assertTrue( common.clickOnElement(cartBtn),"Cart button not displayed");
    }
    public void clickOnShopBtn() {
        Assert.assertTrue( common.clickOnElement(shopBtn),"Shop button not displayed");
    }
    public void userShouldBeNavigatedToTheSignInPage() {
        Assert.assertTrue( common.isElementDisplayed(signInHeaderTxt,10),"Sign in header not displayed");
        Assert.assertTrue(common.isElementDisplayed(signInBtnOnSignInPage,10),"Sign in button not displayed");
        Assert.assertTrue(common.isElementDisplayed(createAccountBtn,10),"Create account button not displayed");
    }
}
