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

public class AutoD2Test {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Khởi tạo WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //BAI 2:
    @Test
    public void testBai2()throws InterruptedException {

        // Mở trang web
        driver.get("https://saucelabs.com/request-demo");
        Thread.sleep(2000);

        // Click vào nút gửi mà không nhập bất kỳ thông tin nào
        WebElement textArea = driver.findElement(By.xpath("//textarea[@id='Sales_Contact_Comments__c']"));
        textArea.sendKeys("Linhdaynne");
        Thread.sleep(1000);

        WebElement selectCheckBox = driver.findElement(By.xpath("//input[@id='mktoCheckbox_42368_0']"));
        selectCheckBox.click();
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
        Thread.sleep(1000);



        // Đợi và kiểm tra thông báo lỗi
        WebElement emailError = driver.findElement(By.id("ValidMsgEmail"));
        Assert.assertTrue(emailError.isDisplayed(), "Email error message is not displayed.");
//        Assert.assertEquals(emailError, "Must be valid email. ", "example@yourdomain.com.");

        WebElement businessEmail = driver.findElement(By.xpath("//input[@name='Email']"));
        businessEmail.sendKeys("linhdk2.hebestorm@gmail.com");
        Thread.sleep(1000);

        WebElement submitButton1 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton1.click();
        Thread.sleep(1000);

        WebElement firstNameError = driver.findElement(By.id("ValidMsgFirstName"));
        Assert.assertTrue(firstNameError.isDisplayed(), "First Name error message is not displayed.");
//        String errorMessageFirstName = firstNameError.getText();
//        Assert.assertEquals(errorMessageFirstName, "This field is required.");

        WebElement firstName = driver.findElement(By.xpath("//input[@id ='FirstName']"));
        firstName.sendKeys("Linh");
        Thread.sleep(1000);

        WebElement submitButton2 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton2.click();
        Thread.sleep(1000);

        WebElement lastNameError = driver.findElement(By.id("ValidMsgLastName"));
        Assert.assertTrue(lastNameError.isDisplayed(), "Last Name error message is not displayed.");
//        String errorMessageLastName = firstNameError.getText();
//        Assert.assertEquals(errorMessageLastName, "This field is required.");

        WebElement lastName = driver.findElement(By.xpath("//input[@id ='LastName']"));
        lastName.sendKeys("DK");
        Thread.sleep(1000);

        WebElement submitButton3 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton3.click();
        Thread.sleep(1000);

        WebElement companyError = driver.findElement(By.id("ValidMsgCompany"));
        Assert.assertTrue(companyError.isDisplayed(), "Company error message is not displayed.");
//        String errorMessageCompany = firstNameError.getText();
//        Assert.assertEquals(errorMessageCompany, "This field is required.");
        WebElement company = driver.findElement(By.xpath("//input[@id='Company']"));
        company.sendKeys("Hbs");
        Thread.sleep(1000);

        WebElement submitButton4 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton4.click();
        Thread.sleep(1000);


        WebElement phoneError = driver.findElement(By.id("ValidMsgPhone"));
        Assert.assertTrue(phoneError.isDisplayed(), "Phone error message is not displayed.");
//        String errorMessagePhone = firstNameError.getText();
//        Assert.assertEquals(errorMessagePhone, "Must be a phone number. ","503-555-1212");
        WebElement phone = driver.findElement(By.xpath("//input[@id='Phone']"));
        phone.sendKeys("0987654321");
        Thread.sleep(1000);

        WebElement submitButton5 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton5.click();
        Thread.sleep(1000);

        WebElement countryError = driver.findElement(By.id("ValidMsgCountry"));
        Assert.assertTrue(countryError.isDisplayed(), "Country error message is not displayed.");
//        String errorMessageCountry = countryError.getText();
//        Assert.assertEquals(errorMessageCountry, "This field is required.");
        WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
        country.click();
        WebElement selectCountry = driver.findElement(By.xpath("//option[text()='Japan']"));
        selectCountry.click();
        Thread.sleep(1000);


        WebElement submitButton6 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton6.click();
        Thread.sleep(1000);


        WebElement interestError = driver.findElement(By.id("ValidMsgSolution_Interest__c"));
        Assert.assertTrue(interestError.isDisplayed(), "Interest error message is not displayed.");
//        String errorMessageInterest = countryError.getText();
//        Assert.assertEquals(errorMessageInterest, "This field is required.");
        WebElement interest = driver.findElement(By.xpath("//select[@name='Solution_Interest__c']"));
        interest.click();
        WebElement selectInterest = driver.findElement(By.xpath("//option[text()='Mobile Application Testing ']"));
        selectInterest.click();
        Thread.sleep(3000);

        WebElement submitButton7 = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton7.click();
        Thread.sleep(1000);
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


    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        if (driver != null) {
            driver.quit();
        }
    }

    // Bai 1:
//    @Test
//    public void testLogin() throws InterruptedException {
//        // Mở trang web
//        driver.get("https://www.saucedemo.com/");
//        Thread.sleep(1000);
//
//        // Điều hướng đến trang khác
//        driver.navigate().to("https://saucelabs.com/request-demo");
//        Thread.sleep(1000);
//
//        //Nhập word vào business email
//        WebElement businessEmail = driver.findElement(By.xpath("//input[@name='Email']"));
//        businessEmail.sendKeys("linhdk2.hebestorm@gmail.com");
//        Thread.sleep(1000);
//
//        WebElement firstName = driver.findElement(By.xpath("//input[@id ='FirstName']"));
//        firstName.sendKeys("Linh");
//        Thread.sleep(1000);
//
//        WebElement lastName = driver.findElement(By.xpath("//input[@id ='LastName']"));
//        lastName.sendKeys("DK");
//        Thread.sleep(3000);

    }

