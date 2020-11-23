package com.instagram.steps;

import com.instagram.driver.DriverFactory;
import com.instagram.pages.CompanyPage;
import com.instagram.pages.GmailHomePage;
import com.instagram.pages.HomePage;
import com.instagram.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestBase extends DriverFactory {

    public WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;
    public CompanyPage companyPage;

    @BeforeEach
    public void init() throws IOException {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        companyPage = new CompanyPage(driver);

    }

    /*@AfterEach
    public void tearDown() {
        driver.quit();
    }*/
}
