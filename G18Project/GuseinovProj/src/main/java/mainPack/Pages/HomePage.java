package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;
    @FindBy(id = "dictionary")
    WebElement dictionary;
    @FindBy(xpath = ".//*[@id='apparat']/a")
    WebElement submenuDictionaryAparat;


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
    public void CloseHomePageAndBrowser(){
        driver.quit();
        log.info("Browser and Home Page were closed");
    }
    public void ClickDictionary() {
        try {
            dictionary.click();
            log.info("Menu dictionary was clicked");
        } catch (Exception e) {
            log.error("Can`t work with Menu dictionary");
            Assert.fail("Can`t work with Menu dictionary");
        }
    }
        public void ClickSubmenuDictionaryApparat(){
            try{
                submenuDictionaryAparat.click();
                log.info("Submenu apparat was clicked");
            }catch (Exception e ){
                log.error("Can`t work with Menu dictionary");
                Assert.fail("Can`t work with Menu dictionary");
            }

    }
    }


