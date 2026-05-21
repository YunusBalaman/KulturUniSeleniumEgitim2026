package com.kultur.egitim.method;

import com.kultur.egitim.driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> fluentWait;
    long pollingEvery = 300;
    long timeout = 20;
    Actions actions;
    JavascriptExecutor js;

    public Methods(){
        driver = Driver.driver;
        fluentWait = getWait(pollingEvery,timeout);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    public FluentWait<WebDriver> getWait(long pollingEvery,long timeout){
        return new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(pollingEvery))
                .withTimeout(Duration.ofSeconds(timeout))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement findElement(By by){
        return fluentWait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    public void click(By by){
        findElement(by).click();
    }

    public void clickWithStaleElement(By by){
        try {
            findElement(by).click();
        }catch (StaleElementReferenceException e){
            System.out.println(e.getMessage());
            isElementClickable(by);
            findElement(by).click();
        }
    }

    public void sendKeys(By by, String value){
        findElement(by).sendKeys(value);
    }

    public void sendKeys(By by, Keys key){
        findElement(by).sendKeys(key);
    }

    public void clear(By by){
        findElement(by).clear();
    }

    public String getAttribute(By by, String attributeName){
        return findElement(by).getAttribute(attributeName);
    }

    public String getText(By by){
        return findElement(by).getText();
    }

    public boolean isElementVisible(By by){
        try {
            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(By by){
        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isElementClickable(WebElement webElement){
        try {
            fluentWait.until(ExpectedConditions.elementToBeClickable(webElement));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isElementVisible(By by, long timeout){
        try {
            isElementVisible(by,pollingEvery,timeout);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isElementVisible(By by, long pollingEvery, long timeout){
        try {
            getWait(pollingEvery, timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void hoverElement(WebElement webElement) {
        actions.moveToElement(webElement).build().perform();
    }

    public void scrollElement(WebElement webElement){

        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void scrollElementCenter(WebElement webElement){

        js.executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'});",
                webElement);
    }

    public void clickElement(By by){
        Assertions.assertTrue(isElementVisible(by));
        Assertions.assertTrue(isElementClickable(by));
        click(by);
    }

    public void clickJs(WebElement webElement){

        js.executeScript("arguments[0].click();", webElement);
    }

    public String getTextJs(By by){
        return String.valueOf(js.executeScript("return arguments[0].textContent;",findElement(by)));
    }

    public List<String> getAllTabs(){
        return new ArrayList<>(driver.getWindowHandles());
    }

    public void selectTab(int tabNumber){
        List<String> list = getAllTabs();
        driver.switchTo().window(list.get(tabNumber-1));
    }
}
