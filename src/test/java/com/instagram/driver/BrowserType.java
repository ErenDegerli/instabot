package com.instagram.driver;

import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import com.instagram.utils.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.IOException;

import static com.instagram.utils.Helper.isWebDriverManager;

public enum BrowserType implements DriverSetup {

    CHROME{
        @Override
        public Capabilities getBrowserCapabilities() {
            return getBrowserOptions();
        }

        @Override
        public ChromeOptions getBrowserOptions() {

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("--ignore-certificate-errors");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--incognito");
            //chromeOptions.addArguments("--window-size=1920,1080");
            //chromeOptions.addArguments(("--headless"));
            chromeOptions.setAcceptInsecureCerts(true);

            return chromeOptions;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {

            String browserPath = PropertyReader.getInstance()
                    .getProperty(PropKey.CHROME_DRIVER_PATH.getPropVal());

            //if(isWebDriverManager()) {
            //    WebDriverManager.chromedriver().setup();
            //}else {
                System.setProperty("webdriver.chrome.driver", browserPath);
            //}
            ChromeOptions chromeOptions = getBrowserOptions();
            return new ChromeDriver(chromeOptions);
        }
    },
    FIREFOX{
        @Override
        public Capabilities getBrowserCapabilities() {
            Capabilities capabilities = getBrowserOptions();
            return capabilities;
        }

        @Override
        public FirefoxOptions getBrowserOptions() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            FirefoxProfile firefoxProfile = new FirefoxProfile();

            //Accept Untrusted Certificates
            firefoxProfile.setAcceptUntrustedCertificates(true);
            firefoxProfile.setAssumeUntrustedCertificateIssuer(false);

            //Set firefox profile to capabilities
            firefoxOptions.setCapability(FirefoxDriver.PROFILE, firefoxProfile);

            return firefoxOptions;
        }

        @Override
        public WebDriver getWebDriver() throws IOException {
            String browserPath = PropertyReader.getInstance()
                    .getProperty(PropKey.GECKO_DRIVER_PATH.getPropVal());

            //if(isWebDriverManager()) {
            //    WebDriverManager.firefoxdriver().setup();
            //}else {
                System.setProperty("webdriver.gecko.driver", browserPath);
            //}
            FirefoxOptions firefoxOptions = getBrowserOptions();
            return new FirefoxDriver(firefoxOptions);
        }
    };
}
