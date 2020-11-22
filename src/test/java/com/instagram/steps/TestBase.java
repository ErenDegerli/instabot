package com.instagram.steps;

import com.instagram.driver.DriverFactory;
import com.instagram.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase extends DriverFactory {

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeEach
    public void init() throws IOException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
