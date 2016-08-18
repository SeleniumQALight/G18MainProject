package mainPack;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLoginPageValid {

    WebDriver driver = new ChromeDriver();
    Logger log = Logger.getLogger(getClass());

    @Test

    public void testLoginPageValid(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver was opened and maximized");
        driver.get("http://v3.test.itpmgroup.com/login");
        System.out.println("Url Was Opened");
        Assert.assertTrue("Assert works",driver.findElement(By.id("password")).isDisplayed());
        driver.findElement(By.name("_username")).sendKeys("student");
        System.out.println("Email field ready");
        driver.findElement(By.name("_password")).sendKeys("909090");
        System.out.println("Password field ready");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        System.out.println("Button 'Вход' clicked");
        Assert.assertTrue("Test Failed",driver.findElement(By.xpath(".//span[@class='hidden-xs']")).isDisplayed());
        driver.quit();
        //System.out.println("Driver was closed");

    }

}
