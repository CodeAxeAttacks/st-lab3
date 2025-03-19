package org.example.pages;

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

    public void selectCategoryHistory() {
        WebElement categoriesSpan = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]/span[2]/span"));
        WebElement historyRadio = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div/div/div/div[1]/div/div[1]/ul/li[3]/span[2]"));

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        actions.moveToElement(categoriesSpan).perform();
        wait.until(ExpectedConditions.elementToBeClickable(historyRadio));
        actions.moveToElement(historyRadio).click().perform();
    }

    public String getNewsTitle() {
        WebElement newsTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/header/div[2]/div/div/h1"));
        return newsTitle.getText();
    }

    public String getLatestNewsTitle() {
        WebElement newsTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div/div[3]/div[1]/div/a[1]/h2"));
        return newsTitle.getText();
    }

    public void goToLatestNews() {
        WebElement latestNewsTitle = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div/div[3]/div[1]/div/a[1]/h2"));
        latestNewsTitle.click();
    }

}
