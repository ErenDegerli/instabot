package com.instagram.pages;

import com.instagram.core.Base;
import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(css = "input[name='username']")
    private WebElement username;

    @FindBy(css = "input[name='password']")
    private WebElement password;

    @FindBy(css = "button[class='sqdOP  L3NKy   y3zKF     ']")
    private WebElement submitBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div/div/div[3]/button[2]")
    private WebElement notNowBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void getLoginPage() throws IOException, InterruptedException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal()));
        Thread.sleep(2000);
    }

    public void doLogin() throws IOException, InterruptedException {
        waitUntilClickable(username).sendKeys(PropertyReader.getInstance().getProperty("username"));
        Thread.sleep(1000);
        password.sendKeys(PropertyReader.getInstance().getProperty("password"));
        submitBtn.click();
        Thread.sleep(3000);
        notNowBtn.click();
    }
}
