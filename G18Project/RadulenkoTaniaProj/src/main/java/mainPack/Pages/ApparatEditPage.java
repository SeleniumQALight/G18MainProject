package mainPack.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by HomeUser on 8/27/2016.
 */
public class ApparatEditPage {
    WebDriver driver;
    Logger log;

    @FindBy(id = "apparat_apparatNumber")
    WebElement apparatNumber;

    @FindBy(id = "apparat_apparatComment")
    WebElement apparartComment;

    @FindBy(tagName = "button")
    WebElement buttonCreate;


    //construktor
    public ApparatEditPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void inputTextIntoApparatNumber(String text) {
        apparatNumber.clear();
        apparatNumber.sendKeys(text);
        log.info("Apparart number " + "'" + text + "'" + " was added");

    }

    public void inputTextIntoApparatComment(String text) {
        apparartComment.clear();
        apparartComment.sendKeys(text);
        log.info("Apparat with comment " + "'" + text + "'" + " was added");

    }

    public void clickOnButtonCreate() {
        buttonCreate.click();
        log.info("Button Create was clicked");
    }

}

