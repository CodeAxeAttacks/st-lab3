package use_cases;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.MainPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookProfileUseCaseTest extends UseCaseTest {

    @Test
    public void lookProfile() {
        for (WebDriver driver : drivers) {
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));

            // Открытие основное страницы
            driver.get(baseUrl);
            driver.manage().window().maximize();
            mainPage.scrollDownWelcomePage();

            // Переход на страницу входа
            mainPage.clickLoginAnchor();

            // Заполнение формы входа
            loginPage.fillForm(email, password);

            // Проверка пользователя на вход
            WebElement loginSpan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div/span[1]")));
            assertEquals(loginSpan.getText(), nickaname);

            // Открытие дроп-даун меню пользователя и вход в профиль
            mainPage.dropDownUserMenu();
            mainPage.clickWorldOfTanksProfileAnchor();

            assertEquals(nickaname, wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/section[2]/div[2]/div/div[1]/div/div"))).getText());
            assertEquals("0", wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[3]/div[1]/section[3]/div[2]/div/div[2]/div[1]/div[1]"))).getText());
        }
    }

}
