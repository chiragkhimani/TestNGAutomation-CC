package com.automation.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FirstClass {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // Open Browser

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://chiragkhimani.in/playground/login"); // Load URL
        Thread.sleep(5000); // wait for 5s

        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("chirag.automation");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Test@123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-testid='login-button']"));
        loginBtn.click();

        WebElement addToCartBtn = driver.findElement(By.xpath("//button[@data-testid='add-to-cart-4']"));
        addToCartBtn.click();

        WebElement cartQty = driver.findElement(By.xpath("//span[@data-testid='cart-badge']"));
        System.out.println(cartQty.getText());

        //driver.quit(); // Close Browser
    }
}
