package test.java.common;

import test.java.helper.Ultilities;

public class Constant {
    public static final String CHROME_DRIVER_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/driver/chromedriver.exe";
    public static final String FIREFOX_DRIVER_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/driver/geckodriver.exe";
    public static final String CONFIG_PROPERTIES_PATH = Ultilities.getProjectPath()
            + "/src/test/resources/config/config.properties";
    public static final String OTP = "1234";

    public static final String ROLE_APPOINTED_DIRECTOR = "Appointed director";
    public static final String ROLE_NON_DIRECTOR = "Non-director";

    public static final String PHONE_AREA_CODE_VIETNAM = "Viet Nam (+84)";
    public static final String HEAR_ABOUT_US_FOLLOW = "Referral";

}
