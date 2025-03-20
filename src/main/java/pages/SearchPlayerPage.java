package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPlayerPage extends Page {

    public SearchPlayerPage(WebDriver driver) {
        super(driver);
    }

    public void doSearch(String nickname) {
        WebElement element = driver.findElement(By.id("account_table_search"));
        element.sendKeys(nickname);
        element.submit();
    }

}
