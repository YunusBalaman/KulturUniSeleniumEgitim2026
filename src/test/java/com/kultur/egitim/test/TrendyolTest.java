package com.kultur.egitim.test;

import com.kultur.egitim.driver.Driver;
import com.kultur.egitim.method.Methods;
import com.kultur.egitim.pages.HomePage;
import com.kultur.egitim.pages.ProductPage;
import org.junit.jupiter.api.Test;

public class TrendyolTest extends Driver {

    HomePage homePage;
    Methods methods;
    ProductPage productPage;

    @Test
    public void test1(){
        homePage = new HomePage();
        methods = new Methods();
        productPage = new ProductPage();
        homePage.verifyHomePage()
        .verifyCookie();
        homePage.verifyGender();
        homePage.clickAcceptCookieButton();
        homePage.clickFemaleGenderButton();
        homePage.clickSearchButton();
        homePage.inputSearch("iphone 17");
        homePage.enter();
        homePage.clickProduct();
        methods.selectTab(2);
        productPage.verifyProduct();
        productPage.clickLocationWarning();
    }
}
