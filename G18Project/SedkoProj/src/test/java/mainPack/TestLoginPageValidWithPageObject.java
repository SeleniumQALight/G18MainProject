package mainPack;



import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class TestLoginPageValidWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Before
    public void setUp() {

    }

    @Test
    public void testLoginPageValidWithPageObject() {
        loginPage.openBrowserAndOpenPage();
        org.junit.Assert.assertTrue("LoginPage was not Loaded", loginPage.isLoginPageLoad());
        loginPage.inputTextIntoLoginField("student").inputTextIntoPassField("909090").clickButtonVhod();
        Assert.assertTrue("HomePage was loaded",loginPage.isHomePageOpened());
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();
    }
}
