package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//a[contains(@href,'register')]")
    public WebElement registerHyperlink;

    public LoginPage clickRegisterHyperlink(){
        click(registerHyperlink);
        return this;
    }
}
