package mainPack.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by HomeUser on 8/27/2016.
 */
public class ApparatPage {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement awatar;

    @FindBy(xpath = ".//ul/li[@id='dictionary']")
    WebElement dictionary;

    @FindBy(xpath = ".//ul/li[@id='apparat']")
    WebElement subMenuDictionaryAparat;

    @FindBy(xpath = ".//a[@href=\"http://v3.test.itpmgroup.com/dictionary/apparat/edit\"]")
    WebElement addApparat;

    //construktor
    public ApparatPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void clickOnAddApparat() {
        addApparat.click();
        log.info("Addapparat was clicked");
    }

    public boolean isApparatWithCommentPresent(String textOfComment) {
        try {
            return driver.findElement(By.xpath(".//*[text()='" + textOfComment + "']")).isEnabled();

        } catch (ElementNotVisibleException e) {
            log.info("Element with" + textOfComment + "was not found");
            return false;
        }
    }

    public void closeApparatPageAndBrowser() {
        driver.quit();
        log.info("Page Apparat Page and Browser were closed");
    }
}

