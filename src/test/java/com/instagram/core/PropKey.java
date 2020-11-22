package com.instagram.core;

public enum PropKey {

    URL("url"),
    PORT("port"),
    BROWSER("browser"),
    BROWSER_MANAGER("browserManager"),
    HUB_URL("hubUrl"),

    //Driver Paths
    CHROME_DRIVER_PATH("chromeDriverPath"),
    GECKO_DRIVER_PATH("geckoDriverPath"),

    //Timeouts
    IMPLICIT_WAIT("implicitWait"),
    EXPLICIT_WAIT("explicitWait"),

    //Allure
    ALLURE_REPORT_STEP_LOG("allureReportStepLog"),

    //Screenshot
    SCREEN_SHOT("screenShot"),
    ELEMENT_SCREEN_SHOT("elementScreenShot"),

    //Selenium Grid
    REMOTE("remote");

    private String propVal;

    PropKey(String propVal) {
        this.propVal = propVal;
    }

    public String getPropVal() {
        return propVal;
    }
}
