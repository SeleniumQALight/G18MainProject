package mainPack;


import mainPack.Pages.App1;
import org.apache.log4j.Logger;
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
public class AddNewSpare {
    WebDriver driver = new ChromeDriver();
    App1 app1 = new App1(driver);
    Logger log;
    String spareName;
    String spareType;

    public AddNewSpare(String spareName, String spareType) {
        this.spareName = spareName;
        this.spareType = spareType;
        log = Logger.getLogger(getClass());
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"testName", "Механика"},
        });
    }

    @Before
    public void setUp() {

    }


    @Test
    public void addNewSpare() {
        app1.loginPage.openBrowserAndLoginPage();
        log.info("Login page was opened");
        Assert.assertTrue("LoginPage was not loaded", app1.loginPage.isLoginPageLoad());

        app1.loginPage.inputTextIntoLoginField("Student").inputTextIntoPassField("909090").clickButtonVhod();
//        log.info("Deal Page was load");
        Assert.assertTrue("Deal Page was not load", app1.dealPage.isLogOn());

        app1.dealPage.findDictionary();
//        log.info("Dictionary was found");
        Assert.assertTrue("Dictionary was not found", app1.dealPage.findDictionary());

        app1.dealPage.clickOnDictionary();
//        log.info("Dictionary was clicked");
        app1.dealPage.clickSubMenuZapchasti();

        app1.zapchasti.clickOnAddZapchasti();
        log.info("Button ADD ZAPCHASTI was clicked");
        app1.zapchastiEditPage.inputTextIntoSpareName(spareName);
        app1.zapchastiEditPage.selectTextIntoDropDownSpareType(spareType);
        app1.zapchastiEditPage.clickOnButtonCreate();

        //TODO added assert
    }

    @After
    public void tearDown() {
        app1.dealPage.closeDealPageAndBrowser();
    }


}