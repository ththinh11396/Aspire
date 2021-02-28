package test.java.test;

import org.testng.annotations.Test;
import test.java.common.Constant;
import test.java.data.PersonEntity;
import test.java.driverFactory.DriverManager;
import test.java.helper.ConfigProperties;
import test.java.helper.Reporter;
import test.java.helper.Ultilities;
import test.java.pages.*;

public class RegisterTest extends BaseTest{

    @Test(testName = "AspireTest")
    public void AspireTest() throws Exception{
        try{
            String businessName = "Company"+ Ultilities.getCurrentTime();
            String registrationType = "Partnership";
            String businessRegistrationNumber = Ultilities.generateNumber(9)+"T";
            String industry = "Manufacturing";
            String subIndustry = "Automotive & Cars";

            LoginPage loginPage = new LoginPage();
            RegiterPage regiterPage = new RegiterPage();
            VerifyOTPPage verifyOTPPage = new VerifyOTPPage();
            RegisterCompletePage registerCompletePage = new RegisterCompletePage();
            IncorporateSelectorPage incorporateSelectorPage = new IncorporateSelectorPage();
            RegisterSelectMethodPage registerSelectMethod = new RegisterSelectMethodPage();
            PersonViewPage personView = new PersonViewPage();
            PersonEditPage personEditPage = new PersonEditPage();
            BusinessViewPage businessViewPage = new BusinessViewPage();
            BusinessEditPage businessEditPage = new BusinessEditPage();
            IdentityViewPage identityViewPage = new IdentityViewPage();
            IdentityOnfidoPage identityOnfidoPage = new IdentityOnfidoPage();

            PersonEntity entity = new PersonEntity();
            entity.createRandomRegisterInfo();

            Reporter.createScenarioNote("1. Registration");
            Reporter.createGivenNote("Go to "+ ConfigProperties.getURL());
            DriverManager.getDriver().navigate().to(ConfigProperties.getURL());

            //1. Registration
            Reporter.createWhenNote("Click on Register hyperlink");
            loginPage.clickRegisterHyperlink();

            Reporter.createThenNote("Register page display");
            regiterPage.verifyRegisterPageDisplay();

            Reporter.createWhenNote("Fill register info");
            regiterPage.fillRegisterInfo(entity);

            Reporter.createWhenNote("Click Continue button");
            regiterPage.clickContinueButton();

            Reporter.createThenNote("Redirect to Verify OTP page");
            verifyOTPPage.verifyOTPPageDisplay();

            //2. Mobile Verification (OTP)
            Reporter.createScenarioNote("2. Mobile Verification (OTP)");

            Reporter.createWhenNote("Set OTP "+ Constant.OTP);
            verifyOTPPage.setOTP();

            Reporter.createThenNote("Redirect to Register Complete page");
            registerCompletePage.verifyRegisterCompletePageDisplay();

            Reporter.createWhenNote("Click Continue button");
            registerCompletePage.clickContinueButton();

            Reporter.createThenNote("Redirect to Incorporate Selector page");
            incorporateSelectorPage.verifyIncorporateSelectorPageDisplay();

            Reporter.createWhenNote("Click Already Have Business Continue");
            incorporateSelectorPage.clickAlreadyHaveBusinessContinueBtn();

            Reporter.createThenNote("Redirect to Register Select Method page");
            registerSelectMethod.verifyRegisterSelectMethodPageDisplay();

            Reporter.createWhenNote("Click Standard Registration Get Started ");
            registerSelectMethod.clickStandardRegistrationGetStartedBtn();

            Reporter.createThenNote("Redirect to Person View page");
            personView.verifyPersonViewPageDisplay();

            Reporter.createScenarioNote("3. Personal Details");
            Reporter.createWhenNote("Click Get Started Button");
            personView.clickGetStartedButton();

            Reporter.createThenNote("Redirect to Person Edit page");
            personEditPage.verifyPersonEditPageDisplay();

            Reporter.createWhenNote("Fill person info");
            personEditPage.fillPersonInfo(entity);

            Reporter.createWhenNote("Click submit button");
            personEditPage.clickSubmitButton();

            Reporter.createThenNote("Redirect to Business View Page");
            businessViewPage.verifyBusinessViewPageDisplay();

            Reporter.createScenarioNote("5. Business Details");
            Reporter.createWhenNote("Click Get Started Button");
            businessViewPage.clickGetStartedButton();

            Reporter.createThenNote("Redirect to Business Edit Page");
            businessEditPage.verifyBusinessEditPageDisplay();

            Reporter.createWhenNote("Fill business info");
            businessEditPage.setBusinessName(businessName);
            businessEditPage.selectRegistrationType(registrationType);
            businessEditPage.setBusinessRegistrationNumber(businessRegistrationNumber);
            businessEditPage.selectIndustry(industry);
            businessEditPage.selectSubIndustry(subIndustry);

            Reporter.createWhenNote("Click submit button");
            personEditPage.clickSubmitButton();

            Reporter.createThenNote("Redirect to Business Edit Page");
            identityViewPage.verifyIdentityViewPageDisplay();

            Reporter.createScenarioNote("6.  Identity Verification");
            Reporter.createWhenNote("Click Get Started Button");
            identityViewPage.clickGetStartedButton();

            Reporter.createThenNote("Redirect to Identity Onfido Page");
            identityOnfidoPage.verifyIdentityOnfidoPageDisplay();

            Reporter.createWhenNote("Click Begin Verification Button");
            identityOnfidoPage.clickBeginVerificationBtn();

            Reporter.createThenNote("Select the type of document you would like to upload message display");
            identityOnfidoPage.verifySelectDocumentTypeUploadMessageDiplay();

        }catch (Exception e){
            Reporter.createFailNote(e.getMessage());
        }
    }
}
