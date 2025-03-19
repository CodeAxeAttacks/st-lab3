package org.example;

import org.example.pages.MainPage;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws Exception{
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        MainPage mainPage = new MainPage(driver);
        driver.get("https://worldoftanks.eu/ru/");
        driver.manage().window().maximize();
        mainPage.scrollDownWelcomePart();
        mainPage.goToLogin();

        driver.quit();
    }
}