package mainPack;

import mainPack.Pages.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
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
    //LoginPage loginPage = new LoginPage(driver);
    //HomePage homePage = new HomePage(driver);
    //Apparat apparat = new Apparat(driver);
    //ApparatEdit apparatEdit = new ApparatEdit(driver);

    // локальная переменная
    String apparatNumber;
    String commentApparat;

    //эти переменные будем передавать
    public AddedNewAparat(String apparatNumber, String commentApparat) {
        this.apparatNumber = apparatNumber;
        this.commentApparat = commentApparat;
    }

    @Parameterized.Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][]{
                {"55555VK","11"},
                {"11","testKV"}
        });
    }

    @Before
    public void setUp() {

    }

    @Test
    public void addedNewAparat() {
        app.loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", app.loginPage.isLoginPageLoad());

        app.loginPage.inputTextInToLoginField("student").inputTextInToPassField("909090").clickButtonVhod();

        Assert.assertTrue("HomePage was not loaded", app.homePage.isHomePageLoaded());
        app.homePage.clickDictionaryMenu();
        app.homePage.clickSubMenuDictionaryAparat();

        app.apparat.clickAddButton();

        app.apparatEdit.inputApparatNumber(apparatNumber);
        app.apparatEdit.inputApparatComment(commentApparat);
        app.apparatEdit.clickButtonCreate();

        Assert.assertTrue("Apparat was not added", app.apparat.isApparatWithCVommentPresent("AutoTestAparatKorchagina"));
    }

    @After
    public void tearDown() {
        app.homePage.closeHomePageAndBrowser();
    }

}
