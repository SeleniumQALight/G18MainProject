package mainPack;

import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Iris on 22.08.2016.
 */
public class TestLoginPageInvalidWithPageObject {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Test
    public void testLoginPageInvalidWithPageObject() {
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage wasn't loaded", loginPage.isLoginPageLoad());
        //check negative TC
        loginPage.inputTextInLoginField("student").inputTextinPasswordField("").clickButtonVhod();
        Assert.assertTrue("LoginPage wasn't loaded", loginPage.isLoginPageLoad());
    }

    @After
    public void tearDown() {
        loginPage.closeLoginPageAndBrowser();
    }
}
