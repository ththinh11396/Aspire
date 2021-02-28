package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class BusinessViewPage extends BasePage{
    @FindBy(xpath = "//div[contains(text(),'Business Details')]")
    public WebElement businessDetailTitle;

    @FindBy(xpath = "//span[contains(text(),'Get Started')]")
    public WebElement getStartedBtn;

    public void verifyBusinessViewPageDisplay(){
        verifyElementVisible(businessDetailTitle);
        Reporter.captureScreenshot("verifyBusinessViewPageDisplay");
    }

    public void clickGetStartedButton(){
        click(getStartedBtn);
    }
}
