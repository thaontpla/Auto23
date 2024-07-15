package feature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task.LoginTask;

public class DemoOrganizeTest {
    private WebDriver driver;
    private LoginTask loginTask;
    @BeforeClass
    public void setUp() {
        // Thiết lập WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginTask = new LoginTask(driver);
        // Mở trang web
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void testLogin() {
        loginTask.with("standard_user", "secret_sauce");
        //expect sau khi login thanh cong
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

