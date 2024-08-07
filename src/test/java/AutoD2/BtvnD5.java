package AutoD2;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BtvnD5 {
    public WebDriver driver;
    List<String> information;
    List<String> locators;
    
    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();


        try {
            FileInputStream file = new FileInputStream("Book1.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheetInformation = workbook.getSheetAt(0);
            Sheet sheetLocator = workbook.getSheetAt(1);
            DataFormatter dataFormatter = new DataFormatter();

            // Read information from sheet 1
            information = new ArrayList<>();
            for (Row row : sheetInformation) {
                information.add(dataFormatter.formatCellValue(row.getCell(1)));
            }

            // Read locators from sheet 2
            locators = new ArrayList<>();
            for (Row row : sheetLocator) {
                locators.add(dataFormatter.formatCellValue(row.getCell(1)));
            }

            workbook.close();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

        @Test
    public void testLogin()throws InterruptedException {
// Mở trang web
            driver.get("https://saucelabs.com/request-demo");
            Thread.sleep(5000);

            for (int i = 0; i < locators.size(); i++) {
                WebElement element = driver.findElement(By.xpath(locators.get(i)));
                element.sendKeys(information.get(i));
            }


            WebElement country = driver.findElement(By.xpath("//select[@name='Country']"));
            country.click();
            WebElement selectCountry = driver.findElement(By.xpath("//option[text()='Japan']"));
            selectCountry.click();
            Thread.sleep(1000);

            WebElement interest = driver.findElement(By.xpath("//select[@name='Solution_Interest__c']"));
            interest.click();
            WebElement selectInterest = driver.findElement(By.xpath("//option[text()='Mobile Application Testing ']"));
            selectInterest.click();
            Thread.sleep(3000);

            WebElement selectCheckBox = driver.findElement(By.xpath("//input[@id='mktoCheckbox_42368_0']"));
            selectCheckBox.click();
            Thread.sleep(3000);

            WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
            submitButton.click();
            Thread.sleep(1000);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}








//            WebElement signInButton = driver.findElement(By.);
//            signInButton.click();
//
//            // Chuyển sang cửa sổ mới được mở ra
//            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//            driver.switchTo().window(tabs.get(1));
//
//            // Nhập thông tin đăng nhập ở cửa sổ mới
//            WebElement userName = driver.findElement(By.xpath(userNameXpath));
//            userName.sendKeys(user);
//
//            WebElement passWord = driver.findElement(By.xpath(passwordXpath));
//            passWord.sendKeys(pass);
//
//            // Click nút đăng nhập (nếu có)
//            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
//            loginButton.click();


