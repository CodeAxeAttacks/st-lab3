package use_cases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.MainPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLocaleUseCaseTest extends UseCaseTest {

    @Test
    public void changeLocale() {
        for (WebDriver driver : drivers) {
            MainPage mainPage = new MainPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));

            // Открытие основное страницы
            driver.get(baseUrl);
            String russianWelcomeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div[1]/p[1]"))).getText();
            assertEquals("ТАНКОВЫЙ ОНЛАЙН-ЭКШЕН", russianWelcomeText);
            driver.manage().window().maximize();
            mainPage.scrollDownWelcomePage();

            // Изменение локали
            mainPage.dropDownLocaleMenu();
            mainPage.selectEnglishLocale();

            String englishWelcomeText =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/section/div[2]/div[1]/p[1]"))).getText();
            assertEquals("ONLINE TANK ACTION", englishWelcomeText);
        }
    }

}
