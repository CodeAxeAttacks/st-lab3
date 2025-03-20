package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewsPage extends Page {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public void selectHistoryCategory() {
        WebElement filtersDiv = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div[1]/div"));
        Actions action = new Actions(driver);
        action.moveToElement(filtersDiv).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement historyOptionSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]/ul/li[3]/span[2]")));
        action.moveToElement(historyOptionSpan).click().moveToLocation(0, 0).perform();
    }

    public void clickLatestNewsAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div/div[3]/div[1]/a")));
        Actions action = new Actions(driver);
        action.moveToElement(element).click().perform();
    }


}
