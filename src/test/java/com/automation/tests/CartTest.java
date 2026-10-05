package com.automation.tests;

import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Shopping cart")
public class CartTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp(ITestResult result) {
        if (driver == null) {
            return;
        }
        if (result.getStatus() == ITestResult.FAILURE && driver instanceof TakesScreenshot screenshotDriver) {
            byte[] png = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            Allure.getLifecycle().addAttachment("Failure screenshot", "image/png", "png", png);
        }
        driver.quit();
    }

    @Test
    @Description("Login, add a product, increase quantity — cart badge should show 2")
    @Severity(SeverityLevel.CRITICAL)
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
    @Description("Remove the only line item — empty cart message is shown")
    @Severity(SeverityLevel.NORMAL)
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
    @Description("Decrease quantity to zero — empty cart message is shown")
    @Severity(SeverityLevel.NORMAL)
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
