package mainPack;


import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPageNotValidWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Before
    public void setUp() {

    }

    @Test
    public void testLoginPageNotValidWithPageObject() {
        loginPage.openBrowserAndOpenPage();
        org.junit.Assert.assertTrue("LoginPage was not Loaded", loginPage.isLoginPageLoad());

        loginPage.inputTextIntoLoginField("student").inputTextIntoPassField("909091").clickButtonVhod();
        Assert.assertTrue("LoginPage was not loaded",loginPage.isLoginPageLoad());
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();
    }
}
