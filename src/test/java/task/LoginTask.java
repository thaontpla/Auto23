package task;

import org.openqa.selenium.WebDriver;
import ui.LoginPageUI;

public class LoginTask {
    private final LoginPageUI loginPageUI;
    public LoginTask(WebDriver driver) {
        this.loginPageUI = new LoginPageUI(driver);
    }

    public void with(String username, String password) {
        loginPageUI.findUsernameInput().sendKeys(username);
        loginPageUI.findPasswordInput().sendKeys(password);
        loginPageUI.findLoginButton().click();
    }
}
