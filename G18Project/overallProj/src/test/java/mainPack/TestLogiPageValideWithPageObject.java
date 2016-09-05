package mainPack;

import mainPack.Pages.HomePage;
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
public class TestLogiPageValideWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Before
    public void setUp(){

    }

    @Test
    public void testLogiPageValideWithPageObject(){
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());
//        loginPage.inputTextInToLoginField("student").inputTextInToPassField("909090").clickButtonVhod();

        Assert.assertTrue("Home page was not loaded", homePage.isHomePageLoaded());


    }

    @After
    public void tearDown(){
//        homePage.closeHomePageAndBrowser();
    }
}
