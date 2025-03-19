package org.example.pages;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class NewsPageTest {

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
    public void doLookOfNewsOfOneCategory() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(baseUrl);
        driver.manage().window().maximize();
        mainPage.scrollDownWelcomePart();

        mainPage.goToNews();
        newsPage.selectCategoryHistory();
        Thread.sleep(1000);

        String latestNewsTitle = newsPage.getLatestNewsTitle();
        System.out.println(latestNewsTitle);
        newsPage.goToLatestNews();

        assertEquals(latestNewsTitle, newsPage.getNewsTitle());
    }

}
