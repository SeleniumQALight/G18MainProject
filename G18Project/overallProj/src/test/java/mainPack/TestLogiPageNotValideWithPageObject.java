package mainPack;

import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by QALight on 22.08.2016.
 */
public class TestLogiPageNotValideWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp(){

    }

    @Test
    public void testLogiPageNotValideWithPageObject(){
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());

//        loginPage.inputTextInToLoginField("student").inputTextInToPassField("909091").clickButtonVhod();

        Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());

    }

    @After
    public void tearDown(){
//        loginPage.closeLoginPageAndBroser();
    }
}
