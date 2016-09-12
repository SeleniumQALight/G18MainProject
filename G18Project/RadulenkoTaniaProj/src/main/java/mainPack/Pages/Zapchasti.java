package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zapchasti {
    WebDriver driver;
    Logger log;
    WebDriverWait webDriverWait;

    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement awatar;

    @FindBy(xpath = ".//ul/li[@id='dictionary']")
    WebElement dictionary;

    @FindBy(xpath = ".//ul/li[@id='apparat']")
    WebElement subMenuDictionaryAparat;

    @FindBy(xpath = ".//*[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    WebElement addZapchasti;

    //construktor
    public Zapchasti(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
        webDriverWait = new WebDriverWait(driver, 30);
    }

    public void clickOnAddZapchasti() {
        try {
//            webDriverWait.until(ExpectedConditions.elementToBeClickable(addZapchasti));
            addZapchasti.click();
            log.info("Zapchasti was clicked");
        }catch (Exception e){
            log.error("Can not work with Add zapchasti" );
            Assert.fail("Can not work with Add zapchasti");
        }
    }



    public void closeZapchastiAndBrowser() {
        driver.quit();
        log.info("Page Zapchasti Page and Browser were closed");
    }
}

