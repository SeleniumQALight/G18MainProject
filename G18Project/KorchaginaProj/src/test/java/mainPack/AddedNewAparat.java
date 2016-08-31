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


public class AddedNewAparat {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    Apparat apparat = new Apparat(driver);
    ApparatEdit apparatEdit = new ApparatEdit(driver);

    @Before
    public void setUp() {

    }

    @Test
    public void addedNewAparat() {
        loginPage.openBrowserAndLoginPage();
        Assert.assertTrue("LoginPage was not loaded", loginPage.isLoginPageLoad());

        loginPage.inputTextInToLoginField("student").inputTextInToPassField("909090").clickButtonVhod();

        Assert.assertTrue("HomePage was not loaded", homePage.isHomePageLoaded());
        homePage.clickDictionaryMenu();
        homePage.clickSubMenuDictionaryAparat();

        apparat.clickAddButton();

        apparatEdit.inputApparatNumber("44444");
        apparatEdit.inputApparatComment("AutoTestAparatKorchagina");
        apparatEdit.clickButtonCreate();

        Assert.assertTrue("Apparat was not added", apparat.isApparatWithCVommentPresent("AutoTestAparatKorchagina"));
    }

    @After
    public void tearDown() {
        homePage.closeHomePageAndBrowser();
    }

}
