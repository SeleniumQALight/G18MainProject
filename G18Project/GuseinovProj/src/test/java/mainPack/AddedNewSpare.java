package mainPack;

import mainPack.Pages.App1;
import org.jboss.netty.util.ThreadNameDeterminer;
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
public class AddedNewSpare {
    WebDriver driver = new ChromeDriver();
    App1 app = new App1(driver);
    /**
     * LoginPage loginPage = new LoginPage(driver);
     * HomePage homePage = new HomePage(driver);
     * Apparat apparat = new Apparat(driver);
     * ApparatEdit apparatEdit = new ApparatEdit(driver);
     */
    String spareName;
    String spareType;

    public AddedNewSpare(String spareName, String spareType) {
        this.spareName = spareName;
        this.spareType = spareType;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                //  {"555","101010"},
                // {"10101","555"},
                {"test", "Механика"},
        });
    }

    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }

    @Test
    //Steps
    public void addedNewSpare() {
        app.loginPage.OpenBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", app.loginPage.isLoginPageLoad());
        app.loginPage.inputTextIntoLoginField("student").inputTextIntoPassField("909090").clickButtonVdod();
        Assert.assertTrue("Home page was not loaded", app.homePage.isHomePageLoaded());
        app.homePage.ClickDictionary();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.homePage.clickSubmenuZap4asti();
        app.zap4asti.clickAddButton();
        app.zap4astiEdit.inputTextIntoSpareName(spareName);
        app.zap4astiEdit.selectTextFromDropDownSpareType(spareType);
        app.zap4astiEdit.clickButtonCreat();
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
