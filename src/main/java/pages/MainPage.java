package pages;

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

    public void scrollDownWelcomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/button[1]")));
        element.click();
    }

    public void clickLoginAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]")));
        element.click();
    }

    public void dropDownUserMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div")));
        element.click();
    }

    public void clickLogoutAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[4]/div/div[1]/a")));
        element.click();
    }

    public void clickAllNewsAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div/section[1]/header/a")));
        element.click();
    }

    public void dropDownLocaleMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/a")));
        element.click();
    }

    public void selectEnglishLocale() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[4]/div/div[2]/div[1]/div/div[3]/div[1]/div[2]/a[3]")));
        element.click();
    }

    public void clickCommunityAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/ul/li[6]/div[1]/a")));
        element.click();
    }

    public void clickWorldOfTanksProfileAnchor() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/div[1]/div[1]/div[3]/div/ul/li[1]/a")));
        element.click();
    }

}
