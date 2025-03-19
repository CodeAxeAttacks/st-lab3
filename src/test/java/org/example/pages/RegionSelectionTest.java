package org.example.pages;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegionSelectionTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://worldoftanks.eu/ru/";
    private final Duration TIMEOUT = Duration.ofSeconds(15);

    @BeforeEach
    public void setup() {
        ChromeOptions firefoxOptions = new ChromeOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(firefoxOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    @Test
    public void testRegionSelectionFlow() {

        MainPage mainPage = new MainPage(driver);

        driver.get(BASE_URL);

        scrollToBottom();

        mainPage.goToRegionSettings();

        mainPage.chooseNewRegion();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        scrollToBottom();

        mainPage.goToRegionSettings();

        WebElement regionTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div/div[1]")
        ));
        assertEquals("Vyberte region", regionTitle.getText());
    }

    private void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript(
                "window.scrollTo(0, document.body.scrollHeight)"
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}