package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class IdentityOnfidoPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Please be ready to provide a photo of your Passport (face photo page) or ID card (front and back)')]")
    public WebElement readyToProvidePhotosMessage;

    @FindBy(xpath = "//span[contains(text(),'Begin Verification')]")
    public WebElement beginVerificationBtn;

    @FindBy(xpath = "//div[contains(text(),'Select the type of document you would like to upload')]")
    public WebElement selectDocumentTypeUploadMessage;

    public void verifyIdentityOnfidoPageDisplay(){
        verifyElementVisible(readyToProvidePhotosMessage);
        Reporter.captureScreenshot("verifyIdentityOnfidoPageDisplay");
    }

    public void clickBeginVerificationBtn(){
        click(beginVerificationBtn);
    }

    public void verifySelectDocumentTypeUploadMessageDiplay(){
        verifyElementVisible(selectDocumentTypeUploadMessage);
    }
}
