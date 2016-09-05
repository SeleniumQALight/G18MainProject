package mainPack.Pages;

import org.openqa.selenium.WebDriver;


public class App1 {
    WebDriver driver;
    public ApparatPage apparatPage;
    public ApparatEditPage apparatEditPage;
    public DealPage dealPage;
    public LoginPage loginPage;

    public App1(WebDriver driver) {
        this.driver = driver;
        apparatPage = new ApparatPage(driver);
        apparatEditPage = new ApparatEditPage(driver);
        dealPage = new DealPage(driver);
        loginPage = new LoginPage(driver);
    }

}
