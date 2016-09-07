package mainPack;

import libs.SpreadsheetData;
import mainPack.Pages.App1;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Iris on 22.08.2016.
 */
@RunWith(value = Parameterized.class)
public class AddNewApparatWithDataFromExcel {
    WebDriver driver = new ChromeDriver();
    App1 app = new App1(driver);

    String apparatNumber;
    String commentApparat;

    public AddNewApparatWithDataFromExcel(String apparatNumber, String commentApparat){
        super();
        this.apparatNumber = apparatNumber;
        this.commentApparat = commentApparat;
    }


    @Parameterized.Parameters
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream("src/main/java/testData.xls");
        return new SpreadsheetData(spreadsheet,"test1").getData();
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

//        Assert.assertTrue("Apparat was not added",app.apparat.isAppartPresentComment("AutotestApparat_Marchenko"));
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