package org.example.base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.example.constants.ConstantsMainPage.*;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public WebElement findElement(By by){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElement(by);
    }

    public void sendKeys(By by, String txt){
        findElement(by).sendKeys(txt);
    }

    public void click(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).click();
    }

    public void clear(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        findElement(by).sendKeys(Keys.DELETE);
    }

    public List<WebElement> findAll(By by){

        return driver.findElements(by);
    }

    public void selectProducts(int i) {
        int a = i;
        getAllProducts().get(i).click();
        System.out.println(a);

    }

    public List<WebElement> getAllProducts(){

        return findAll(PRODUCT_LIST_TRY);
    }


    public String getText(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return findElement(by).getText();
    }


}
