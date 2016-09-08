package mainPack;

import mainPack.Pages.Application;
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
///add parameters
@RunWith(value = Parameterized.class)
public class AddNewApparat {
    WebDriver driver = new ChromeDriver();
    Application app =  new Application(driver);



    /// local variable
    String apparatNumber;
    String commentApparat;

///add  constructor with parametres
    public AddNewApparat (String apparatNumber, String commentApparat){
        this.apparatNumber = apparatNumber;
        this.commentApparat = commentApparat;
    }
    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"VeryLong NameVeryLong NameVeryLong Name IM","VeryLong NameVeryLong NameVeryLong Name IM"},
                {"!@#$%^&*()_IM","!@#$%^&*()_IM",}//,
                //{"","IM"},
                //{"IM",""}
        });
    }


    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }


    @Test
    public void addNewApparat() {
        app.loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage wasn't loaded", app.loginPage.isLoginPageLoad());
        app.loginPage.inputTextInLoginField("student").inputTextinPasswordField("909090").clickButtonVhod();
        Assert.assertTrue("Home page was not loaded", app.homePage.isHomePageLoaded());

        app.homePage.clickDictionaryMenu();
        app.homePage.clickSubMenuApparat();
        app.apparat.clickAddButton();

        app.apparatEdit.inputApparatNumber(apparatNumber);
        app.apparatEdit.inputApparatComment(commentApparat);
        app.apparatEdit.clickButtonCreate();
        Assert.assertTrue("Apparat was not added",app.apparat.isAppartPresentComment(commentApparat));
        Assert.assertTrue("Apparat was not added",app.apparat.isAppartPresentNumber(apparatNumber));
    }

    @After
    //Post-Conditions
    public void tearDown() {

        app.homePage.CloseHomePageAndBrowser();
    }
}
///assertThat(6) isEql (6) - testfail