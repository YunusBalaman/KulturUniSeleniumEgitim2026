package com.kultur.egitim.pages;

import com.kultur.egitim.method.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class ProductPage {

    Logger log = LogManager.getLogger(ProductPage.class);

    Methods methods;

    public ProductPage(){
        this.methods = new Methods();;
    }

    By locationWarning = By.className("onboarding__default-renderer-primary-button");

    By buyNowButton = By.cssSelector("button[data-testid='buy-now-button']");

    By addBasketButton = By.cssSelector("button[data-testid=\"add-to-cart-button\"]");

    By myBasketBy = By.cssSelector("div[data-testid=\"navigation-menu\"] a[title=\"Sepetim\"]");

    By basketCountBy = By.cssSelector("div[data-testid=\"navigation-menu\"] a[title=\"Sepetim\"] div.basket-count");

    By productTitle = By.cssSelector("h1[data-testid=\"product-title\"]");

    By priceBy = By.cssSelector("div[data-testid=\"normal-price\"] , .price-view .discounted");

    // (//span[@data-testid='selected-color'])[2]

    // //section[@data-testId='slider' and .//button[@data-testid="image-box"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Renk']/following-sibling::span[@data-testid="selected-color"]

    By productColor = By.cssSelector("button[data-testid=\"image-box\"]");

    String selectProductColor = "button[data-testid=\"image-box\"][title='%s']";

    By selectedColor = By.xpath("//section[@data-testId='slider' and .//button[@data-testid=\"image-box\"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Renk']/following-sibling::span[@data-testid='selected-color']");

    String newSelectedColor = "//section[@data-testId='slider' and .//button[@data-testid=\"image-box\"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Renk']/following-sibling::span[@data-testid='selected-color'][text()=\"%s\"]";

    By productDisk = By.cssSelector("button[data-testid=\"text-box\"]");

    By selected = By.xpath("//section[@data-testId='slider' and .//button[@data-testid=\"text-box\"]]/preceding-sibling::div//span[@class='slicing-attribute-section-title'][normalize-space(text())='Dahili Hafıza']/following-sibling::span[@data-testid='selected-color']");

    public void clickLocationWarning(){
        methods.click(locationWarning);
    }

    public void verifyProduct(){
        Assertions.assertTrue(methods.isElementVisible(addBasketButton));
        Assertions.assertTrue(methods.isElementVisible(myBasketBy));
        Assertions.assertTrue(methods.isElementVisible(productTitle));
        Assertions.assertTrue(methods.isElementVisible(buyNowButton));
        Assertions.assertTrue(methods.isElementVisible(priceBy));
        Assertions.assertTrue(methods.isElementVisible(productColor));
    }

    public String getSelectedColor(){
        return methods.getText(selectedColor);
    }

    public void verifySelectedColor(String color){
        String colorBy = String.format(newSelectedColor,color);
        Assertions.assertTrue(methods.isElementVisible(By.xpath(colorBy),1));
    }

    public void productColor(){
        methods.findElements(productColor).forEach(element -> log.info(element.getAttribute("title")));
    }

    public String selectRandomColor(){
        List<WebElement> elements = methods.findElements(productColor);
        WebElement element = elements.get(new Random().nextInt(elements.size()));
        String color = element.getAttribute("title");
        By colorBy = By.cssSelector(String.format(selectProductColor,color));
        Assertions.assertTrue(methods.isElementClickable(colorBy));
        methods.click(colorBy);
        return color;
    }

    public String getProductName(){
        return methods.getText(productTitle);
    }

    public String getPrice(){
        return methods.getText(priceBy);
    }

    public void clickAddBasketButton(){
        methods.click(addBasketButton);
    }

    public void clickMyBasketButton(){
        Assertions.assertTrue(methods.isElementVisible(basketCountBy));
        Assertions.assertTrue(methods.isElementClickable(myBasketBy));
        methods.click(myBasketBy);
    }

}
