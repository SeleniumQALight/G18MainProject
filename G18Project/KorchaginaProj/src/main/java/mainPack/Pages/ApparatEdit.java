package mainPack.Pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
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

    public void inputApparatNumber(String number) {
        try {
            apparatNumber.clear();
            apparatNumber.sendKeys(number);
            log.info(number + " was entered");
        }catch (Exception e){
            log.error("Can not work with Number field");
            Assert.fail("Can not work with Number field");
        }
    }

    public void inputApparatComment(String comment) {
        try {
            apparatComment.clear();
            apparatComment.sendKeys(comment);
            log.info(comment + " was entered");
        }catch (Exception e) {
            log.error("Can not work with Comment field");
            Assert.fail("Can not work with Comment field");
        }
    }

    public void clickButtonCreate() {
        try {
            buttonCreate.click();
            log.info("Button Create was cliked");
        }catch (Exception e){
            log.error("Can not work with button Create");
            Assert.fail("Can not work with button Create");
        }
    }
}
