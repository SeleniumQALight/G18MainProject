package mainPack;

import mainPack.Pages.Apparat;
import mainPack.Pages.ApparatEdit;
import mainPack.Pages.HomePage;
import mainPack.Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Iris on 22.08.2016.
 */
public class AddNewApparat {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Apparat apparat = new Apparat(driver);
    ApparatEdit apparatEdit = new ApparatEdit(driver);

    @Before
    public void setUp() {
        //Tut mojno sapisat Pre Condition
    }


    @Test
    public void addNewApparat() {
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage wasn't loaded", loginPage.isLoginPageLoad());
        loginPage.inputTextInLoginField("student").inputTextinPasswordField("909090").clickButtonVhod();
        Assert.assertTrue("Home page was not loaded", homePage.isHomePageLoaded());

        homePage.clickDictionaryMenu();
        homePage.clickSubMenuApparat();
        apparat.clickAddButton();

        apparatEdit.inputApparatNumber("444");
        apparatEdit.inputApparatComment("AutotestApparat_Marchenko");
        apparatEdit.clickButtonCreate();
        Assert.assertTrue("Apparat was not added",apparat.isAppartPresentComment("AutotestApparat_Marchenko"));
    }

    @After
    //Post-Conditions
    public void tearDown() {

        homePage.CloseHomePageAndBrowser();
    }
}