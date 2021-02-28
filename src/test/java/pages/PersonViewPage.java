package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class PersonViewPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Person details')]")
    public WebElement personDetailTitle;

    @FindBy(xpath = "//span[contains(text(),'Get Started')]")
    public WebElement getStartedBtn;

    public void verifyPersonViewPageDisplay(){
        verifyElementVisible(personDetailTitle);
        Reporter.captureScreenshot("verifyPersonViewPageDisplay");
    }

    public void clickGetStartedButton(){
        click(getStartedBtn);
    }
}
