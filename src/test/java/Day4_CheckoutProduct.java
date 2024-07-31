import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day4_CheckoutProduct {
    public WebDriver driver;
    @BeforeTest
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void checkoutTest()  {
        // open link "https://www.saucedemo.com/"
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        //login
        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        //Chọn filter droplist Price (low to high)
        WebElement filter = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        filter.click();
        Select optionPrice = new Select(filter);
        optionPrice.selectByVisibleText("Price (low to high)");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
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
        WebElement titlePro1Cart = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        WebElement btnPro1Cart = driver.findElement(By.id("remove-sauce-labs-onesie"));
        WebElement quantityPro1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']"));
        //check sp1
        if(titlePro1Cart.getText().equalsIgnoreCase(titlePro1Cart.getText())&&btnPro1Cart.getText().equalsIgnoreCase("Remove"))
        {
            System.out.println("Add sp vào gio hang thanh cong");
        }
        //check sp2
        WebElement titlePro2Cart = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        WebElement btnPro2Cart = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        WebElement quantityPro2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']"));
        if(titlePro2Cart.getText().equalsIgnoreCase(titlePro2Cart.getText())&&btnPro2Cart.getText().equalsIgnoreCase("Remove"))
        {
            System.out.println("Add sp vào gio hang thanh cong");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //click check out
        WebElement conShopping = driver.findElement(By.id("checkout"));
        conShopping.click();
        //driver.get("https://www.saucedemo.com/checkout-step-one.html");
        // Nhap firstnam, lastname zipcode
        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("An");
        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.sendKeys("Tran");
        WebElement postalcode = driver.findElement(By.id("postal-code"));
        postalcode.sendKeys("1000");
        //click continue
        WebElement continue2 = driver.findElement(By.id("continue"));
        continue2.click();
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        //expect
        WebElement titlePro1Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        WebElement quantityPro1Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']"));
        WebElement pricePro1Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Onesie']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']"));
        if((titlePro1Cart2.equals(titleProduct1)) || quantityPro1Cart2.equals(quantityPro1) || pricePro1Cart2.equals(priceProduct1)){
            System.out.println("Thông tin san pham 1 đúng");
        }
        WebElement titlePro2Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
        WebElement quantityPro2Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='cart_quantity']"));
        WebElement pricePro2Cart2 = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']/ancestor::div[@class='cart_item']/descendant::div[@class='inventory_item_price']"));
        if(titlePro2Cart2.equals(titleProduct2) && quantityPro2Cart2.equals(quantityPro2) && pricePro2Cart2.equals(priceProduct2)){
            System.out.println(" Thong tin sp 2 đúng");
        }
        //Shipping Information hiển thị đúng "Free Pony Express Delivery!"
        WebElement labelShipInf = driver.findElement(By.xpath("//div[text()='Shipping Information:']"));
        WebElement valueShiInf = driver.findElement(By.xpath("//div[text()='Free Pony Express Delivery!']"));
        if(labelShipInf.isDisplayed() && valueShiInf.isDisplayed()){
            System.out.println("Shipping Information hiển thị đúng 'Free Pony Express Delivery!'");
        }
        //Price Total hiển thị đúng tổng tiền 2 sản phẩm
        float totalPrice;
        totalPrice =  Float.parseFloat(pricePro1Cart2.getText()) + Float.parseFloat(pricePro2Cart2.getText()); // dang mac ở đây
        WebElement lbltotal = driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));
        if(Float.parseFloat(lbltotal.getText())==totalPrice){
            System.out.println("Price Total hiển thị đúng tổng tiền 2 sản phẩm");
        }
        //Total hiển thị đúng tổng tiền của Item total + Tax
        float tax = (float)Math.ceil(totalPrice*0.08);
        float total = totalPrice + tax;
        WebElement lblTotal = driver.findElement(By.xpath("div[@class='summary_subtotal_label']"));
        if(Float.parseFloat(lbltotal.getText())==total){
            System.out.println(" Tổng tiền hiển thị đúng");
        }
        WebElement btnFinish = driver.findElement(By.id("finish"));
        if(btnFinish.isDisplayed()){
            System.out.println("Hiên thi button Finish");
        }
        //Click button Finish , check hiển thị
        btnFinish.click();
        driver.get("https://www.saucedemo.com/checkout-complete.html");
        WebElement completeTitle = driver.findElement(By.xpath("//span[title()='Checkout: Complete!']"));
        WebElement lblThank = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
        WebElement lblInfo = driver.findElement(By.xpath("//div[text()='Your order has been dispatched, and will arrive just as fast as the pony can get there!'"));
        WebElement btnBackHome = driver.findElement(By.id("back-to-products"));
        if(completeTitle.isDisplayed()&&lblThank.isDisplayed()&&lblInfo.isDisplayed()&&btnBackHome.getText().equalsIgnoreCase("Back Home")){
            System.out.println("Màn hình complete hiển thị đúng");
        }





    }
}
