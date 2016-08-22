package mainPack;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NegativeTestLoginPage {

    WebDriver driver = new ChromeDriver();
    Logger log = Logger.getLogger(getClass());

    @Test

    public void negativeTestLoginPage(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Window opened and maximized");
        driver.get("http://v3.test.itpmgroup.com/login");
        log.info("Url is opened");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        log.info("Button 'Вход' clicked");
        boolean  isDispl;
        try{
            isDispl = driver.findElement(By.xpath("//p[@class='login-box-msg']")).isDisplayed();
        }catch(NoSuchElementException e){
            isDispl = false;
        }
        Assert.assertTrue("Element was not found on the page!",isDispl);
        log.info("We are on login page");
        driver.quit();
        log.info("Driver closed");
    }
}
