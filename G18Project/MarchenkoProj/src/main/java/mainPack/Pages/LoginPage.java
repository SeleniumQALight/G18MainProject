package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by Iris on 22.08.2016.
 */
public class LoginPage {
    WebDriver driver;
    Logger log;

    ///all elements for PageFactory
    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(name="_username")
    WebElement inputUsername;

    @FindBy(xpath = ".//button[@type = 'submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;

    //constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        //initialization of objects in @FindBy
        PageFactory.initElements(driver, this);
    }

    //methods
    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            log.info("Browser and Login page was opened");
        } catch (Exception e) {
            log.error("can not work with browser or LoginPage");
            Assert.fail();
        }
    }

    public void closeLoginPageAndBrowser() {
        driver.quit();
        log.info("Browser and page Login were closed");
    }

    public boolean isLoginPageLoad() {
        try {
            return inputPassword.isDisplayed();
        } catch (NoSuchElementException e) {
            log.info("No such element");
            return false;
        }
    }
public LoginPage inputTextInLoginField(String text){
    inputUsername.clear();
    inputUsername.sendKeys(text);
    log.info(text + " was input");
    //will return new object (smth can be appear) - will refresh page!!!
    return new LoginPage(driver);
}
    public LoginPage inputTextinPasswordField(String text){
        inputPassword.clear();
        inputPassword.sendKeys(text);
        log.info(text + " was input");
        return new LoginPage(driver);
    }
    public void clickButtonVhod(){
        buttonSubmit.click();
        log.info("Button VHOD was clicked");
    }

}


