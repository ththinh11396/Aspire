package test.java.test;

import org.testng.annotations.*;
import test.java.driverFactory.DriverManager;
import test.java.helper.Reporter;

import java.lang.reflect.Method;

public class BaseTest {
    static String browser="";

    @Parameters("browser")
    @BeforeSuite
    public void beforeSuite(@Optional("chrome") String browser){
        this.browser = browser;
        Reporter.createReporter(browser);
    }

    @BeforeMethod
    public void beforeMethod(Method caller){
        String testCaseName = caller.getAnnotation(Test.class).testName();
        Reporter.createTest(testCaseName);
        DriverManager.initWebDriver(browser);
    }

    @AfterMethod
    public void afterMethod(Method caller){
        String testCaseName = caller.getAnnotation(Test.class).testName();
        Reporter.flush();
        DriverManager.closeBrowser();
    }
}
