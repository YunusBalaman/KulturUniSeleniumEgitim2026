package com.kultur.egitim.test;

import com.kultur.egitim.driver.Driver;
import com.kultur.egitim.method.Methods;
import com.kultur.egitim.pages.BasketPage;
import com.kultur.egitim.pages.HomePage;
import com.kultur.egitim.pages.ProductPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrendyolTest extends Driver {

    Logger log = LogManager.getLogger(TrendyolTest.class);

    HomePage homePage;
    Methods methods;
    ProductPage productPage;
    BasketPage basketPage;

    @Test
    public void test1(){
        homePage = new HomePage();
        methods = new Methods();
        productPage = new ProductPage();
        basketPage = new BasketPage();
        homePage.verifyHomePage()
        .verifyCookie();
        homePage.verifyGender();
        homePage.clickAcceptCookieButton();
        homePage.clickFemaleGenderButton();
        homePage.clickSearchButton();
        homePage.inputSearch("iphone 17");
        homePage.enter();
        homePage.verifyProduct();
        String brandOnHomePage = homePage.getBrand();
        String nameOnHomePage = homePage.getName();
        String priceOnHomePage = homePage.getPrice();
        log.info(brandOnHomePage + " " + nameOnHomePage + " " + priceOnHomePage);
        homePage.clickProduct();
        methods.selectTab(2);
        productPage.verifyProduct();
        productPage.clickLocationWarning();
        log.info(productPage.getSelectedColor());
        String color = productPage.selectRandomColor();
        productPage.productColor();
        log.info(color);
        productPage.verifySelectedColor(color);
        //Assertions.assertEquals(color,productPage.getSelectedColor());
        String productName = productPage.getProductName();
        String productPrice = productPage.getPrice();
        log.info(productName + " " + productPrice);
        Assertions.assertTrue(productName.contains("Apple iPhone"),productName);
        //Assertions.assertEquals(brandOnHomePage + " " + nameOnHomePage, productName);
        //Assertions.assertEquals(priceOnHomePage, productPrice);
    }

    @Test
    public void test2() throws InterruptedException {
        homePage = new HomePage();
        methods = new Methods();
        productPage = new ProductPage();
        basketPage = new BasketPage();
        homePage.verifyHomePage()
                .verifyCookie();
        homePage.verifyGender();
        homePage.clickAcceptCookieButton();
        homePage.clickFemaleGenderButton();
        homePage.clickSearchButton();
        homePage.inputSearch("iphone 17");
        homePage.enter();
        homePage.verifyProduct();
        String brandOnHomePage = homePage.getBrand();
        String nameOnHomePage = homePage.getName();
        String priceOnHomePage = homePage.getPrice();
        Assertions.assertEquals("Apple", brandOnHomePage);
        homePage.clickProduct();
        methods.selectTab(2);
        productPage.verifyProduct();
        productPage.clickLocationWarning();
        log.info(productPage.getSelectedColor());
        log.info(brandOnHomePage + " " + nameOnHomePage + " " + priceOnHomePage);
        String productName = productPage.getProductName();
        String productPrice = productPage.getPrice();
        log.info(productName + " " + productPrice);
        Assertions.assertEquals(brandOnHomePage + " " + nameOnHomePage, productName);
        Assertions.assertEquals(priceOnHomePage, productPrice);
        productPage.clickAddBasketButton();
        productPage.clickMyBasketButton();
        basketPage.verifyMyBasketPage();
        String brandOnMyBasketPage = basketPage.getProductBrandName();
        String nameOnMyBasketPage = basketPage.getProductName();
        String priceOnMyBasketPage = basketPage.getProductPrice();
        log.info(brandOnMyBasketPage);
        log.info(nameOnMyBasketPage);
        log.info(priceOnMyBasketPage);
        Assertions.assertEquals(brandOnHomePage, brandOnMyBasketPage.trim());
        Assertions.assertEquals(nameOnHomePage, nameOnMyBasketPage);
        Assertions.assertEquals(priceOnHomePage, priceOnMyBasketPage);
        Thread.sleep(2000);
    }
}
