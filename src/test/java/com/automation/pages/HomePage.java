package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnAddToCartBtn() throws InterruptedException {
        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@data-testid='add-to-cart-4']"));
        addToCartBtn.click();
        Thread.sleep(5000);
    }

    public void clickOnCartPageLink(){
        // Clicking on Cart Link
        WebElement cartLink = driver.findElement(By.xpath("//a[@data-testid='cart-link']"));
        cartLink.click();
    }
}
