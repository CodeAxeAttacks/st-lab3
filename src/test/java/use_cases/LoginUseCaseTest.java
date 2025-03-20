package use_cases;

import org.junit.jupiter.api.Assertions;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginUseCaseTest extends UseCaseTest {

    @Test
    public void doLoginAndLogout() {
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
            WebElement loginSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]/div/span[1]")));
            assertEquals(nickaname, loginSpan.getText());

            // Открытие дроп-даун меню пользователя и выход
            mainPage.dropDownUserMenu();
            mainPage.clickLogoutAnchor();

            // Проверка пользователя на выход
            WebElement loginAnchor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[1]/div/div[1]/div[1]/a[1]")));
            assertTrue(loginAnchor.isDisplayed());
        }
    }

    @Test
    public void doLoginInvalidCredentials() {
        for (WebDriver driver : drivers) {
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = new LoginPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeoutSeconds));

            // Открытие основной страницы
            driver.get(baseUrl);
            driver.manage().window().maximize();
            mainPage.scrollDownWelcomePage();

            // Переход на страницу входа
            mainPage.clickLoginAnchor();

            // Заполнение формы входа
            loginPage.fillForm("InvalidEmail@email.com", "InvalidPassword");

            // Проверка на вывод сообщения об ошибке
            WebElement errorMessageDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/form/div[1]/div")));
            assertTrue(errorMessageDiv.isDisplayed());
        }
    }

}
