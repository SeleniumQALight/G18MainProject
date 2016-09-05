package mainPack.Pages;

import org.junit.Assert;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparatEdit {

    WebDriver driver;
    Logger log;

    @FindBy(id = "apparat_apparatNumber")
    WebElement apparatNumber;
    @FindBy(id = "apparat_apparatComment")
    WebElement apparatComment;
    @FindBy(xpath = ".//button[@name='add']")
    WebElement buttonCreate;


    public ApparatEdit(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void inputNewApparatNumber(String number) {
        try {
            apparatNumber.clear();
            apparatNumber.sendKeys(number);
            log.info(number + " Number was inputed");
        } catch (Exception e) {
            log.error("Can not work was number field");
            Assert.fail("Can not work was number field");
        }
    }

    public void inputApparatComment(String comment) {
        try {
            apparatComment.clear();
            apparatComment.sendKeys(comment);
            log.info(comment + " Comment was inputed");
        } catch (Exception e) {
            log.error("Can not work was comment field");
            Assert.fail("Can not work was comment field");
        }
    }

    public void clickButtonCreat() {
        try {
            buttonCreate.click();
            log.info("Button 'Creat' was clicked");
        } catch (Exception e) {
            log.error("Can not work with Add Button");
            Assert.fail("Can not work with Add Button");
        }
    }
}
