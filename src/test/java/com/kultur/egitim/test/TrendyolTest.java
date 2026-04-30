package com.kultur.egitim.test;

import com.kultur.egitim.driver.Driver;
import com.kultur.egitim.pages.HomePage;
import org.junit.jupiter.api.Test;

public class TrendyolTest extends Driver {

    HomePage homePage;

    @Test
    public void test1(){
        homePage = new HomePage();
        homePage.verifyHomePage()
        .verifyCookie();
        homePage.verifyGender();
        homePage.clickAcceptCookieButton();
        homePage.clickFemaleGenderButton();
        homePage.clickSearchButton();
        homePage.inputSearch("iphone 17");
    }
}
