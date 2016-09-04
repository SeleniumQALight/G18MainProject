package mainPack;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Test11 {

    @Test
    public void test1(){
        System.out.println("testOver");
      Assert.assertTrue("This will succeed.", true);
        Assert.assertTrue("This will fail!", false);
    }
}
