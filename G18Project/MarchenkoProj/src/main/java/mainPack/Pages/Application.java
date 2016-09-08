package mainPack.Pages;

import org.openqa.selenium.WebDriver;

/** This Class will create all Pages
 * Created by Iris on 31.08.2016.
 */
public class Application {
    WebDriver driver;
    public Apparat apparat;
    public ApparatEdit apparatEdit;
    public HomePage homePage;
    public LoginPage loginPage;

    public Application(WebDriver driver){
        this.driver = driver;
        apparat = new Apparat(driver);
        apparatEdit = new ApparatEdit(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);

    }
}
