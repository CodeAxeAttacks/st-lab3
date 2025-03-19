package com.wot.tests;

import com.wot.base.BaseTest;
import com.wot.pages.HomePage;
import com.wot.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonalAccountTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() {
        driver.get("https://worldoftanks.eu/ru/");
        homePage.clickLogin();
        loginPage.login("your_email@example.com", "your_password");
        Assert.assertFalse(homePage.getProfileName().isEmpty(), "Имя профиля не отображается");
    }
}
