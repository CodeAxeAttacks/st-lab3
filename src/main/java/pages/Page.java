package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

public abstract class Page {

    protected WebDriver driver;
    protected long waitTimeoutSeconds;

    public Page(WebDriver driver) {
        this.driver = driver;
        setupProperties();
    }

    private void setupProperties() {
        try {
            List<String> properties = Files.readAllLines(Paths.get("src/main/resources/config.properties"));
            for (String property : properties) {
                if (property.startsWith("wait-timeout-seconds")) {
                    this.waitTimeoutSeconds = Long.parseLong(property.split("=")[1]);
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
