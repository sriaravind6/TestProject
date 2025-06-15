package Common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;

public class WebPropertyHelpper extends Base {
    public final static String configFilePath = "src/main/java/Utils/Config.properties";
    public static Properties properties = new Properties();
    public static String getDataFromPropertyFile(String key)  {
        try{
            FileInputStream configFileReader = new FileInputStream(configFilePath);
            properties.load(configFileReader);
            configFileReader.close();
        }
        catch (Exception e){
            throw new RuntimeException("Get Key value from the property file ===>"+e.getMessage());
        }
        return properties.getProperty(key);
    }
    public static WebDriver browserLaunch(String browserType){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
//        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        browser =getDataFromPropertyFile("browser");
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(options);}
        else if (browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("safari")){
            driver = new SafariDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("browser not matched");
        }
        return driver;
    }
}