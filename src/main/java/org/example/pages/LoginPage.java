package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void doLogin(String email, String password) {
        WebElement emailInput = driver.findElement(By.xpath("//*[@id=\"input_email_login\"]"));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"input_password_password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/form/div/fieldset[3]/button"));

        emailInput.clear();
        passwordInput.clear();

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);

        loginButton.click();
    }

    public String getLoginErrorMessage() {
        WebElement loginErrorMessage = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/form/div[1]/div/p"));
        return loginErrorMessage.getText();
    }


}
