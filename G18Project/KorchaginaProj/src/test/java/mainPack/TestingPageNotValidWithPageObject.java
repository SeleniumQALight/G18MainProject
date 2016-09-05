package mainPack;

import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestingPageNotValidWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp(){

    }

    @Test
    public void testingPageNotValidWithPageObject() {
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());

        loginPage.inputTextInToLoginField("Student").inputTextInToPassField("123").clickButtonVhod();
    Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());
    }

    @After
    public  void tearDown(){
        loginPage.closeLoginPageAndBrowser();
    }

}
