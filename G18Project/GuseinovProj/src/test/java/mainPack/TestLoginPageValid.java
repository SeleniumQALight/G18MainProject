package mainPack;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        log.info("Driver was opened and maximized");
        driver.get("http://v3.test.itpmgroup.com/login");
        log.info("Url Was Opened");
        boolean isDispl;
        try{
            isDispl = driver.findElement(By.id("password")).isDisplayed();
        }catch(NoSuchElementException e){
            isDispl = false;
        }
        Assert.assertTrue("Element was not found on the page!",isDispl);
        driver.findElement(By.name("_username")).sendKeys("student");
        log.info("Email field filled");
        driver.findElement(By.name("_password")).sendKeys("909090");
        log.info("Password field filled");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        log.info("Button 'Вход' clicked");
        boolean isDispl1;
        try{
             isDispl1 = driver.findElement(By.xpath(".//span[@class='hidden-xs']")).isDisplayed();
        }catch(NoSuchElementException e){
            isDispl1 = false;
        }
        Assert.assertTrue("Element was not found on the page!",isDispl1);
        driver.quit();
        log.info("Driver was closed");

    }

}
