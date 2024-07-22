package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public WebDriver driver;

    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void runTest() {
        driver.get("https://www.example.com");
        System.out.println("Title is: " + driver.getTitle());
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
