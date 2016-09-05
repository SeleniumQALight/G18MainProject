package mainPack;

import mainPack.Pages.HomePage;
import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPageValidWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }

    @Test
    //Steps
    public void testLoginPageValidWithPageObject() {
        loginPage.OpenBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());
        loginPage.inputTextIntoLoginField("student").inputTextIntoPassField("909090").clickButtonVdod();
        Assert.assertTrue("Home page was not loaded",homePage.isHomePageLoaded());


    }

    @After
    //Post-Conditions
    public void tearDown() {
        homePage.CloseHomePageAndBrowser();
    }
}
