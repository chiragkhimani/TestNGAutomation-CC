package com.automation.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DropDownExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Open Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://www.ebay.com/"); // Load URL

        WebElement dropdown = driver.findElement(By.id("gh-cat"));
        Select dropdownSelect = new Select(dropdown);
        dropdownSelect.selectByVisibleText("Music");
    }
}
