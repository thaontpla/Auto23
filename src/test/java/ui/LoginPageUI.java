package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageUI {
    private final WebDriver driver;

    public LoginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findUsernameInput() {
        return driver.findElement(By.id("user-name"));
    }

    public WebElement findPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement findLoginButton() {
        return driver.findElement(By.id("login-button"));
    }
}
