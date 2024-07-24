import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day3Baitap2 {
    public WebDriver driver;

    @BeforeTest
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://saucelabs.com/request-demo");
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("dungvu1@gmail.com");
        Thread.sleep(5000);

        WebElement username1 = driver.findElement(By.xpath("//input[@id='FirstName']"));
        username1.sendKeys("Dung");
        Thread.sleep(1000);
        WebElement password1 = driver.findElement(By.xpath("//input[@id='LastName']"));
        password1.sendKeys("Vu");
        Thread.sleep(1000);


        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("CCORP");
        Thread.sleep(1000);
        WebElement phone = driver.findElement(By.id("Phone"));
        phone.sendKeys("0123456789");
        Thread.sleep(1000);
        WebElement country = driver.findElement(By.xpath("//select[@id='Country']"));
        country.click();
        Thread.sleep(1000);
        WebElement selectCountry = driver.findElement(By.xpath("//option[text()='Afghanistan']"));
        selectCountry.click();
        Thread.sleep(5000);
        WebElement interest = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
        interest.click();
        Thread.sleep(1000);
        /*WebElement selectInterest  = driver.findElement(By.xpath("//option[text()='Scalable Test Automation ']"));
        selectInterest.click();
        Thread.sleep(3000);*/


  /*      WebElement comments = driver.findElement(By.xpath("//textarea"));
        comments.sendKeys("Input comments");
        Thread.sleep(3000);*/
        WebElement checkbox = driver.findElement(By.xpath("//label[@for='mktoCheckbox_42368_0']"));
        checkbox.click();
        Thread.sleep(2000);
        WebElement btnsubmit = driver.findElement(By.xpath("//button[@type='submit']"));
        btnsubmit.click();
        Thread.sleep(5000);
/*        WebElement invalidText = driver.findElement(By.xpath("//div[contains(text(),'This field is required.')]"));
        if(invalidText.isDisplayed()){
            System.out.println("Hiển thị thông báo đúng");

        }*/
        String str = "This field is required.";
        WebElement invalidAlert = driver.findElement(By.xpath("//div[@id='ValidMsgSolution_Interest__c']"));
        if(invalidAlert.getText().equalsIgnoreCase(str)){
            System.out.println("Thông bao invalid chính xác : "+str);
        }
    //    Thread.sleep(5000);
    }
    @AfterTest
    public void after() {
        driver.close();

    }
}
