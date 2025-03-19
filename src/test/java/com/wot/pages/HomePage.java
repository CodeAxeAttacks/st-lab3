package com.wot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By loginButton = By.cssSelector("a[href*='login']");
    private By profileName = By.cssSelector(".user-profile__name");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getProfileName() {
        return driver.findElement(profileName).getText();
    }
}
