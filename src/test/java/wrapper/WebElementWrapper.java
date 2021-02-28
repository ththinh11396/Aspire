package test.java.wrapper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.java.driverFactory.DriverManager;
import test.java.helper.ConfigProperties;

public class WebElementWrapper {
    public void  click(WebElement webElement){
        try{
            waitForElementClickable(webElement);
            webElement.click();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForElementClickable(WebElement webElement){
        return waitForElementClickable(webElement,ConfigProperties.getWaitTimeout(),true);
    }

    public WebElement waitForElementClickable(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement waitForElementVisible (WebElement webElement) {
        return waitForElementVisible(webElement, ConfigProperties.getWaitTimeout(), true);
    }

    public WebElement waitForElementVisible(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement waitForElementPresence (WebElement webElement) {
        return waitForElementPresence(webElement, ConfigProperties.getWaitTimeout(), true);
    }

    public WebElement waitForElementPresence(WebElement webElement,long timeout,boolean throwException){
        WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getDriver(), timeout);
        try{
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getByFromElement(webElement)));
        }catch(StaleElementReferenceException staleException){
            webElement = recoverFromStaleElement(webElement);
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(getByFromElement(webElement)));
        }catch (Exception exception){
            if(throwException)
                throw exception;
        }
        return webElement;
    }

    public WebElement recoverFromStaleElement(WebElement webElement) {
        System.out.println("Stale element found(" + webElement + " Recovering...");

        String addressAndLocator = webElement.toString().split("-> ")[1];
        String[] temp = addressAndLocator.split(": ");
        String locator = temp[0];
        String address = temp[1].substring(0, temp[1].length() - 1);

        switch (locator) {
            case "id":
                webElement = DriverManager.getDriver().findElement(By.id(address));
                break;
            case "xpath":
                webElement = DriverManager.getDriver()
                        .findElement(By.xpath(address));
                break;
            case "css selector":
                webElement = DriverManager.getDriver()
                        .findElement(By.cssSelector(address));
                break;
            case "name":
                webElement = DriverManager.getDriver()
                        .findElement(By.name(address));
                break;
            default:
                System.out.println("WebElement Issue");
        }

        return webElement;
    }

    public void setText(WebElement webElement,String text,boolean isClear){
        try {
            waitForElementVisible(webElement);
            if(isClear)
                webElement.clear();
            webElement.sendKeys((CharSequence)text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public By getByFromElement(WebElement webElement) {
        By by = null;
        String addressAndLocator = webElement.toString().split("-> ")[1];
        String[] temp = addressAndLocator.split(": ");
        String locator = temp[0];
        String address = temp[1].substring(0, temp[1].length() - 1);

        switch (locator) {
            case "id":
                by = By.id(address);
                break;
            case "class name":
                by = By.className(address);
                break;
            case "xpath":
                by = By.xpath(address);
                break;
            case "css selector":
                by = By.cssSelector(address);
                break;
            case "name":
                by = By.name(address);
                break;
            case "linkText":
                by = By.linkText(address);
                break;
            case "partialLinkText":
                by = By.partialLinkText(address);
                break;
            default:
                System.out.println("Locator "+ locator + " not found");
        }
        return by;
    }

    public void setTextWithoutClear(WebElement webElement,String text){
        setText(webElement,text,false);
    }

    public void setText(WebElement webElement,String text){
        setText(webElement,text,true);
    }

    public WebElement getElementContainsText(String text){
        return DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
    }

    public void scrollToElement(WebElement webElement){
        waitForElementPresence(webElement);
        try {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isVisible(WebElement webElement){
        boolean visible;
        try{
            waitForElementVisible(webElement);
            visible = true;
        }catch (Exception e){
            visible = false;
        }
        return visible;
    }

    public boolean isVisible(WebElement webElement,long timeout){
        boolean visible;
        try{
            waitForElementVisible(webElement,timeout,true);
            visible = true;
        }catch (Exception e){
            visible = false;
        }
        return visible;
    }

    public void verifyElementVisible(WebElement webElement){
        boolean visible = isVisible(webElement);
        Assert.assertTrue(visible);
    }

    public static void setTextAction(WebElement webElement,String string){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(webElement,string);
    }

    public static void setTextAction(CharSequence charSequence){
        Actions actions = new Actions(DriverManager.getDriver());
        actions.sendKeys(charSequence).build().perform();
    }

    public static void staticWait(long seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }
}
