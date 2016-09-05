package mainPack;


import mainPack.Pages.App1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class TestVhodVSlovariWithParameters {
    WebDriver driver = new ChromeDriver();
    App1 app1 = new App1(driver);
    String apparatNumber;
    String apparatComment;

    public TestVhodVSlovariWithParameters(String apparatNumber, String apparatComment){
    this.apparatNumber = apparatNumber;
    this.apparatComment = apparatComment;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"22", "ApparatAutoTest"},
                {"222", "ApparatAutoTest2"}
        });
    }

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
        app1.apparatEditPage.inputTextIntoApparatNumber(apparatNumber);
        app1.apparatEditPage.inputTextIntoApparatComment(apparatComment);
        app1.apparatEditPage.clickOnButtonCreate();
        Assert.assertTrue("Apparat with comment " + "'" + "ApparatAutoTest" + "'" + " was not added",
                app1.apparatPage.isApparatWithCommentPresent("ApparatAutoTest"));


    }

    @After
    public void tearDown() {
        app1.dealPage.closeDealPageAndBrowser();
    }


}