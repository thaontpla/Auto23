package feature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login2Test {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Thiết lập WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() throws InterruptedException {
        // Mở trang web
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(5000);

        // điều hướng tới đường dẫn khác


        // Nhập thông tin đăng nhập
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        Thread.sleep(3000);
     //   usernameInput.clear();
     //   Thread.sleep(3000);
     //   usernameInput.isEnabled();
     //   Thread.sleep(3000);
     //   WebElement titleText = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
    //    String actualtitleText = titleText.getText();
    //    System.out.print("Text là: " +actualtitleText);
    //    Thread.sleep(3000);
        //div[text()="Swag Labs"]

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        Thread.sleep(3000);

        // Click vào nút đăng nhập
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(3000);

        // Kiểm tra xem đăng nhập thành công hay không bằng cách kiểm tra URL mới
    //    String currentUrl = driver.getCurrentUrl();
    //    System.out.print("url là:"+currentUrl);
    //    Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        driver.navigate().to("https://saucelabs.com/request-demo");
        Thread.sleep(2000);
        WebElement businessEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        businessEmail.sendKeys("dungvu@gmail.com");
        Thread.sleep(5000);

        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("FPT");
        Thread.sleep(3000);

        WebElement phone = driver.findElement(By.xpath("//input[@id='Phone']"));
        phone.sendKeys("0987654321");
        Thread.sleep(3000);

        WebElement selectboxIn = driver.findElement(By.xpath("//select"));
        selectboxIn.click();
        Thread.sleep(1000);
        WebElement selectboxIn2 = driver.findElement(By.xpath("//option[@value='Scalable Test Automation']"));
        selectboxIn2.click();
        Thread.sleep(1000);

        WebElement textare = driver.findElement(By.xpath("//textarea [@id='Sales_Contact_Comments__c']"));
        textare.sendKeys("note text area");
        Thread.sleep(1000);

        WebElement checkBox = driver.findElement(By.xpath("//label[@for='mktoCheckbox_42368_0']"));
        checkBox.click();
        Thread.sleep(1000);

        WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
        submit.click();
        Thread.sleep(1000);



    }



    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
       // driver.quit();
       // driver.close();
    }
}
