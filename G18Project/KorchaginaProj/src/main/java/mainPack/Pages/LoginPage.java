package mainPack.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    WebDriver driver;
    Logger log;

    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(id = "password")
    WebElement inputPasword;

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement buttonSubmit;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);

    }

    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            log.info("Browser and Login page were opened");
        } catch (Exception e) {
            log.error("Can't work with browser or login page");
            // Assert.fail("Can't work with browser or login page" + e);
        }
    }

    public void closeLoginPageAndBrowser() {
        driver.quit();
        log.info("Browser ans=d PageLogin were closed");
    }

    public boolean isLoginPageLoad() {
        try {
            boolean isElementPresent = inputPasword.isDisplayed();
            return isElementPresent;
        } catch (NoSuchElementException e) {
            log.info("No such element");
            return false;

        }
    }



    public LoginPage inputTextInToLoginField(String text) {
        inputLogin.clear();
        inputLogin.sendKeys(text);
        log.info(text + " was imputed");
        return new LoginPage(driver);

    }
    public LoginPage inputTextInToPassField(String pass){
        inputPasword.clear();
        inputPasword.sendKeys(pass.toString());
        log.info(pass + " was inputed");
        return new LoginPage(driver);

    }
    public void clickButtonVhod(){
        buttonSubmit.click();
        log.info("Button Vhod was clicked");
    }
}
