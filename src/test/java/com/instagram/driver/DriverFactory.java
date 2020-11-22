package com.instagram.driver;

import com.instagram.utils.Helper;
import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import com.instagram.utils.SystemPropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    /**
     * Method to get webdriver
     * @return
     */
    public static WebDriver getDriver() throws IOException {

        if(driver == null) {

            if(Helper.isRemote()) {
                try {
                    driverThreadLocal.set(new RemoteWebDriver(new URL(Helper.getHubUrl()),
                            getBrowser().getBrowserCapabilities()));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }

            driverThreadLocal.set(getBrowser().getWebDriver());
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    /**
     * Method to quit webdriver
     */
    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }


    /**
     * determine browser
     * @return
     */
    private static BrowserType getBrowser() throws IOException {

        BrowserType browserType = SystemPropertyHelper.getBrowserFromSystemVariable();

        if(browserType != null) {
            return browserType;
        }
        if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {
            return BrowserType.FIREFOX;
        } else {
            return BrowserType.CHROME;
        }
    }
}
