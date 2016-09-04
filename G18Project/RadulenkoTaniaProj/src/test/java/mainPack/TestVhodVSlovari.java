package mainPack;


import mainPack.Pages.ApparatEditPage;
import mainPack.Pages.ApparatPage;
import mainPack.Pages.DealPage;
import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by HomeUser on 8/27/2016.
 */
public class TestVhodVSlovari {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    DealPage dealPage = new DealPage(driver);
    ApparatPage apparatPage = new ApparatPage(driver);
    ApparatEditPage apparatEditPage = new ApparatEditPage(driver);


    @Before
    public void setUp() {

    }


    @Test
    public void testVhodVSlovari() {

        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());

        loginPage.inputTextIntoLoginField("Student").inputTextIntoPassField("909090").clickButtonVhod();
        Assert.assertTrue("Deal Page was not load", dealPage.isLogOn());

        dealPage.findDictionary();
        Assert.assertTrue("Dictionary was not found", dealPage.findDictionary());

        dealPage.clickOnDictionary();
        dealPage.clickOnSubMenuDictionaryAparat();
        apparatPage.clickOnAddApparat();
        apparatEditPage.inputTextIntoApparatNumber("22");
        apparatEditPage.inputTextIntoApparatComment("ApparatAutoTest");
        apparatEditPage.clickOnButtonCreate();
        Assert.assertTrue("Apparat with comment " + "'" + "ApparatAutoTest" + "'" + " was not added",
                apparatPage.isApparatWithCommentPresent("ApparatAutoTest"));


        


    }

    @After
    public void tearDown() {
        dealPage.closeDealPageAndBrowser();
    }


}