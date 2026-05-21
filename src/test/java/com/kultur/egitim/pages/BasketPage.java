package com.kultur.egitim.pages;

import com.kultur.egitim.method.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class BasketPage {

    Logger log = LogManager.getLogger(BasketPage.class);

    Methods methods;

    public BasketPage() {
        this.methods = new Methods();
    }

    By productBrandNameBy = By.className("product-brand-name");
    By productNameBy = By.className("product-name");
    By priceBy = By.className("basket-product-price-text");

    public void verifyMyBasketPage() {
        Assertions.assertTrue(methods.isElementVisible(productBrandNameBy));
        Assertions.assertTrue(methods.isElementVisible(productNameBy));
        Assertions.assertTrue(methods.isElementVisible(priceBy));
    }

    public String getProductBrandName() {
        return methods.getText(productBrandNameBy);
    }

    public String getProductName() {
        return methods.getText(productNameBy);
    }

    public String getProductPrice() {
        return methods.getText(priceBy);
    }
}
