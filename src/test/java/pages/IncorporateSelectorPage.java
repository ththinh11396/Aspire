package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class IncorporateSelectorPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Yes, my business is registered in Singapore with ACRA')]/parent::div/following-sibling::button")
    public WebElement alreadyHaveBusinessContinueBtn;

    @FindBy(xpath = "//span[contains(text(),'I don’t have a business yet')]/parent::div/following-sibling::button")
    public WebElement dontBusinessContinueBtn;

    public void verifyIncorporateSelectorPageDisplay(){
        verifyElementVisible(alreadyHaveBusinessContinueBtn);
        Reporter.captureScreenshot("verifyIncorporateSelectorPageDisplay");
    }

    public void clickAlreadyHaveBusinessContinueBtn(){
        click(alreadyHaveBusinessContinueBtn);
    }
}
