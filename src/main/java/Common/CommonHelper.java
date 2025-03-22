package Common;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.*;


public class CommonHelper extends WebPropertyHelpper{
    public static LinkedHashMap<Integer,LinkedHashMap<String,String>> dataList = new LinkedHashMap<>();
    public static LinkedHashMap<String,String> dataMap = new LinkedHashMap<>();
    public static Set<String> headersList = new LinkedHashSet<>();
    public static File file;
    public static XSSFWorkbook wb;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static WebDriverWait wait;
    public boolean isElementPresent(WebElement element){
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean clickOnElement(WebElement element) {
        boolean flag = false;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (isElementPresent(element)) {
            try {
                if (element.isDisplayed()) {
                    element.click();
                    flag = true;
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to click element: " + e.getMessage());
            }
        }
        return flag;
    }

    public boolean isElementDisplayed(WebElement element,int time){
        boolean flag = false;
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        if (isElementPresent(element)) {
            try {
                if (element.isDisplayed()) {
                    flag = true;
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to is element displayed: " + e.getMessage());
            }
        }
        return flag;
    }

    public void clickAndSetInput(WebElement element,String inputText){
        try{
            isElementDisplayed(element,30);
            element.click();
            element.clear();
            element.sendKeys(inputText);
        }catch (Exception e) {
            throw new RuntimeException("Failed to enter text: " + e.getMessage());
        }
    }

    public String getElementText(WebElement element) {
        try {
            if (isElementPresent(element)) {
                return element.getText();
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to get text: " + e.getMessage());
        }
        return "";
    }

    public void scrollToElement(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll: " + e.getMessage());
        }
    }

    public void scrollToElementAndSetValue(WebElement element,String inputText) {
        try {
            JavascriptExecutor js =  ((JavascriptExecutor)driver);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            js.executeScript("arguments[0].setValue("+ inputText+" ");

        } catch (Exception e) {
            throw new RuntimeException("Failed to scroll: " + e.getMessage());
        }
    }

    public boolean clickWhenClickable(WebElement element, int time) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));
            clickableElement.click();
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String handleAlert(boolean accept) {
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            if (accept) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } catch (Exception e) {
            throw new RuntimeException("No alert present: " + e.getMessage());
        }
    }

    public String getRandomUserName(){
        return getRandomAlphanumeric(8);
    }

    public String getRandomUserId(){
        return "Test"+getRandomAlphanumeric(6)+"@yopmail.com";
    }

    public LinkedHashMap<Integer,LinkedHashMap<String,String>> getDataFromExcell(String filePath,String sheetName) {
        try {
            dataList = new LinkedHashMap<>();
            headersList = new LinkedHashSet<>();
            file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();
            for (Cell cell : sheet.getRow(0)) {
                headersList.add(cell.getStringCellValue());
            }
            for (int i = 1; i <= rowCount; i++) {
                row = sheet.getRow(i);
                dataMap = new LinkedHashMap<>();
                for (int j = 0; j < colCount; j++) {
                    cell = row.getCell(j);
                    dataMap.put(headersList.toArray()[j].toString(), getCellValue(cell));
                }
                dataList.put(i,dataMap);
            }
            wb.close();
        }catch (Exception e){
            throw new RuntimeException("Failed to get data from excel: " + e.getMessage());
        }
        return dataList;
    }

    public String getCellValue( XSSFCell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return cell.getStringCellValue();
        }
    }

    public void moveToElement(WebElement element){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }catch (Exception e){
            throw new RuntimeException("Failed to move to element: " + e.getMessage());
        }
    }

    public void highLightElement(WebDriver driver,WebElement element){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='3px solid red';", element);
        }catch (Exception e){
            throw new RuntimeException("Failed to height the element: " + e.getMessage());
        }
    }

    public void sleep(int time){
        try {
            Thread.sleep(time);
        }catch (Exception e){
            throw new RuntimeException("Failed to sleep: " + e.getMessage());
        }
    }

    public void closeBrowser(){
        try {
            driver.quit();
        }catch (Exception e){
            throw new RuntimeException("Failed to close browser: " + e.getMessage());
        }
    }

    public void switchToFrameByElement(WebElement element){
        try {
            driver.switchTo().frame(element);
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to frame: " + e.getMessage());
        }
    }

    public void switchToDefaultContent(){
        try {
            driver.switchTo().defaultContent();
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to default content: " + e.getMessage());
        }
    }

    public void switchToFrameByName(String frameName){
        try {
            driver.switchTo().frame(frameName);
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to frame: " + e.getMessage());
        }
    }

    public void switchToParentFrame(){
        try {
            driver.switchTo().parentFrame();
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to parent frame: " + e.getMessage());
        }
    }

    public void switchToWindow(String windowName){
        try {
            driver.switchTo().window(windowName);
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to window: " + e.getMessage());
        }
    }

    public void openNewTabAndNavigateNewUrl(String url){
        try {
            ((JavascriptExecutor) driver).executeScript("window.open()");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            driver.get(url);
        }catch (Exception e){
            throw new RuntimeException("Failed to open new tab and driver: " + e.getMessage());
        }
    }

    public void switchToAlertAndAccept(){
        try {
            driver.switchTo().alert().accept();
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to alert: " + e.getMessage());
        }
    }

    public void switchToAlertAndDismiss(){
        try {
            driver.switchTo().alert().dismiss();
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to alert: " + e.getMessage());
        }
    }

    public void switchToAlertAndSendKeys(String input){
        try {
            driver.switchTo().alert().sendKeys(input);
        }catch (Exception e){
            throw new RuntimeException("Failed to switch to alert: " + e.getMessage());
        }
    }

    public WebElement getElementBy(LocatorType type, String value) {
        try {
            switch (type) {
                case ID:
                    return driver.findElement(By.id(value));
                case NAME:
                    return driver.findElement(By.name(value));
                case CLASSNAME:
                    return driver.findElement(By.className(value));
                case TAGNAME:
                    return driver.findElement(By.tagName(value));
                case XPATH:
                    return driver.findElement(By.xpath(value));
                case CSS:
                    return driver.findElement(By.cssSelector(value));
                case LINKTEXT:
                    return driver.findElement(By.linkText(value));
                case PARTIALLINKTEXT:
                    return driver.findElement(By.partialLinkText(value));
                default:
                    throw new IllegalArgumentException("Invalid locator type: " + type);
            }
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found using " + type + " with value: " + value, e);
        }
    }
}