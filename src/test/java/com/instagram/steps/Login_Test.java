package com.instagram.steps;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Login_Test extends TestBase{


    @Test
    public void getLoginPage() throws IOException, InterruptedException {
        loginPage.getLoginPage();
        loginPage.doLogin();
        homePage.followPage("Degerlipartners");
        companyPage.likePosts();
    }
}
