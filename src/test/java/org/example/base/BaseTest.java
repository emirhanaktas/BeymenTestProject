package org.example.base;

import org.example.log.TestLogger;
import org.junit.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@ExtendWith(TestLogger.class)
public class BaseTest {

    static WebDriver webDriver = null;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "/Users/appcentappcent/Documents/selenium libraries/libraries/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");
        setWebDriver(new ChromeDriver(options));
        webDriver.manage().window().maximize();
        webDriver.get("https://www.beymen.com");
        //getWebDriver().navigate().to("https://www.beymen.com");
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }

    public static void setWebDriver(WebDriver webDriver){
        BaseTest.webDriver = webDriver;
    }

    public void tearDown(){
        getWebDriver().quit();
    }
}
