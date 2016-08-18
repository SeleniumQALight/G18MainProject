package mainPack;

//import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Created by Iris on 17.08.2016.
 */
public class TestLoginPageValid {
    //new variable with driver
    WebDriver driver = new ChromeDriver();
   // Logger log = Logger.getLogger(getClass());

    @Test
    public void testLoginPageValid(){
        //open window and
        driver.manage().window().maximize();
        //timeout 10 seconds - default seconds will try during 10 sec
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Driver was opened and maximised");

       //navigate to
        driver.get("http://v3.test.itpmgroup.com/login");

        //log.info("Url was opened");
        System.out.println("Url was opened");

        //assert - check smth -> make test pass or fail
        Assert.assertTrue("Assert works", driver.findElement(By.id("password-")).isDisplayed());

        //close
        driver.quit();
        System.out.println("Driver was closed");

    }
}