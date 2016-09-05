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

//PRECONDITIONS
        //open window
        driver.manage().window().maximize();
        //timeout 10 seconds - defalt seconds will try during 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver was opened and maximize");

//STEP 1
        //navigate to
        driver.get("http://v3.test.itpmgroup.com/login");
        //log.info ("Url was opened")
        System.out.println("Url was opened");

        //assert - check smth -> make test pass or fail
        Assert.assertTrue("Assert works", driver.findElement(By.id("password")).isDisplayed());
        //System.out.println("You navigate to Login Page");
//STEP 2
        //enter login
        driver.quit();
        System.out.println("Driver was closed");

    }

}
