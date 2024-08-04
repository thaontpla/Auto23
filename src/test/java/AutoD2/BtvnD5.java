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
import java.util.List;

public class BtvnD5 {
    public WebDriver driver;
    String user;
    String pass;
    String signInButtonXpath;
    String userNameXpath;
    String passwordXpath;

    @BeforeClass
    public void setUp() {
        // Khởi tạo WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            FileInputStream file = new FileInputStream("Bookkk.xlsx");
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheetAccount = workbook.getSheetAt(0);
            Sheet sheetProduct = workbook.getSheetAt(1);
            DataFormatter dataFormatter = new DataFormatter();


            user = dataFormatter.formatCellValue(sheetAccount.getRow(0).getCell(1));
            pass = dataFormatter.formatCellValue(sheetAccount.getRow(1).getCell(1));

            signInButtonXpath = dataFormatter.formatCellValue(sheetProduct.getRow(1).getCell(1));
            userNameXpath = dataFormatter.formatCellValue(sheetProduct.getRow(2).getCell(1));
            passwordXpath = dataFormatter.formatCellValue(sheetProduct.getRow(3).getCell(1));


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
            Thread.sleep(2000);


            WebElement userName = driver.findElement(By.xpath(userNameXpath));
            userName.sendKeys(user);

            WebElement passWord = driver.findElement(By.xpath(passwordXpath));
            passWord.sendKeys(pass);

            Thread.sleep(3000);

            WebElement login = driver.findElement(By.xpath(signInButtonXpath));
            login.click();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}






