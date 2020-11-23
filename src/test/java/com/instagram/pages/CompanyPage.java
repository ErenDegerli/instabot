package com.instagram.pages;

import com.instagram.core.Base;
import org.apache.poi.hssf.record.cf.Threshold;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CompanyPage extends Base {

    @FindBy(css = "div[class='v1Nh3 kIKUG  _bz0w']")
    private List<WebElement> listOfPosts;

    @FindBy(css = "span.fr66n")
    private WebElement likeBtn;

    @FindBy(css = "a[class=' _65Bje  coreSpriteRightPaginationArrow']")
    private WebElement rightBtn;

    public CompanyPage(WebDriver driver) {
        super(driver);
    }

    public void likePosts() throws InterruptedException {
        Thread.sleep(1000);
        scrollToElement(listOfPosts.get(0)).click();
        Thread.sleep(1500);
        likeBtn.click();

        while(rightBtn.isDisplayed()) {
            Thread.sleep(1000);
            rightBtn.click();
            Thread.sleep(1000);
            likeBtn.click();
            if(!rightBtn.isDisplayed()) {
                break;
            }
        }
    }
}
