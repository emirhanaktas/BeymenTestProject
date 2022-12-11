package org.example.test;

import org.example.base.BaseTest;
import org.example.page.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MainPageTest extends BaseTest {

    MainPage mainPage;


    @Before
    public void before() throws IOException {

        mainPage = new MainPage(getWebDriver());

    }

    @Test
    public void test() throws InterruptedException, IOException {
        mainPage.personalData()
                .moveToLogIn()
                .searcToClick()
                .clearToText()
                .readData()
                .productList()
                .productDetail()
                .addBasket()
                .myBasket()
                .addQuantity()
                .removeBasket();
        Thread.sleep(1000);
    }

    @After
    public void after(){
        tearDown();
    }

}
