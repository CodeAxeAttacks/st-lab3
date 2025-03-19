package org.example.pages;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private WebDriver driver;
    private final String baseUrl = "https://worldoftanks.eu/ru/";

    @BeforeEach
    public void beforeEach() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testUserProfileAfterLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(baseUrl);
        driver.manage().window().maximize();

        // Скролл вниз и вверх
        mainPage.scrollDownWelcomePart();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

        mainPage.goToLogin();
        loginPage.doLogin("fewefw93@gmail.com", "Loshpedik228@");

        // Открываем меню пользователя
        mainPage.openUserWindow();
        mainPage.openUserWindow();
        mainPage.openUserWindow();

        mainPage.goToWorldOfTanksProfile();
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState === 'complete';"));

        // Проверка данных профиля
        assertEquals("228loshpedik228", accountPage.getUsername());
        assertEquals("0", accountPage.getBattleCount());
    }
}