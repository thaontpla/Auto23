package AutoD2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoD2Test {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Thiết lập WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testChuyenTrang() throws InterruptedException {
        // Mở trang web
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);
        driver.navigate().to("https://saucelabs.com/request-demo");
        Thread.sleep(3000);

        //Nhập word vào business email
        WebElement businessEmail = driver.findElement(By.xpath("//input[@name='Email']"));
        businessEmail.sendKeys("linhdk2.hebestorm@gmail.com");
        Thread.sleep(3000);

        WebElement company = driver.findElement(By.name("//input[@name='Company']"));
        company.sendKeys("Hbs");
        Thread.sleep(3000);

        WebElement interest = driver.findElement(By.xpath("//select[@name='Solution_Interest__c']"));
        interest.click();
        WebElement selectInterest = driver.findElement(By.xpath("//option[text()='Mobile Application Testing']"));
        selectInterest.click();
        Thread.sleep(3000);

        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='Sales_Contact_Comments__c']"));
        textArea.sendKeys("Linhdaynne");
        Thread.sleep(3000);

        WebElement selectCheckBox = driver.findElement(By.xpath("//button[@type='submit']"));
        selectCheckBox.click();
        Thread.sleep(3000);

        //button[@type='submit']
    }


    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}
