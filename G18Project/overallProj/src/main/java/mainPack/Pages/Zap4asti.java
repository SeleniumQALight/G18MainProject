package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by QALight on 29.08.2016.
 */
public class Zap4asti {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//a[@href='http://v3.test.itpmgroup.com/dictionary/spares/edit']")
    WebElement addButton;

    public Zap4asti(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        try {
            addButton.click();
            log.info("Button Add was clicked");
        } catch (Exception e) {
            log.error("Can not work with Button Add");
            Assert.fail("Can not work with Button Add");
        }
    }


}










