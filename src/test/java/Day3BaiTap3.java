import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class Day3BaiTap3 {
    public WebDriver driver;
    @BeforeTest
    public void before(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://saucelabs.com/request-demo");
        WebElement interestSelbox = driver.findElement(By.xpath("//select[@id='Solution_Interest__c']"));
        interestSelbox.click();
        Thread.sleep(3000);

        ArrayList<String> optionArr = new ArrayList<String>();
        optionArr.add("Select...");
        optionArr.add("Scalable Test Automation");
        optionArr.add("Mobile Application Testing");
        optionArr.add("Replace DIY (In-house) Testing");
        optionArr.add("CI/CD Pipeline Optimization");
        optionArr.add("Visual Testing");
        optionArr.add("Test Orchestration");
        optionArr.add("Debugging");
        optionArr.add("Crash & Error Reporting");
        optionArr.add("Test Analytics");

       ArrayList <WebElement> interestOption = new ArrayList<WebElement>();
        interestOption.add(driver.findElement(By.xpath("//option[@value='']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Scalable Test Automation']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Mobile Application Testing']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Replace DIY (In-house) Testing']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='CI/CD Pipeline Optimization']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Visual Testing']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Test Orchestration']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Debugging']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Crash & Error Reporting']")));
        interestOption.add(driver.findElement(By.xpath("//option[@value='Test Analytics']")));

        for(int i=0; i<optionArr.size();i++){
            for(int j=0; j<=i; j++){

                if(i==j ){
                    String str = interestOption.get(j).getText();
                    System.out.println('\n' + str);
                    if(optionArr.get(i).equalsIgnoreCase(str)) {
                        System.out.println("option "+(i+1)+" đúng");
                        interestOption.get(j).click();
                        Thread.sleep(3000);
                    }
                }
            }
        }

    }
    @AfterTest
    public void after(){
        driver.close();
    }
}
