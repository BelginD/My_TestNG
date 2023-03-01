package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_SignupTest {
    /** Go to https://opencart.abstracta.us/index.php?route=account/login
     *  click on My Account
     *  click on Register
     *  fill the form with valid information
     *  accept the agreement
     *  click on continue button
     *  verify that you are signed up
     * */

    @Test
    void signUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.xpath("//a[@title='My Account']")).click();
        driver.findElement(By.xpath("(//*[@id=\"top-links\"]//a)[3]")).click();

        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.id("input-lastname"));
        lastName.sendKeys("Doe");
        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("techno.batch07@gmail.com");
        WebElement phone = driver.findElement(By.id("input-telephone"));
        phone.sendKeys("1234567890");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("techno12345");
        WebElement passwordConfirm = driver.findElement(By.id("input-confirm"));
        passwordConfirm.sendKeys("techno12345");

        driver.findElement(By.name("agree")).click();
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        WebElement successMessage = driver.findElement(By.xpath("(//div[@id='content']//p)[1]"));

        Assert.assertEquals(successMessage.getText(), "Congratulations! Your new account has been successfully created!", "Your test is not passed");

        Thread.sleep(3000);
        driver.quit();
    }

}
