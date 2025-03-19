package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends Page {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    // Если открывать в полноэкранном режиме, то нужно свайпнуть вниз, чтобы открылась основная страница
    public void scrollDownWelcomePart() {
        WebElement scrollDownButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/button[1]"));
        scrollDownButton.click();
    }

    public boolean loginButtonIsDisplayed() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return loginButton.isDisplayed();
    }

    public void goToLogin() {
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]"));
        loginButton.click();
    }

    public String getUserLogin() {
        WebElement userLoginSpan = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div/span[1]"));
        return userLoginSpan.getText();
    }

    public void openUserWindow() {
        WebElement userLoginSpan = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div/span[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(userLoginSpan));
        userLoginSpan.click();
    }

    public void doLogout() {
        WebElement logoutButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[4]/div/div[1]/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();
    }

    public void goToNews() {
        WebElement readAllAnchor = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/header/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(readAllAnchor));
        readAllAnchor.click();
    }

    public void goToWorldOfTanksProfile() {
        WebElement worldOfTanksProfileAnchor = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[3]/div/ul/li[1]/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(worldOfTanksProfileAnchor));
        worldOfTanksProfileAnchor.click();
    }

    public void goToRegionSettings() {
        WebElement regionSettings = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/a"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(regionSettings));
        regionSettings.click();
    }

    public void chooseNewRegion() {
        WebElement europeRegion = driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div/div[3]/div[1]/div[2]/a[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(europeRegion));
        europeRegion.click();
    }
}
