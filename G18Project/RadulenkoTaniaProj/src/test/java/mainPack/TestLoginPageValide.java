package mainPack;


import org.apache.commons.logging.impl.Jdk13LumberjackLogger;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestLoginPageValide {
    WebDriver driver = new ChromeDriver ();
    Logger log = Logger.getLogger(getClass());

    @Test
    public void testLoginPageValid () {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver was opened and maximize");

        driver.get("http://v3.test.itpmgroup.com/login");
        System.out.println("Url was opened");

        Assert.assertTrue("Assert works", driver.findElement(By.id("password")).isDisplayed());

        driver.quit();
        System.out.println("Driver was closed");

    }

}
