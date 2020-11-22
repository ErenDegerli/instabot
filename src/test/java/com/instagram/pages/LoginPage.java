package com.instagram.pages;

import com.instagram.core.Base;
import com.instagram.core.PropKey;
import com.instagram.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends Base {

    @FindBy(css = "")
    private WebElement username;

    @FindBy(css = "")
    private WebElement password;

    @FindBy(css = "")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void getLoginPage() throws IOException {
        driver.get(PropertyReader.getInstance().getProperty(PropKey.URL.getPropVal()));
    }
}
