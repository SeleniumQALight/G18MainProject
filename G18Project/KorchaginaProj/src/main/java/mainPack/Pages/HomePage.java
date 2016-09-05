package mainPack.Pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']")
    WebElement dictionary;

    @FindBy(xpath = ".//*[@id='apparat']/a")
    WebElement subMenuDictionaryAparat;


    public HomePage(WebDriver driver) {

        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageLoaded() {
        try {
            return avatar.isDisplayed();
        } catch (ElementNotVisibleException e) {
            return false;
        }

    }

    public void closeHomePageAndBrowser() {
        driver.quit();
    }

    public void clickDictionaryMenu(){
        try {
            dictionary.click();
        log.info("Menu dictionary was clicked");
    }catch (Exception e) {
            log.error("Can not work Menu dictionary");
            Assert.fail("Can not work Menu dictionary");
        }}

public void clickSubMenuDictionaryAparat(){
    try {
    subMenuDictionaryAparat.click();
        log.info("SubMenuDictionary Apparat was clicked");
    }catch (Exception e){
        log.info("Can not work Sub Menu dictionary Apparat");
                Assert.fail("Can not work Sub Menu dictionary Apparat");
    }
    }
    }
