package day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_Example {
    /**
     * go to https://opencart.abstracta.us/index.php?route=account/login
     * login
     * email: testngusbatch@gmail.com
     * password: usbatch1234
     * verify that My Account page
     * */

    @Test
    void loginTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement userName =driver.findElement(By.id("input-email"));
        userName.sendKeys("testngusbatch@gmail.com");

        WebElement password=driver.findElement(By.id("input-password"));
        password.sendKeys("usbatch1234");

        WebElement loginButton=driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        WebElement myAccountHeader = driver.findElement(By.xpath("(//div[@id='content']//h2)[1]"));

//        if (myAccountHeader.isDisplayed()){
//            System.out.println(myAccountHeader.getText().equals("My Account"));
//        }

        Assert.assertEquals(myAccountHeader.getText(), "My Account");

        Thread.sleep(3000);
        driver.quit();
    }

}
