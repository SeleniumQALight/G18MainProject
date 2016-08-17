package mainPack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class Test1 extends Assert{
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String browser;
    WebDriver driver;

    public Test1(String firstName, String lastName, String email, String password, String browser) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.browser = browser;
    }

    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                { "TesterFname1", "TesterLName1", "email1@email.com", "password" , "iedriver" },
                { "TesterFname1", "TesterLName1", "email1@email.com", "password" , "chrome" },
                { "TesterFname2", "TesterLName2", "email2@email.com", "password" , "opera" },
                 });
    }

    @Test
    public void test1(){

        if ("fireFox".equals(browser)){
            System.out.println("FireFox will be started");
            driver = new FirefoxDriver();
            System.out.println(" FireFox is started");
        } else if ("chrome".equals(browser)){
            System.out.println("Chrome will be started");
            driver = new ChromeDriver();
            System.out.println(" Chrome is started");
        } else if ("iedriver".equals(browser)){
            System.out.println("IE will be started");
            File file = new File("D:/WorkSpaceQaLight/IEDriverServer_x64_2.53.1/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver();
//            driver = new InternetExplorerDriver();
            System.out.println(" IE is started");
        } else if ("opera".equals(browser)){
        System.out.println("Opera will be started");
        driver = new OperaDriver();
        System.out.println(" Opera is started");
    }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qalight.com.ua");
//        try {
//            WebDriver driver = new RemoteWebDriver(
//                    new URL("http://localhost:4444/wd/hub"),
//                    );
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        System.out.println("New test par1 = " + firstName + " , par2 = " + lastName);
        Assert.assertTrue("assert  works", true);
//        assertEquals("Assert works ",firstName,"TesterFname1");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
