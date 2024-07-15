import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demo {
    private static WebDriver driver;

    @BeforeClass
    public void login() {
        try {
            FileInputStream file = new FileInputStream("data.xlsx");

            // Tạo một workbook từ FileInputStream
            Workbook workbook = new XSSFWorkbook(file);

            //Lâý sheet đầu tiên từ workbook
            Sheet sheet = workbook.getSheetAt(0);

            // Tạo một DataFormatter để định dạng giá trị ô
            DataFormatter dataFormatter = new DataFormatter();

            // Duyệt qua các dòng trong sheet
            String valueUser = null;
            String valuePass = null;
            for (Row row : sheet) {
                if ((row.getRowNum() == 0)) continue;
                // Lấy giá trị của cột "user" (cột 0) và "pass" (cột 1)
                valueUser = dataFormatter.formatCellValue(row.getCell(0));
                valuePass = dataFormatter.formatCellValue(row.getCell(1));
                break;
            }
            WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            userName.sendKeys(valueUser);

            WebElement passWord = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            passWord.sendKeys(valuePass);

            WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
            loginButton.click();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addProductToCart() {
        WebElement addToCart = driver.findElement(By.xpath("//div[contains(text(),'Test.allTheThings()')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
        addToCart.click();
        WebElement addToCart2 = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]/ancestor::div[@class='inventory_item_description']/descendant::button"));
        addToCart2.click();
    }

    @Test
    public void inputRequestDomeForm() {
        WebElement b1 = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        b1.click();

        WebElement about = driver.findElement(By.xpath("//a[@id='about_sidebar_link']"));
        about.click();

        WebElement requestADemo = driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedDark MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation MuiButton-root MuiButton-outlined MuiButton-outlinedDark MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-disableElevation css-1r365wf']"));
        requestADemo.click();

        //enter value
        try {
            FileInputStream file = new FileInputStream("data.xlsx");

            // Tạo một workbook từ FileInputStream
            Workbook workbook = new XSSFWorkbook(file);

            //Lâý sheet đầu tiên từ workbook
            Sheet sheet2 = workbook.getSheetAt(1);

            // Tạo một DataFormatter để định dạng giá trị ô
            DataFormatter dataFormatter = new DataFormatter();

            String emailValue = null;
            for (Row row1 : sheet2) {
                if (row1.getRowNum() == 0) continue;
                emailValue = dataFormatter.formatCellValue(row1.getCell(1));
                break;
            }
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
            email.sendKeys(emailValue);

            String firstNameValue = null;
            for (Row row2 : sheet2) {
                if (row2.getRowNum() == 0) continue;
                if (row2.getRowNum() == 1) continue;
                firstNameValue = dataFormatter.formatCellValue(row2.getCell(1));
                break;
            }
            WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
            firstName.sendKeys(firstNameValue);

            String lastNameValue = null;
            for (Row row3 : sheet2) {
                if (row3.getRowNum() == 0) continue;
                if (row3.getRowNum() == 1) continue;
                if (row3.getRowNum() == 2) continue;
                lastNameValue = dataFormatter.formatCellValue(row3.getCell(1));
                break;
            }
            WebElement lastName = driver.findElement(By.xpath("//input[@id='FirstName']"));
            firstName.sendKeys(lastNameValue);

            String companyValue = null;
            for (Row row4 : sheet2) {
                if (row4.getRowNum() == 0) continue;
                if (row4.getRowNum() == 1) continue;
                if (row4.getRowNum() == 2) continue;
                if (row4.getRowNum() == 3) continue;
                companyValue = dataFormatter.formatCellValue(row4.getCell(1));
                break;
            }
            WebElement company = driver.findElement(By.xpath("//input[@name='Company']"));
            company.sendKeys(companyValue);

            String phoneValue = null;
            for (Row row5 : sheet2) {
                if (row5.getRowNum() == 0) continue;
                if (row5.getRowNum() == 1) continue;
                if (row5.getRowNum() == 2) continue;
                if (row5.getRowNum() == 3) continue;
                if (row5.getRowNum() == 4) continue;
                phoneValue = dataFormatter.formatCellValue(row5.getCell(1));
                break;
            }
            WebElement phone = driver.findElement(By.xpath("//input[@id='Phone']"));
            phone.sendKeys(phoneValue);

            WebElement selectDropdown = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
            Select oSelector = new Select(selectDropdown);
            oSelector.selectByValue("CI/CD Pipeline Optimization");

            String addComment = null;
            for (Row row6 : sheet2) {
                if (row6.getRowNum() == 0) continue;
                if (row6.getRowNum() == 1) continue;
                if (row6.getRowNum() == 2) continue;
                if (row6.getRowNum() == 3) continue;
                if (row6.getRowNum() == 4) continue;
                if (row6.getRowNum() == 5) continue;
                addComment = dataFormatter.formatCellValue(row6.getCell(1));
                break;
            }
            WebElement comment = driver.findElement(By.xpath("//textarea[@id='Sales_Contact_Comments__c']"));
            comment.sendKeys(addComment);

            List<WebElement> liElement = driver.findElements(By.xpath("//input[@name='sauceLabsContactConsent']"));
            liElement.get(0).click();

            WebElement submit = driver.findElement(By.xpath("//button[@class='mktoButton']"));
            submit.click();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void checkout() {
        try {
            WebElement cartPage = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
            cartPage.click();

            WebElement checkoutPage = driver.findElement(By.xpath("//button[@class='btn btn_action btn_medium checkout_button ']"));
            checkoutPage.click();

            FileInputStream file = new FileInputStream("data.xlsx");

            // Tạo một workbook từ FileInputStream
            Workbook workbook = new XSSFWorkbook(file);

            //Lâý sheet đầu tiên từ workbook
            Sheet sheet3 = workbook.getSheetAt(2);

            // Tạo một DataFormatter để định dạng giá trị ô
            DataFormatter dataFormatter = new DataFormatter();

            String firstNameCustomer = null;
            for (Row row1 : sheet3) {
                if (row1.getRowNum() == 0) continue;
                firstNameCustomer = dataFormatter.formatCellValue(row1.getCell(1));
                break;
            }
            WebElement enterFN = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            enterFN.sendKeys(firstNameCustomer);

            String lastNameCustomer = null;
            for (Row row2 : sheet3) {
                if (row2.getRowNum() == 0) continue;
                if (row2.getRowNum() == 1) continue;
                lastNameCustomer = dataFormatter.formatCellValue(row2.getCell(1));
                break;
            }
            WebElement enterLN = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            enterLN.sendKeys(lastNameCustomer);

            String postCodeValue = null;
            for (Row row3 : sheet3) {
                if (row3.getRowNum() == 0) continue;
                if (row3.getRowNum() == 1) continue;
                if (row3.getRowNum() == 2) continue;
                postCodeValue = dataFormatter.formatCellValue(row3.getCell(1));
                break;
            }
            WebElement enterPC = driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']"));
            enterPC.sendKeys(postCodeValue);

            WebElement placeOrder = driver.findElement(By.xpath("//input[@class='submit-button btn btn_primary cart_button btn_action']"));
            placeOrder.click();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void tearDown() {
        // Đóng trình duyệt
        driver.quit();
    }
}
