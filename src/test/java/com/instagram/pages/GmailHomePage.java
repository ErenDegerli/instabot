package com.instagram.pages;

import com.instagram.core.Base;
import com.instagram.core.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class GmailHomePage extends Base {

    @FindBy(id = "identifierId")
    private WebElement emailInputArea;

    @FindBy(css = "#identifierNext > div > button > div.VfPpkd-Jh9lGc")
    private WebElement nextBtn;

    public GmailHomePage(WebDriver driver) {
        super(driver);
    }

    public void getGmail() {
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
    }

    public void getLoggedInToGmail() throws IOException {
        waitUntilClickable(emailInputArea).sendKeys(PropertyReader.getInstance().getProperty("gmailUsername"));
        mouseHover(nextBtn);
    }
}
