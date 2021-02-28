package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class IdentityViewPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Please be ready to provide the following documents for identity verification.')]")
    public WebElement readyToProvideDocumentsMessage;

    @FindBy(xpath = "//span[contains(text(),'Get Started')]")
    public WebElement getStartedBtn;

    public void verifyIdentityViewPageDisplay(){
        verifyElementVisible(readyToProvideDocumentsMessage);
        Reporter.captureScreenshot("verifyIdentityViewPageDisplay");
    }

    public void clickGetStartedButton(){
        click(getStartedBtn);
    }
}
