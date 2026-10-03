package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver(); // Open Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void verifyCartCount() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.doLogin();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnAddToCartBtn();
        homePage.clickOnCartPageLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.incrementProductQty();
        Assert.assertEquals(cartPage.getCartCount(), "2");
    }

    @Test
    public void verifyCartEmptyMsgAfterDeletingItemFromCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.doLogin();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnAddToCartBtn();
        homePage.clickOnCartPageLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnDeleteIcon();
        Assert.assertEquals(cartPage.getCartMessage(), "Your cart is empty");
    }

    @Test
    public void verifyCartEmptyMsgAfterDecrementItemQty() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsite();
        loginPage.doLogin();

        HomePage homePage = new HomePage(driver);
        homePage.clickOnAddToCartBtn();
        homePage.clickOnCartPageLink();

        CartPage cartPage = new CartPage(driver);
        cartPage.decrementProductQty();
        Assert.assertEquals(cartPage.getCartMessage(), "Your cart is empty");
    }

}
