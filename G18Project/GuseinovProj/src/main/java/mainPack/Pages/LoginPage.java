package mainPack.Pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
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
    WebElement inputPassword;
    @FindBy(xpath = ".//button[@type='submit']")
    WebElement buttonSubmit;
    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;

    //Constructure
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void OpenBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://v3.test.itpmgroup.com/login");
            log.info("Browser and Login Page were opened");
        } catch (Exception e) {
            log.error("Could not open browser or login page" + e);
            Assert.fail("Could not open browser or login page");
        }
    }

    public void CloseLoginPageAndWidnow() {
        driver.quit();
        log.info("Browser and Login Page were closed");
    }

    public boolean isLoginPageLoad() {
        try {
            boolean isElementPresent = inputPassword.isDisplayed();
            return isElementPresent;
        } catch (NoSuchElementException e) {
            log.info("No sush Element");
            return false;
        }
    }
    public LoginPage inputTextIntoLoginField(String text){
        inputLogin.clear();
        inputLogin.sendKeys(text);
        log.info(text+" Text was inputed");
        return new LoginPage(driver);
    }
    public LoginPage inputTextIntoPassField(String pass){
        inputPassword.clear();
        inputPassword.sendKeys(pass);
        log.info(pass+" Pass was inputed");
        return new LoginPage(driver);
    }
    public void clickButtonVdod(){
        buttonSubmit.click();
        log.info("Button VHOD was clicked");
    }

}

