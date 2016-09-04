package mainPack;


import mainPack.Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestVhodVSlovari {
    WebDriver driver = new ChromeDriver();
    App1 app1 = new App1(driver);


    @Before
    public void setUp() {

    }


    @Test
    public void testVhodVSlovari() {

        app1.loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", app1.loginPage.isLoginPageLoad());

        app1.loginPage.inputTextIntoLoginField("Student").inputTextIntoPassField("909090").clickButtonVhod();
        Assert.assertTrue("Deal Page was not load", app1.dealPage.isLogOn());

        app1.dealPage.findDictionary();
        Assert.assertTrue("Dictionary was not found", app1.dealPage.findDictionary());

        app1.dealPage.clickOnDictionary();
        app1.dealPage.clickOnSubMenuDictionaryAparat();
        app1.apparatPage.clickOnAddApparat();
        app1.apparatEditPage.inputTextIntoApparatNumber("22");
        app1.apparatEditPage.inputTextIntoApparatComment("ApparatAutoTest");
        app1.apparatEditPage.clickOnButtonCreate();
        Assert.assertTrue("Apparat with comment " + "'" + "ApparatAutoTest" + "'" + " was not added",
                app1.apparatPage.isApparatWithCommentPresent("ApparatAutoTest"));


    }

    @After
    public void tearDown() {
        app1.dealPage.closeDealPageAndBrowser();
    }


}