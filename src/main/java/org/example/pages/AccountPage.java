package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends Page {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public String getUsername() {
        return driver.findElement(
                By.xpath("/html/body/div[1]/div/div[3]/div[1]/section[2]/div[2]/div/div[1]/div/div")
        ).getText();
    }

    public String getBattleCount() {
        return driver.findElement(
                By.xpath("/html/body/div[1]/div/div[3]/div[1]/section[3]/div[2]/div/div[2]/div[1]/div[1]")
        ).getText();
    }
}