package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openWebsite() throws InterruptedException {
        driver.get("https://chiragkhimani.in/playground/login"); // Load URL
        Thread.sleep(5000); // wait for 5s
    }

    public void doLogin() {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("chirag.automation");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Test@123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-testid='login-button']"));
        loginBtn.click();
    }
}
