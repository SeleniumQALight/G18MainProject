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

/**
 * Created by Iris on 22.08.2016.
 */
@RunWith(value = Parameterized.class)
public class AddNewSpare {
    WebDriver driver = new ChromeDriver();
    App1 app = new App1(driver);

    String spareName;
    String spareType;

    public AddNewSpare(String spareName, String spareType){
        this.spareName = spareName;
        this.spareType = spareType;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                {"testName","Механика"}
        });
    }



    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }


    @Test
    public void addNewSpare() {
        app.loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage wasn't loaded", app.loginPage.isLoginPageLoad());
        app.loginPage.inputTextInLoginField("student").inputTextinPasswordField("909090").clickButtonVhod();
        Assert.assertTrue("Home page was not loaded", app.homePage.isHomePageLoaded());

        app.homePage.clickDictionaryMenu();
        app.homePage.clickSubMenuZap4asti();
        app.zap4asti.clickAddButton();
        app.zap4astiEdit.inputTextInToSpareName(spareName);
        app.zap4astiEdit.selectTextInToDropDownSpareType(spareType);
        app.zap4astiEdit.clickButtonCreate();

        //TODO add assert

    }

    @After
    //Post-Conditions
    public void tearDown() {

        app.homePage.CloseHomePageAndBrowser();
    }
}