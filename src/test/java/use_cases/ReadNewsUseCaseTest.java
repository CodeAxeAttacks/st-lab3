package use_cases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.NewsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadNewsUseCaseTest extends UseCaseTest {

    @Test
    public void readNews() {
        for (WebDriver driver : drivers) {
            MainPage mainPage = new MainPage(driver);
            NewsPage newsPage = new NewsPage(driver);

            // Открытие основное страницы
            driver.get(baseUrl);
            driver.manage().window().maximize();
            mainPage.scrollDownWelcomePage();

            // Переход на страницу всех новостей
            mainPage.clickAllNewsAnchor();

            // Установка категории
            newsPage.selectHistoryCategory();

            // Просмотр новости
            String news1Title = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div[1]/div/div/div[3]/div[1]/div/a[1]/h2")).getText();
            newsPage.clickLatestNewsAnchor();
            assertEquals(news1Title, driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/header/div[2]/div/div/h1")).getText());
        }
    }

}
