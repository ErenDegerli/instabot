package com.instagram.steps;

import com.instagram.driver.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Youtube_Test {

    private WebDriver driver1;
    private WebDriver driver2;
    private WebDriver driver3;
    private WebDriver driver4;

    public Youtube_Test() throws IOException {
        driver1 = DriverFactory.getDriver();
        driver2 = DriverFactory.getDriver();
        driver3 = DriverFactory.getDriver();
        driver4 = DriverFactory.getDriver();
    }

    @Test
    public void endlessRefresh() throws InterruptedException {

        driver1.get("https://www.youtube.com/watch?v=sIqJ6C3DCgc&ab_channel=MaxMatrix");
        driver2.get("https://www.youtube.com/watch?v=sIqJ6C3DCgc&ab_channel=MaxMatrix");
        driver3.get("https://www.youtube.com/watch?v=sIqJ6C3DCgc&ab_channel=MaxMatrix");
        driver4.get("https://www.youtube.com/watch?v=sIqJ6C3DCgc&ab_channel=MaxMatrix");

        while(true) {
            Thread.sleep(10000);
            driver1.navigate().refresh();
            driver2.navigate().refresh();
            driver3.navigate().refresh();
            driver4.navigate().refresh();
        }
    }
}
