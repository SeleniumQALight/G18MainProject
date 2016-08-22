package mainPack;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestLoginPageNegative {
    WebDriver driver = new ChromeDriver();
    Logger log = Logger.getLogger(getClass());
    @Test
    public void testLoginPageValid(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Driver was opened and maximize");

        driver.get("http://v3.test.itpmgroup.com/login");
        log.info("URL was opened");
        driver.findElement(By.name("_username")).sendKeys("student");
        log.info("Login was entered");
        driver.findElement(By.id("password")).sendKeys("909091");
        log.info("Password was entered");
        driver.findElement(By.xpath(".//button[@type='submit']")).click();
        log.info("Button was pressed");
        //Assert.assertTrue("Assert works",driver.findElement(By.id("password1")).isDisplayed());
        driver.quit();
        log.info("Driver was closed");
    }
}

