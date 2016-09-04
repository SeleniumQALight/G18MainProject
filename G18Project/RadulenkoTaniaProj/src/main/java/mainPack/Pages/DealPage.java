package mainPack.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by HomeUser on 8/27/2016.
 */
public class DealPage {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;

    @FindBy(xpath = ".//ul/li[@id='dictionary']")
    WebElement dictionary;

    @FindBy(xpath = ".//ul/li[@id='apparat']")
    WebElement subMenuDictionaryApparat;

  //  @FindBy(xpath = ".//a[@href=\"http://v3.test.itpmgroup.com/dictionary/apparat/edit\"]")
  //  WebElement addAparat

    //construktor
    public DealPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public boolean isLogOn() {
        try {
            return avatar.isDisplayed();

        } catch (ElementNotVisibleException e) {
            log.error("Avatar was not found, so You are not Log On");
            return false;
        }
    }
//vozmogno lishnij metod, mogno prosto clickOnDictionary
    public boolean findDictionary() {
        try {
            return dictionary.isDisplayed();

        } catch (ElementNotVisibleException e) {
            log.error("Dictionary was not found");
            return false;
        }
    }


    public void clickOnDictionary(){
        dictionary.click();
        log.info("Dictionary was clicked");
    }

    //versiya Tarasa
    //public void clickDictionaryMenu(){
    // try{
    //dictionary.click();
    //log.info("Menu dictionary was clicked");
    // }catch (Exception e){
    // log.error ("Can't work with Menu dictionary");
    // Assert.fail("Can't work Menu dictionary")
    // }
    // }

    public void clickOnSubMenuDictionaryAparat(){
        subMenuDictionaryApparat.click();
        log.info("SubMenuDictionaryApparat was clicked");
    }

    public void closeDealPageAndBrowser() {
        driver.quit();
        log.info("Page Deal and Browser were closed");
    }
}

