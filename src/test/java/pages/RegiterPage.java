package test.java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.common.Constant;
import test.java.data.PersonEntity;
import test.java.helper.Reporter;

import java.util.List;

public class RegiterPage extends BasePage{

    @FindBy(xpath = "//input[@name='full_name']")
    public WebElement fullNameInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//div[contains(@class,'flag-select')]")
    public WebElement phoneAreaCodeDDL;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneInput;

    @FindBy(xpath = "//div[@aria-label='Appointed director']/div")
    public WebElement roleAppointedDerector;

    @FindBy(xpath = "//div[@aria-label='Non-director']/div")
    public WebElement roleNonDirector;

    @FindBy(xpath = "//input[@data-cy='register-person-heard-about']")
    public WebElement hearAboutUsFollowInput;

    @FindBy(xpath = "//div[contains(@class,'q-item__label')]")
    public List<WebElement> listItem;

    @FindBy(xpath = "//input[@data-cy='register-person-referral-code']")
    public WebElement referralPromoCodeInput;

    @FindBy(xpath = "//div[contains(@class,'register-step-person__privacy')]/div")
    public WebElement agreePrivacyCheckbox;

    @FindBy(xpath = "//button[@type='submit' and not(contains(@disabled,'disabled'))]")
    public WebElement continueBtn;

    public void verifyRegisterPageDisplay(){
        verifyElementVisible(fullNameInput);
        Reporter.captureScreenshot("verifyRegisterPageDisplay");
    }

    public void setFullNameInput(String fullName){
        setText(fullNameInput,fullName);
    }

    public void setEmailInput(String email){
        setText(emailInput,email);
    }

    public void selectPhoneAreaCode(String phoneAreaCode) throws InterruptedException {
        selectOption(phoneAreaCodeDDL,phoneAreaCode);
    }

    public void setPhoneInput(String phone){
        setText(phoneInput,phone);
    }

    public void selectRole(String role){
        if(role.equalsIgnoreCase(Constant.ROLE_APPOINTED_DIRECTOR))
            click(roleAppointedDerector);
        else
            click(roleNonDirector);
    }

    public void selectHearAboutUsFollowOption(String option) throws InterruptedException {
        selectOption(hearAboutUsFollowInput,option);
    }

    public void setReferralPromoCodeInput(String code){
        scrollToElement(referralPromoCodeInput);
        setText(referralPromoCodeInput,code);
    }

    public void clickAgreePrivacyCheckbox() throws InterruptedException {
        click(agreePrivacyCheckbox);
    }

    public void clickContinueButton(){
        click(continueBtn);
    }

    public void fillRegisterInfo(PersonEntity registerEntity) throws InterruptedException {
        setFullNameInput(registerEntity.getFullName());
        setEmailInput(registerEntity.getEmail());
        selectPhoneAreaCode(registerEntity.getPhoneAreaCode());
        setPhoneInput(registerEntity.getPhone());
        selectRole(registerEntity.getRole());
        selectHearAboutUsFollowOption(registerEntity.getHearAboutUsFollow());
        setReferralPromoCodeInput(registerEntity.getReferralPromoCode());
        clickAgreePrivacyCheckbox();
    }
}
