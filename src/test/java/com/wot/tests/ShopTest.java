package com.wot.tests;

import com.wot.base.BaseTest;
import com.wot.pages.ShopPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest {
    private ShopPage shopPage;

    @BeforeClass
    public void initPages() {
        shopPage = new ShopPage(driver);
    }

    @Test
    public void testAddToCart() {
        driver.get("https://worldoftanks.eu/ru/shop/");
        shopPage.selectFirstProduct();
        shopPage.addToCart();
        Assert.assertEquals(shopPage.getCartItemsCount(), "1", "Товар не добавлен в корзину");
    }
}
