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
        //Tut mojno sapisat Pre Condition
    }

    @Test
    //Steps
    public void testLoginPageNotValidWithPageObject() {
        loginPage.OpenBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());
        loginPage.inputTextIntoLoginField("").inputTextIntoPassField("").clickButtonVdod();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());
    }

    @After
    //Post-Conditions
    public void tearDown() {
        loginPage.CloseLoginPageAndWidnow();
    }
}
