package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         driver.get("https://www.irctc.co.in/nget/train-search");
         Thread.sleep(5000);
         List<WebElement> footerIconList=driver.findElements(By.xpath("//div[contains(@class,'footer-icons')]//span/a"));
         for(WebElement footerIcon :footerIconList){
             String parentWindow = driver.getWindowHandle();
             JavascriptExecutor js  = (JavascriptExecutor) driver;
             js.executeScript("arguments[0].scrollIntoView();",footerIcon);
             js.executeScript("arguments[0].style.border='2px dotted yellow'", footerIcon);
             Thread.sleep(3000);
             String name = footerIcon.getAttribute("alt");
             footerIcon.click();
                Thread.sleep(3000);
                Set<String> allWindowsPresentAfterClicking = driver.getWindowHandles();
                for(String s:allWindowsPresentAfterClicking){
                    if(!s.equals(parentWindow)){
                        driver.switchTo().window(s);
                        System.out.println(driver.getTitle());
                        TakesScreenshot tk = (TakesScreenshot) driver;
                        File src = tk.getScreenshotAs(OutputType.FILE);
                        File desc = new File("src/screenshot/"+name+".png");
                        FileUtils.copyFile(src,desc);
                        driver.close();
                    }
                }
                driver.switchTo().window(parentWindow);
         }
    }

}