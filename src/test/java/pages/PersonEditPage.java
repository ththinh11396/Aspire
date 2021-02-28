package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.data.PersonEntity;
import test.java.driverFactory.DriverManager;
import test.java.helper.Reporter;
import java.util.List;

public class PersonEditPage extends BasePage{
    @FindBy(xpath = "//input[@placeholder='Set your date of birth']")
    public WebElement dateOfBirthInput;

    @FindBy(xpath = "//i[contains(@class,'fa-chevron-left')]")
    public WebElement datePickerPreviousButton;

    @FindBy(xpath = "(//div[contains(@class,'q-date__calendar')]//button[contains(@class,'rectangle')])[1]")
    public WebElement datePickerMonthSelect;

    @FindBy(xpath = "(//div[contains(@class,'q-date__calendar')]//button[contains(@class,'rectangle')])[2]")
    public WebElement datePickerYearSelect;

    @FindBy(xpath = "//input[@url='countries/all']")
    public WebElement nationalityDDLInput;

    @FindBy(xpath = "//input[@data-cy='kyc-gender']")
    public WebElement genderDDLInput;

    @FindBy(xpath = "//div[@data-cy='person-edit-purposes']//div[@data-cy='person-edit-purposes']")
    public WebElement interestedProductDDL;

    @FindBy(xpath = "//button[@type='submit' and not(contains(@disabled,'disabled'))]")
    public WebElement submitBtn;

    public void verifyPersonEditPageDisplay(){
        verifyElementVisible(dateOfBirthInput);
        Reporter.captureScreenshot("verifyPersonEditPageDisplay");
    }

    public void clickDateOfBirthInput(){
        click(dateOfBirthInput);
    }

    public void selectNationality(String nationality){
        selectOptionInput(nationalityDDLInput,nationality,nationality);
    }

    public void selectGender(String gender) throws InterruptedException {
        scrollToElement(genderDDLInput);
        selectOption(genderDDLInput,gender);
    }

    public void selectInterestingProduct(List<String> listProduct){
        multiSelectOption(interestedProductDDL,listProduct);
    }

    public WebElement getDatePickerElementContainsText(String text){
        WebElement element = null;
        try {
            element = DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'q-date__view')]//span[text()='" + text + "']"));
        }
        catch (Exception e) {
            //todo
        }
        return element;
    }

    public void selectYear(String expectedYear){
        click(datePickerYearSelect);
        for(int i=0;i<5;i++){
            WebElement expectedYearElement = getDatePickerElementContainsText(expectedYear);
            if(isVisible(expectedYearElement,1)) {
                click(expectedYearElement);
                break;
            }
            else {
                click(datePickerPreviousButton);
            }
        }
    }

    public void selectMonth(String expectedMonth){
       click(datePickerMonthSelect);
       click(getDatePickerElementContainsText(expectedMonth));
    }

    public void selectDay(String expectedDay){
        click(getDatePickerElementContainsText(expectedDay));
    }

    public void selectDateOfBirth(String day,String month,String year){
        clickDateOfBirthInput();
        selectYear(year);
        selectMonth(month);
        selectDay(day);
    }

    public void fillPersonInfo(PersonEntity entity) throws InterruptedException {
        selectDateOfBirth(entity.getDateOfBirthDay(),entity.getDateOfBirthMonth(),entity.getDateOfBirthYear());
        selectNationality(entity.getNationatily());
        selectGender(entity.getGender());
        selectInterestingProduct(entity.getInterestedProduct());
    }

    public void clickSubmitButton(){
        click(submitBtn);
    }
}
