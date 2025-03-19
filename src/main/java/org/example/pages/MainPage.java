package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Если открывать в полноэкранном режиме, то нужно свайпнуть вниз, чтобы открылась основная страница
    public void scrollDownWelcomePart() {
        WebElement scrollDownButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/button[1]"));
        scrollDownButton.click();
    }

    public void goToLogin() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]"));
        loginButton.click();
    }

    public String getUserLogin() {
        WebElement userLoginSpan = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div/span[1]"));
        return userLoginSpan.getText();
    }

}
