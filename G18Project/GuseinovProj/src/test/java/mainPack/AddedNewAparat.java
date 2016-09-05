package mainPack;

import mainPack.Pages.*;
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
public class AddedNewAparat {
    WebDriver driver = new ChromeDriver();
    App1 app = new App1(driver);
    /**
     * LoginPage loginPage = new LoginPage(driver);
     * HomePage homePage = new HomePage(driver);
     * Apparat apparat = new Apparat(driver);
     * ApparatEdit apparatEdit = new ApparatEdit(driver);
     */
    String apparatNumber;
    String apparatComment;

    public AddedNewAparat(String apparatNumber, String apparatComment) {
        this.apparatNumber = apparatNumber;
        this.apparatComment = apparatComment;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                //  {"555","101010"},
                // {"10101","555"},
                {"101010", ""},
        });
    }

    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }

    @Test
    //Steps
    public void addedNewAparat() {
        app.loginPage.OpenBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", app.loginPage.isLoginPageLoad());
        app.loginPage.inputTextIntoLoginField("student").inputTextIntoPassField("909090").clickButtonVdod();
        Assert.assertTrue("Home page was not loaded", app.homePage.isHomePageLoaded());
        app.homePage.ClickDictionary();
        app.homePage.ClickSubmenuDictionaryApparat();
        app.apparat.clickAddButton();
        app.apparatEdit.inputNewApparatNumber(apparatNumber);
        app.apparatEdit.inputApparatComment(apparatComment);
        app.apparatEdit.clickButtonCreat();
        //Assert.assertTrue("Apparat was not added", app.apparat.isApparatWithCommentPresent(apparatComment));
        Assert.assertFalse("TestFail", app.apparat.isApparatWithCommentPresent(apparatComment));

    }

    //    assertTrue (true) - testpass
    //    assertTrue (false) - testfail
    //    assertFalse (true) - testfail
    //    assertFalse (false) - testpass
    //    assertFail() - testfail
    //    assertThat (6).isEql (6) - testpass
    //    assertThat (5).isEql (6) - testfail
    @After
    //Post-Conditions
    public void tearDown() {
        app.homePage.CloseHomePageAndBrowser();
    }
}
