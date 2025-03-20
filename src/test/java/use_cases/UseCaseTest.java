package use_cases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class UseCaseTest {

    protected final String baseUrl = "https://worldoftanks.eu/ru/";
    protected String nickaname = "censored";
    protected String email = "censored";
    protected String password = "censored";
    protected long waitTimeoutSeconds;

    protected List<WebDriver> drivers;

    @BeforeEach
    public void beforeEach() {
        List<WebDriver> drivers = new ArrayList<>();
        try {
            List<String> properties = Files.readAllLines(Paths.get("src/test/resources/config.properties"));
            boolean firefoxDriverIsPresent = false;
            boolean chromeDriverIsPresent = false;
            long waitTimeoutSeconds = 0;
            for (String property : properties) {
                if (property.startsWith("firefox") && property.split("=")[1].equals("true")) {
                    firefoxDriverIsPresent = true;                    
                } else if (property.startsWith("chrome") && property.split("=")[1].equals("true")) {
                    chromeDriverIsPresent = true;
                } else if (property.startsWith("wait-timeout-seconds")) {
                    waitTimeoutSeconds = Long.parseLong(property.split("=")[1]);
                } else if (property.startsWith("nickname")) {
                    nickaname = property.split("=")[1];
                } else if (property.startsWith("email")) {
                    email = property.split("=")[1];
                } else if (property.startsWith("password")) {
                    password = property.split("=")[1];
                }
            }
            if (firefoxDriverIsPresent) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setImplicitWaitTimeout(Duration.ofSeconds(waitTimeoutSeconds));
                drivers.add(new FirefoxDriver(firefoxOptions));
            }
            if (chromeDriverIsPresent) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(waitTimeoutSeconds));
                drivers.add(new ChromeDriver(chromeOptions));
            }
            this.waitTimeoutSeconds = waitTimeoutSeconds;
            this.drivers = drivers;
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    @AfterEach
    public void afterEach() {
        for (WebDriver driver : drivers) {
            driver.quit();
        }
    }

}
