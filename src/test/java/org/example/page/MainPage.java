package org.example.page;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.asynchttpclient.util.Assertions;
import org.example.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.*;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static org.example.constants.ConstantsMainPage.*;


import java.io.FileInputStream.*;
import org.apache.poi.xssf.usermodel.*;

public class MainPage extends BasePage {

    WebDriver driver;
    File excelFile = new File("/Users/appcentappcent/Documents/BeymenTest.xlsx");

    FileInputStream fileInputStreams = new FileInputStream(excelFile);

    XSSFWorkbook xsf = new XSSFWorkbook(fileInputStreams);

    XSSFSheet sheet = xsf.getSheetAt(0);

    String entrySort = sheet.getRow(0).getCell(0).getStringCellValue();

    String entryGomlek = sheet.getRow(0).getCell(1).getStringCellValue();

    public MainPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public MainPage personalData(){
        click(PERSONAL_DATA);
        return this;
    }


    public MainPage moveToLogIn() throws InterruptedException {
        //Thread.sleep(1000);
        click(CLOSE_BUTTON);
        Thread.sleep(1000);
        return this;
    }

    public MainPage searcToClick() throws InterruptedException {
        click(SEARCH);
        //Thread.sleep(1000);
        sendKeys(SEARCH, entrySort);
        Thread.sleep(1000);
        return this;
    }

    public MainPage readData() throws InterruptedException, IOException {
        sendKeys(SEARCH, entryGomlek);
        //Thread.sleep(1000);
        findElement(SEARCH).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        return this;
    }

    public MainPage clearToText() throws InterruptedException {

        for (int i=0; i<4; i++){
            findElement(SEARCH).sendKeys(Keys.BACK_SPACE);
        }

        return this;
    }

    public MainPage productList() throws InterruptedException {
       Random rand = new Random();
        int randomProduct = rand.nextInt(getAllProducts().size());
        System.out.println(randomProduct);
        selectProducts(randomProduct);
        Thread.sleep(1000);
        return this;
    }

    public MainPage productDetail() throws IOException {
       String productDetail = getText(PRODUCT_DETAILT);
       String productPrice = getText(PRODUCT_PRICE);
       File file = new File("productDetail.txt");
       if (!file.exists()){
           file.createNewFile();
       }
       FileWriter fileWriter = new FileWriter(file, false);
       BufferedWriter bWriter = new BufferedWriter(fileWriter);
       bWriter.write(productDetail+" "+productPrice);
       //bWriter.write(productPrice);
       bWriter.close();
        System.out.println(productPrice);
       return this;
    }

    public MainPage addBasket() throws InterruptedException {
        Thread.sleep(5000);
        click(ADD_BASKET);
        if (findElement(BEDEN_INFO).isDisplayed()){
            Thread.sleep(1000);
            click(BEDEN_SELECT);
            Thread.sleep(1000);
            click(ADD_BASKET);
        }
        Thread.sleep(3000);
        return this;
    }

    public MainPage myBasket() throws InterruptedException {
        Thread.sleep(1000);
        String productPagePrice = getText(PRODUCT_DETAIL_PRICE);
        click(MY_BASKET);
        Thread.sleep(2000);
        String productBasketPrice = getText(PRODUCT_SALE_PAGE_PRICE);
        Thread.sleep(2000);
        System.out.println(productPagePrice.equals(productBasketPrice));
        if (productPagePrice.equals(productBasketPrice)==true){
            System.out.println("Ürün satış fiyatı ve ürün sepet fiyatı doğru!");
        }else {
            System.out.println("Ürün satış fiyatı ve ürün sepet fiyatı yanlış!");
        }
        return this;
    }

    public MainPage addQuantity() throws InterruptedException {
        Thread.sleep(1000);
        String quantity_1 = getText(PRODUCT_QUANTITY);
        System.out.println(quantity_1);
        click(PRODUCT_QUANTITY);
        Thread.sleep(3000);
        String quantity_2 = getText(QUANTITY_NUMBER);
        System.out.println(quantity_2);
        System.out.println(quantity_2.equals(quantity_1));
        return this;
    }

    public MainPage removeBasket() throws InterruptedException {
        Thread.sleep(2000);
        click(PRODUCT_BASKET_REMOVE);
        Thread.sleep(2000);
        if (findElement(EMPTY_CART).isDisplayed()){
            System.out.println("Sepet boşaltıldı!");
        }else {
            System.out.println("Sepetteki ürün çıkartılamadı veya sepette başka ürünler mevcut!");
        }
        return this;
    }


}
