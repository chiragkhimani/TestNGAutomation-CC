package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void incrementProductQty() {
        WebElement cartIncrementBtn = driver.findElement(By.xpath("//button[@data-testid='cart-increment-4']"));
        cartIncrementBtn.click();
    }

    public String getCartCount() {
        WebElement cartQty = driver.findElement(By.xpath("//span[@data-testid='cart-badge']"));
        System.out.println(cartQty.getText()); // 2
        return cartQty.getText();
    }

    public void clickOnDeleteIcon(){
        WebElement deleteIcon = driver.findElement(By.xpath("//button[@data-testid='cart-remove-4']"));
        deleteIcon.click();
    }

    public void decrementProductQty() {
        WebElement cartDecrementBtn = driver.findElement(By.xpath("//button[@data-testid='cart-decrement-4']"));
        cartDecrementBtn.click();
    }

    public String getCartMessage(){
        WebElement cartMessage = driver.findElement(By.xpath("//div[@data-testid='cart-empty']/p"));
        return cartMessage.getText();
    }
}
