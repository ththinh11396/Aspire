package test.java.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

import java.util.List;

public class VerifyOTPPage extends BasePage{
    @FindBy(xpath = "//div[contains(@class,'verify-otp')]//div[contains(@class,'digit-input__input')]")
    public List<WebElement> listOTPInput;

    @FindBy(xpath = "//div[contains(@class,'verify-otp')]//div[contains(@class,'digit-input__input')]")
    public WebElement OTPInput;

    @FindBy(xpath = "//span[text()='Resend OTP']")
    public WebElement resendOTP;

    public void verifyOTPPageDisplay(){
        verifyElementVisible(resendOTP);
        Reporter.captureScreenshot("verifyOTPPageDisplay");
    }

    public void setOTP() throws Exception {
        setTextAction(Keys.NUMPAD1);
        setTextAction(Keys.NUMPAD2);
        setTextAction(Keys.NUMPAD3);
        setTextAction(Keys.NUMPAD4);
    }
}
