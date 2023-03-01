package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DriverClass {
    public static WebDriver driver;

    @BeforeClass
    public void startingSettings() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        login();
    }

    void login() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys("techno.batch07@gmail.com");

        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("techno12345");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        loginButton.click();
    }

//    @AfterClass
//    public void finishSettings(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }
}
