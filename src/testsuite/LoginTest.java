package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/ ";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShopuldLoginSuccessfullyWithvalidCredentials() {

        //Find the Email Field Element
        WebElement userName = driver.findElement(By.id("user-name"));
        // Type the Email address to email field element
        userName.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText().toUpperCase();
        Assert.assertEquals("User not login unsuccessfully", expectedText,actualText);
    }

    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Find the Email Field Element
        WebElement userName = driver.findElement(By.id("user-name"));
        // Type the Email address to email field element
        userName.sendKeys("standard_user");
        //Find the Password Field Element and send password on password field
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        int expectedNumberOfProducts = 6;
        int actualNumberOfProducts = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Different number of products are displayed on the page ",expectedNumberOfProducts,actualNumberOfProducts);
    }

    @After
    public void tearDown() {
        closeBrowser();//CloseBrowser
    }
}