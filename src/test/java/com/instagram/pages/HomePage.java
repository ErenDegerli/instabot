package com.instagram.pages;

import com.instagram.core.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {

    @FindBy(css = "input[class='XTCLo x3qfX ']")
    private WebElement searchBox;

    @FindBy(css = "div[class='z556c']")
    private WebElement chooseFirst;

    @FindBy(css = "button[class='_5f5mN       jIbKX  _6VtSN     yZn4P   ']")
    private WebElement followBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void followPage(String pageName) throws InterruptedException {
        //Thread.sleep(500);
        searchBox.sendKeys(pageName);
        Thread.sleep(1000);
        chooseFirst.click();
        Thread.sleep(1000);
        followBtn.click();
    }
}
