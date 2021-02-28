package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.helper.Reporter;

public class BusinessEditPage extends BasePage{
    @FindBy(xpath = "//input[@data-cy='register-business-name']")
    public WebElement businessName;

    @FindBy(xpath = "//input[@data-cy='register-business-registration-type']")
    public WebElement registrationType;

    @FindBy(xpath = "//i[contains(@class,'fa-caret-down')]")
    public WebElement dropdownIcon;

    @FindBy(xpath = "//input[@data-cy='register-business-registration-numer']")
    public WebElement businessRegistrationNumber;

    @FindBy(xpath = "//input[@data-cy='register-business-industry']")
    public WebElement industryName;

    @FindBy(xpath = "//input[@data-cy='register-business-sub-industry']")
    public WebElement subIndustryName;

    public void verifyBusinessEditPageDisplay(){
        checkPageIsReady();
        verifyElementVisible(businessName);
        Reporter.captureScreenshot("verifyBusinessEditPageDisplay");
    }

    public void setBusinessName(String businessName){
        setText(this.businessName,businessName);
    }
    public void selectRegistrationType(String registrationType) throws InterruptedException {
        waitForElementVisible(dropdownIcon);
        selectOption(this.registrationType,registrationType);
    }
    public void setBusinessRegistrationNumber(String businessRegistrationNumber){
        setText(this.businessRegistrationNumber,businessRegistrationNumber);
    }
    public void selectIndustry(String industryName) throws InterruptedException {
        selectOption(this.industryName,industryName);
    }
    public void selectSubIndustry(String subIndustryName) throws InterruptedException {
        selectOption(this.subIndustryName,subIndustryName);
    }
}
