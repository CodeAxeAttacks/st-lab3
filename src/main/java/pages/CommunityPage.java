package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommunityPage extends Page {

    public CommunityPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchPlayerAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[4]/div/div/div/div[8]/div[4]/a")));
        element.click();
    }

}
