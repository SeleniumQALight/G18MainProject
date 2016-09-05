package mainPack.Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by QALight on 31.08.2016.
 */
public class App1 {
     WebDriver driver;

    public Apparat apparat;
    public ApparatEdit apparatEdit;
    public HomePage homePage;
    public LoginPage loginPage;

    public App1(WebDriver driver) {
        this.driver = driver;
        apparat = new Apparat(driver);
        apparatEdit = new ApparatEdit(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

    }


}
