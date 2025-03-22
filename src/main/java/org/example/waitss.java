package org.example;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class waitss {
    public static void main(String[] args) throws InterruptedException {
       WebDriver driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
       driver.get("");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver webdriver) {
                return (webdriver.getCurrentUrl().equals("https://www.facebook.com/"));
            }
        };
        wait.until(function);
        wait.until(ExpectedConditions.urlToBe("https://www.facebook.com/"));
        driver.findElement(By.id("email")).sendKeys("selenium");
    }

}