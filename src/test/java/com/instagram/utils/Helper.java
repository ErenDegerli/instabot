package com.instagram.utils;

import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Helper {

    public static boolean isWebDriverManager() throws IOException {

        if(PropertyReader.getInstance().
                getProperty(PropKey.BROWSER_MANAGER.getPropVal())
                .equalsIgnoreCase("webDriverManager")) {
            return true;
        }

        return false;
    }

    /**
     * method to obtain app url from property file
     * @return
     */
    public static String getAppUrl() throws IOException {
        String baseUrl = PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal());
        String port = PropertyReader.getInstance().getProperty(PropKey.PORT.getPropVal());
        String finalUrl = baseUrl + port;

        return finalUrl;
    }

    public static boolean takeScreenShot(WebDriver driver, String name) throws IOException {
        boolean isScreenShot = PropertyReader.getInstance().getProperty(PropKey.SCREEN_SHOT.getPropVal())
                .equalsIgnoreCase("ENABLE");

        if(isScreenShot) {
            attachScreenShot(driver, name);
            return true;
        }
        return false;
    }

    /**
     * Method to take ScreenShot
     * @param driver
     * @param name
     * @return
     */
    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachScreenShot(WebDriver driver, String name) {

            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    public static synchronized boolean takeElementScreenShot(WebElement element,
                                                             String name) throws IOException {

        String getElementScreenShot = SystemPropertyHelper.getElementScreenShotValue();

        if(getElementScreenShot.equalsIgnoreCase("ENABLE")) {
            attachElementScreenShot(element,name);
            return true;
        }
        return false;
    }

    @Attachment(value = "{name}", type = "image/png")
    private static synchronized byte[] attachElementScreenShot(WebElement element, String name) {
        return element.getScreenshotAs(OutputType.BYTES);
    }

    public static boolean isRemote() throws IOException {
        boolean isRemote = PropertyReader.getInstance().getProperty(PropKey.REMOTE.getPropVal())
                .equalsIgnoreCase("TRUE");

        if(isRemote) {
            return true;
        }
        return false;
    }

    public static String getHubUrl() throws IOException {
        return PropertyReader.getInstance().getProperty(PropKey.HUB_URL.getPropVal());
    }
}