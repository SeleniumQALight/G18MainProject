package mainPack.Pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static libs.ConfigData.getCfgValue;

public class LoginPage {
    WebDriver driver;
    Logger log;
    WebDriverWait webDriverWait;

    @FindBy(name = "_username")
    WebElement inputLogin;

    @FindBy(id = "password")
    WebElement inputPassword;

    @FindBy(xpath = ".//button[@type='submit']")
    WebElement buttonSubmit;

    //   @FindBy(xpath = ".//img[contains(@alt,'student')]")
    //   WebElement avatar;

    //construktor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public void openBrowserAndLoginPage() {
        try {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
            driver.get(getCfgValue("SITE_URL") + "login");
            //dobavit dlya kagdoj stranici, gde ispolzuem url

            log.info("Browser and Login page were opened");
        } catch (Exception e) {
            log.error("Can not work with browser or LoginPage" + e);
//            Assert.fail("Can not work with browser or LoginPage")
        }
    }

    public void closeLoginPageAndBrowser() {
        driver.quit();
        log.info("Browser and PageLogin were closed");
    }

    public boolean isLoginPageLoad() {
        try {
            boolean isElementPresent = inputPassword.isDisplayed();

            return isElementPresent;
        } catch (NoSuchElementException e) {
            log.info("No such element");
            return false;

        }
    }

    public LoginPage inputTextIntoLoginField(String text) {
        inputLogin.clear();
        inputLogin.sendKeys(text);
        log.info("'" + text + "' was inputed");
        return new LoginPage(driver);

    }

    public LoginPage inputTextIntoPassField(String pass) {
        inputPassword.clear();
        inputPassword.sendKeys(pass);
        log.info("'" + pass + "' was inputed");
        return new LoginPage(driver);
    }


    public void clickButtonVhod() {
        buttonSubmit.click();
        log.info("Button VHOD was clicked");
    }

}





