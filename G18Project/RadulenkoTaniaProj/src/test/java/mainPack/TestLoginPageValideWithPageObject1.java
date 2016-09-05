package mainPack;

import mainPack.Pages.DealPage;
import mainPack.Pages.LoginPage;
import org.jboss.netty.util.internal.DeadLockProofWorker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HomeUser on 8/22/2016.
 */
public class TestLoginPageValideWithPageObject1 {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    DealPage dealPage = new DealPage (driver);

    @Before
    public void setUp(){

    }

    @Test
    public void testLoginPageValideWithPageObject(){
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());

        loginPage.inputTextIntoLoginField("Student").inputTextIntoPassField("909090").clickButtonVhod();
      //  Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());
        Assert.assertTrue("DealPage was not loaded", dealPage.isLogOn());
    }

    @After
    public void tearDown (){
        loginPage.closeLoginPageAndBrowser();
    }
}
