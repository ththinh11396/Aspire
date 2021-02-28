package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class RegisterSelectMethodPage extends BasePage{
    @FindBy(xpath = "//span[contains(@class,'content--title') and contains(text(),'MyInfo Registration')]/parent::div/following-sibling::button")
    public WebElement myInfoRegistrationGetStartedBtn;

    @FindBy(xpath = "//span[contains(@class,'content--title') and contains(text(),'Standard Registration')]/parent::div/following-sibling::button")
    public WebElement standardRegistrationGetStartedBtn;

    public void verifyRegisterSelectMethodPageDisplay(){
        verifyElementVisible(standardRegistrationGetStartedBtn);
        Reporter.captureScreenshot("verifyRegisterSelectMethodPageDisplay");
    }

    public void clickStandardRegistrationGetStartedBtn(){
        click(standardRegistrationGetStartedBtn);
    }
}
