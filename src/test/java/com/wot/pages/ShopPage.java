package com.wot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    private WebDriver driver;
    private By firstProduct = By.cssSelector(".product-item:first-child");
    private By addToCartButton = By.cssSelector(".add-to-cart-button");
    private By cartCounter = By.cssSelector(".cart-counter");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstProduct() {
        driver.findElement(firstProduct).click();
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartItemsCount() {
        return driver.findElement(cartCounter).getText();
    }
}
