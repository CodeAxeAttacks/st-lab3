package org.example.pages;

import org.junit.jupiter.api.*;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginPageTest {

    private WebDriver driver;

    private final String baseUrl = "https://worldoftanks.eu/ru/";

    @BeforeEach
    public void beforeEach() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        firefoxOptions.setImplicitWaitTimeout(Duration.ofSeconds(15));
        driver = new FirefoxDriver(firefoxOptions);
    }

    @AfterEach
    public void afterAll() {
        driver.quit();
    }

    @Test
    public void doCorrectLoginAndLogout() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Переходим на страницу входа
        driver.get(baseUrl);
        driver.manage().window().maximize();
        mainPage.scrollDownWelcomePart();
        mainPage.goToLogin();

        loginPage.doLogin("fewefw93@gmail.com", "Loshpedik228@");

        assertEquals("228loshpedik228", mainPage.getUserLogin());

        // Из-за того, что робот быстро выполняет действия, меню пользователя не открывается (скорее всего, баг сайта)
        mainPage.openUserWindow();
        mainPage.openUserWindow();
        mainPage.openUserWindow();
        mainPage.doLogout();

        assertTrue(mainPage.loginButtonIsDisplayed());
    }

    @Test
    public void doIncorrectLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        // Переходим на страницу входа
        driver.get(baseUrl);
        driver.manage().window().maximize();
        mainPage.scrollDownWelcomePart();
        mainPage.goToLogin();

        loginPage.doLogin("fewefw93@gmail.com", "incorrectPassword");

        assertEquals("Неверный email или пароль.", loginPage.getLoginErrorMessage());
    }

}
