import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Notation_Day6 {
    public WebDriver driver;
    @BeforeClass
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // open link "https://www.saucedemo.com/"
        driver.get("https://www.saucedemo.com/");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //login
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }
    @Test
    public void addtoCard(){
        //Add to cart 2 sản phẩm bất kì
        WebElement addCard1 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        addCard1.click();
        WebElement titleProduct1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        WebElement priceProduct1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']"));

        WebElement addCard2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        addCard2.click();
        WebElement titleProduct2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        WebElement priceProduct2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='inventory_item_description']/descendant::div[@class='inventory_item_price']"));

        //Expect: GIỏ hàng hiển thị số 2
        WebElement numInCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        if(numInCart.getText().equalsIgnoreCase("2")){
            System.out.println("Hiển thị đúng số lượng sp trong cart");
        }
        //Click vào giỏ hàng
        WebElement cart = driver.findElement(By.id("shopping_cart_container"));
        cart.click();
        //Open card check Thông tin Your Cart hiển thị đúng 2 sản phẩm với tên và giá tiền đúng
        driver.get("https://www.saucedemo.com/cart.html");
    }
    @Test
    public void removesp(){
        addtoCard();
        WebElement removebtn = driver.findElement(By.id("remove-sauce-labs-onesie"));
        removebtn.click();
    }
}
