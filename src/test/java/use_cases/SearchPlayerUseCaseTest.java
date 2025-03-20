package use_cases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommunityPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SearchPlayerPage;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchPlayerUseCaseTest extends UseCaseTest {

    @Test
    public void searchPlayer() throws InterruptedException {
        for (WebDriver driver : drivers) {
            MainPage mainPage = new MainPage(driver);
            CommunityPage communityPage = new CommunityPage(driver);
            SearchPlayerPage searchPlayerPage = new SearchPlayerPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));

            // Открытие основное страницы
            driver.get(baseUrl);
            driver.manage().window().maximize();
            mainPage.scrollDownWelcomePage();

            // Переход на страницу сообщества
            mainPage.clickCommunityAnchor();

            // Переход на страницу поиска игроков и поиск игрока
            communityPage.clickSearchPlayerAnchor();

            // Смена обработчика окна (открывается новое окно браузера)
            Set<String> handles = driver.getWindowHandles();

            for (String handle : handles) {
                if (!handle.equals(driver.getWindowHandle())) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            searchPlayerPage.doSearch(nickaname);
            WebElement loginAnchor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div[2]/table/tbody/tr/td[1]/a")));
            assertTrue(loginAnchor.isDisplayed());
        }
    }

}
