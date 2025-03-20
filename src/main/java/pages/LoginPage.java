package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String email, String password) {
        WebElement emailField = driver.findElement(By.id("input_email_login"));
        WebElement passwordField = driver.findElement(By.id("input_password_password"));

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        passwordField.submit();
    }

}
