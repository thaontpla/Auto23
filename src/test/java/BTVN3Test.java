package AutoD2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class BTVN3Test {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Khởi tạo WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testDropdownOptions() throws InterruptedException {

        driver.get("https://saucelabs.com/request-demo");

        WebElement dropdownElement = driver.findElement(By.id("Solution_Interest__c"));

        // Tạo đối tượng Select để thao tác với droplist
        Select dropdown = new Select(dropdownElement);

        // Lấy tất cả các tùy chọn trong droplist
        List<WebElement> options = dropdown.getOptions();

        // Các tùy chọn mong muốn trong droplist
        String[] expectedOptions = {"Scalable Test Automation ", "Mobile Application Testing ", "Replace DIY (In-house) Testing ", "CI/CD Pipeline Optimization ", "Visual Testing ", "Test Orchestration ", "Debugging ", "Crash & Error Reporting ", "Test Analytics "};

        // Kiểm tra xem tất cả các tùy chọn mong muốn có tồn tại trong droplist hay không
        for (String option : expectedOptions) {
            boolean optionFound = false;
            for (WebElement element : options) {
                if (element.getText().equals(option)) {
                    optionFound = true;
                    break;
                }
            }
            Assert.assertTrue(optionFound, "Option " + option + " is not displayed in the dropdown.");
        }


    }


    @AfterClass//ham nay
    public void tearDown() {
        // Đóng trình duyệt
        if (driver != null) {
            driver.quit();
        }
    }
