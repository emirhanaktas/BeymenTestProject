package org.example.constants;

import org.openqa.selenium.By;

public class ConstantsMainPage {

    public static final By PERSONAL_DATA = By.id("onetrust-accept-btn-handler");
    public static final By CLOSE_BUTTON = By.id("genderManButton");
    public static final By SEARCH = By.xpath("//input[@placeholder='Ürün, Marka Arayın']");

    public static final By PRODUCT_LIST = By.xpath("//div[@id='productList']");

    public static By PRODUCT_TITLE_LIST = new By.ByCssSelector("span.m-productCard__heart");
    //m-productCard__heart
    //span.m-productCard__title

    public static By PRODUCT_LIST_TRY = new By.ByXPath("//div[@class='m-productCard__photo']");

    public static By PRODUCT_DETAILT = new By.ByCssSelector("span.o-productDetail__description");

    public static By PRODUCT_PRICE = new By.ByXPath("//ins[@id='priceNew']");

    public static By PRODUCT_DETAIL_PRICE = By.xpath("//ins[@id='priceNew']");

    public static By ADD_BASKET = By.id("addBasket");

    public static By BEDEN_INFO = new By.ByXPath("//label[@class='m-form__label m-variation__label hasError']");

    public static By BEDEN_SELECT = new By.ByXPath("//span[@class='m-variation__item']");

    public static By PRODUCT_SALE_PAGE_PRICE = new By.ByCssSelector("span.m-productPrice__salePrice");

    public static By MY_BASKET = new By.ByXPath("//a[@class='o-header__userInfo--item bwi-cart-o -cart']");

    public static By PRODUCT_QUANTITY = By.xpath("//option[@value='2']");

    public static By QUANTITY_NUMBER = new By.ByXPath("//select[@class='a-selectControl -small']");

    public static By PRODUCT_BASKET_REMOVE = By.id("removeCartItemBtn0-key-0");

    public static By EMPTY_CART = By.id("emtyCart");
}
