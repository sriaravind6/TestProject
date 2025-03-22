package org.example;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.function.Function;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class asseretionss {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://echoecho.com/htmlforms10.htm");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(driver.findElement(By.xpath("//input[@value='Milk']")).isSelected(),"Milk is selected");

        softAssert.assertTrue(driver.findElement(By.xpath("//input[@value='Butter']")).isSelected(),"Butter not selected");

        softAssert.assertFalse(driver.findElement(By.xpath("//input[@value='Cheese']")).isSelected());

        softAssert.assertAll();
    }
}