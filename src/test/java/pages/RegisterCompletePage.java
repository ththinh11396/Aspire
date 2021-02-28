package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class RegisterCompletePage extends BasePage{
    @FindBy(xpath = "//p[contains(text(),'You have successfully verified your email. You’re on to a great start!')]")
    public WebElement successMessage;

    @FindBy(xpath = "//button[@type='submit' and not(contains(@disabled,'disabled'))]")
    public WebElement continueBtn;

    public void verifyRegisterCompletePageDisplay(){
        verifyElementVisible(successMessage);
        Reporter.captureScreenshot("verifyRegisterCompletePageDisplay");
    }

    public void clickContinueButton(){
        click(continueBtn);
    }
}
