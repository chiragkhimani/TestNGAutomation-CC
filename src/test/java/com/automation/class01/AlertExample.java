package com.automation.class01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Open Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://chiragkhimani.in/playground/login"); // Load URL

        // Login to website
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("chirag.automation");
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Test@123");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@data-testid='login-button']"));
        loginBtn.click();

        WebElement testPageLink = driver.findElement(By.xpath("//a[@data-testid='test-page-link']"));
        testPageLink.click();

        WebElement testAlertBtn = driver.findElement(By.xpath("//button[@data-testid='test-alert-button']"));
        testAlertBtn.click();

        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText()); // Print alert message
        alert1.accept(); // Clicking on ok button
    }
}
