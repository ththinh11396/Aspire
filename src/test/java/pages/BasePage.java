package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import test.java.driverFactory.DriverManager;
import test.java.helper.ConfigProperties;
import test.java.wrapper.WebElementWrapper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BasePage extends WebElementWrapper {
    @FindBy(xpath = "//div[contains(@class,'q-item__label')]")
    public WebElement option;

    public BasePage(){
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public WebElement getOptionContainsText(String text){
        return DriverManager.getDriver().findElement(By.xpath("//div[contains(@class,'q-item__label') and contains(text(),'"+text+"')]"));
    }

    public void waitForListOptionAppear(){
        waitForElementVisible(option);
    }

    public void selectOption(WebElement optionDDL,String option) throws InterruptedException {
        click(optionDDL);
        waitForListOptionAppear();
        click(getOptionContainsText(option));
    }

    public void multiSelectOption(WebElement optionDDL, List<String> listsOption){
        click(optionDDL);
        waitForListOptionAppear();
        for(int i=0;i<listsOption.size();i++)
            click(getOptionContainsText(listsOption.get(i)));
        click(optionDDL);
    }

    public void selectOptionInput(WebElement optionDDL,String optionDDLInput,String option){
        setText(optionDDL,optionDDLInput);
        waitForListOptionAppear();
        click(getOptionContainsText(option));
    }

    public void checkPageIsReady() {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            return;
        }
        for (int i = 0; i < ConfigProperties.getWaitTimeout(); i++) {
            try {
                staticWait(1);
            } catch (InterruptedException ignored) {
            }
            //To check page ready state.
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }


}
