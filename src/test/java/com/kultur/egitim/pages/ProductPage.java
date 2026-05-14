package com.kultur.egitim.pages;

import com.kultur.egitim.driver.Driver;
import com.kultur.egitim.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    Methods methods;

    public ProductPage(){
        this.methods = new Methods();;
    }

    By locationWarning = By.className("onboarding__default-renderer-primary-button");

    By buyNowButton = By.cssSelector("button[data-testid='buy-now-button']");

    By selectedColor = By.cssSelector("button[data-testid='selected-color']");

    By productColor = By.cssSelector("button[data-testid=\"image-box\"]");

    By selectedColor1 = By.xpath("//section[@data-testId='slider' and .//button[@data-testid=\"image-box\"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Renk']/following-sibling::span[@data-testid='selected-color']");

    By productDisk = By.cssSelector("button[data-testid=\"text-box\"]");

    By selected = By.xpath("//section[@data-testId='slider' and .//button[@data-testid=\"text-box\"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Dahili Hafıza']/following-sibling::span[@data-testid='selected-color']");

    public void clickLocationWarning(){
        methods.click(locationWarning);
    }

    public void verifyProduct(){
        Assertions.assertTrue(methods.isElementVisible(buyNowButton));
    }

    public String getSelectedColor(){
        return methods.getText(selectedColor);
    }


}
