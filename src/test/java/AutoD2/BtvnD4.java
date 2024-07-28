package AutoD2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BtvnD4 {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Khởi tạo WebDriver (trình duyệt Chrome)
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void testLink()throws InterruptedException {

        // Mở trang web
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);

        WebElement userName = driver.findElement(By.xpath("//input[@id = 'user-name']"));
        userName.sendKeys("standard_user");

        WebElement passWord = driver.findElement(By.xpath("//input[@id = 'password']"));
        passWord.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(3000);

        WebElement droplist = driver.findElement(By.xpath("//select[@class = 'product_sort_container']"));
        droplist.click();
        Select option = new Select(droplist);
        option.selectByValue("lohi");
        Thread.sleep(2000);

        WebElement addButton1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']/ancestor::div[@class='inventory_item_label']/following-sibling::div/descendant::button"));
        addButton1.click();
        Thread.sleep(2000);

        WebElement addButton2 = driver.findElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']/ancestor::div[@class='inventory_item_label']/following-sibling::div/descendant::button"));
        addButton2.click();
        Thread.sleep(2000);

        // Kiểm tra số lượng sản phẩm trong giỏ hàng
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement cartCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='shopping_cart_badge']")));
        String cartCount = cartCountElement.getText();

        if (cartCount.equals("2")) {
            System.out.println("Test passed: The cart shows 2 items.");
        } else {
            System.out.println("Test failed: The cart shows " + cartCount + " items.");
        }

        WebElement clickCart = driver.findElement(By.id("shopping_cart_container"));
        clickCart.click();
        Thread.sleep(2000);

        //Expect 1: Thông tin Your Cart hiển thị đúng 2 sản phẩm với tên và giá tiền đúng
        WebDriverWait waitCart = new WebDriverWait(driver, Duration.ofSeconds(2));
        List<WebElement> cartItems = waitCart.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".cart_item")));

        if (cartItems.size() == 2) {
            System.out.println("Test passed: The cart contains 2 items.");
        } else {
            System.out.println("Test failed: The cart contains " + cartItems.size() + " items.");
        }

        for (WebElement item : cartItems) {
            WebElement itemName = item.findElement(By.cssSelector(".inventory_item_name"));
            WebElement itemPrice = item.findElement(By.cssSelector(".inventory_item_price"));

            System.out.println("Item: " + itemName.getText() + ", Price: " + itemPrice.getText());

            if (itemName.getText().equals("Sauce Labs Bolt T-Shirt") && itemPrice.getText().equals("$15.99")) {
                System.out.println("Test passed: Item 1 details are correct.");
            } else if (itemName.getText().equals("Test.allTheThings() T-Shirt (Red)") && itemPrice.getText().equals("$15.99")) {
                System.out.println("Test passed: Item 2 details are correct.");
            } else {
                System.out.println("Test failed: Item details are incorrect.");
            }
        }

        // Expect 2: Màn hình có hiển thị 2 button Remove
        List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text()='Remove']"));
        if (removeButtons.size() == 2) {
            System.out.println("Test passed: The screen displays 2 Remove buttons.");
        } else {
            System.out.println("Test failed: The screen displays " + removeButtons.size() + " Remove buttons.");
        }


    WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
        Thread.sleep(3000);

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Linh");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("DK");

        WebElement zipCode = driver.findElement(By.id("postal-code"));
        zipCode.sendKeys("100000");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        Thread.sleep(3000);


        //Expect 1: Thông tin Description hiển thị đúng 2 sản phẩm với số lượng, tên và giá tiền đúng
    List<WebElement> descriptionItems = driver.findElements(By.cssSelector(".cart_item"));
     if (descriptionItems.size() == 2) {
        System.out.println("Test passed: Description contains 2 items.");
    } else {
        System.out.println("Test failed: Description contains " + descriptionItems.size() + " items.");
    }

        for (WebElement item : descriptionItems) {
        WebElement itemQuantity = item.findElement(By.cssSelector(".cart_quantity"));
        WebElement itemName = item.findElement(By.cssSelector(".inventory_item_name"));
        WebElement itemPrice = item.findElement(By.cssSelector(".inventory_item_price"));

        System.out.println("Quantity: " + itemQuantity.getText() + ", Item: " + itemName.getText() + ", Price: " + itemPrice.getText());

        if (itemName.getText().equals("Sauce Labs Bolt T-Shirt") && itemPrice.getText().equals("$15.99") && itemQuantity.getText().equals("1")) {
            System.out.println("Test passed: Item 1 details are correct.");
        } else if (itemName.getText().equals("Test.allTheThings() T-Shirt (Red)") && itemPrice.getText().equals("$15.99") && itemQuantity.getText().equals("1")) {
            System.out.println("Test passed: Item 2 details are correct.");
        } else {
            System.out.println("Test failed: Item details are incorrect.");
        }
    }

        //Expect 2: Shipping Information hiển thị đúng "Free Pony Express Delivery!"
        WebElement shippingInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'summary_info']/descendant::div[text() = 'Free Pony Express Delivery!']")));

        if (shippingInfo.getText().equals("Free Pony Express Delivery!")) {
            System.out.println("Test passed: Shipping Information displays correctly.");
        } else {
            System.out.println("Test failed: Shipping Information does not display correctly.");
        }

        // Expect 5: Button Finish hiển thị
    WebElement checkFinishButton = driver.findElement(By.id("finish"));
        if (checkFinishButton.isDisplayed()) {
        System.out.println("Test passed: Finish button is displayed.");
    } else {
        System.out.println("Test failed: Finish button is not displayed.");
    }

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();
        Thread.sleep(3000);

        // Expect 1 : hiển thị "Checkout: Complete!"
        WebElement checkoutComplete = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'title']")));

        if (checkoutComplete.getText().equals("Checkout: Complete!")) {
            System.out.println("Test passed: Checkout: Complete! displays correctly.");
        } else {
            System.out.println("Test failed: Checkout: Complete! does not display correctly.");
        }

        // Expect 2 : hiển thị "Thank you for your order!"
        WebElement completeHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class = 'complete-header']")));

        if (completeHeader.getText().equals("Thank you for your order!")) {
            System.out.println("Test passed: Complete Header displays correctly.");
        } else {
            System.out.println("Test failed: Complete Header does not display correctly.");
        }

        // Expect 3 : hiển thị "Your order has been dispatched, and will arrive just as fast as the pony can get there!"
        WebElement completeText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'complete-text']")));

        if (completeText.getText().equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!")) {
            System.out.println("Test passed: Complete Text displays correctly.");
        } else {
            System.out.println("Test failed: Complete Text does not display correctly.");
        }

        // Expect 4 : hiển thị button Back Home
        WebElement backHomeButton = driver.findElement(By.id("back-to-products"));
        if (backHomeButton.isDisplayed()) {
            System.out.println("Test passed: Finish button is displayed.");
        } else {
            System.out.println("Test failed: Finish button is not displayed.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
