package day02;

import Utilities.DriverClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_UpdateNameTest extends DriverClass {
    /** Go to "https://opencart.abstracta.us/index.php?route=account/login"
     * Login
     * Click on Edit Account
     * Update name
     * Click on Continue
     * Verify the success message
     *
     * Than update the name with the old name
     */

    @Test
    void updateNameTest(){
        editName("Johny");
        editName("Jake");
    }

    public void editName(String name){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//
//        WebElement loginEmail = driver.findElement(By.id("input-email"));
//        loginEmail.sendKeys("techno.batch07@gmail.com");
//        WebElement loginPassword = driver.findElement(By.name("password"));
//        loginPassword.sendKeys("techno12345");
//        driver.findElement(By.cssSelector("input[value='Login']")).click();

        WebElement editAccount = driver.findElement(By.xpath("(//aside[@id=\"column-right\"]//a)[2]"));
        editAccount.click();
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.clear();
        firstName.sendKeys(name);
        driver.findElement(By.cssSelector("input[value='Continue']")).click();

        WebElement successMessage = driver.findElement(By.cssSelector("div[class=\"alert alert-success alert-dismissible\"]"));
        Assert.assertEquals(successMessage.getText(), "Success: Your account has been successfully updated.", "Test is not passed");

    }
}
