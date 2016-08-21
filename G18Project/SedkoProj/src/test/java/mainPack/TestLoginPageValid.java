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
        log.info("Driver was opened and maximize");

        driver.get("http://v3.test.itpmgroup.com/login");
        log.info("URL was opened");
        Assert.assertTrue("Assert works",driver.findElement(By.id("password1")).isDisplayed());
        driver.quit();
        log.info("Driver was closed");
    }
}
