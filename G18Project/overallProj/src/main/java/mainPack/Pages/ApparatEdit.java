package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iris on 29.08.2016.
 */
public class ApparatEdit {
    WebDriver driver;
    Logger log;

    @FindBy(id ="apparat_apparatNumber")
    WebElement apparatNumber;
    @FindBy(id = "apparat_apparatComment")
    WebElement apparatComment;
    @FindBy(xpath = ".//button[@name='add']")
    WebElement buttonCreate;


    //constructor
    public ApparatEdit (WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        //inicialization
        PageFactory.initElements(driver, this);
    }


    public void inputApparatNumber(String number) {
        try{
            //clear field
            apparatNumber.clear();
            apparatNumber.sendKeys(number);
            log.info(number + " was entered");
        }catch (Exception e){
            log.error("Cannot work with number field");
            Assert.fail("Cannot work with number field");
        }
    }

    public void inputApparatComment(String comment) {
        try{
            //clear field
            apparatComment.clear();
            apparatComment.sendKeys(comment);
            log.info(comment+ " was entered");
        }catch (Exception e){
            log.error("Cannot work with comment field");
            Assert.fail("Cannot work with comment field");
        }
    }

    public void clickButtonCreate() {
        try{
            buttonCreate.click();
            log.info("button create is clicked");
        }catch (Exception e){
            log.error("Cannot click add button");
            Assert.fail("Cannot click add button");

        }
    }
}