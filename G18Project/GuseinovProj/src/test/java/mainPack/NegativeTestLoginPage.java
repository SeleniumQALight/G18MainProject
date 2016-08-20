package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NegativeTestLoginPage {

    WebDriver driver = new ChromeDriver();

    @Test

    public void negativeTestLoginPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Window opened and maximized");
        driver.get("http://v3.test.itpmgroup.com/login");
        System.out.println("Url is opened");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Button 'Вход' clicked");
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='login-box-msg']")).isDisplayed());
        System.out.println("We are on login page");
        driver.quit();
        System.out.println("Driver closed");
    }
}
