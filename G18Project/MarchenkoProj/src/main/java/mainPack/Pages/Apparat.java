package mainPack.Pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iris on 29.08.2016.
 */
public class Apparat {
    WebDriver driver;
    Logger log;

    @FindBy(xpath = ".//a[@data-original-title = 'Add']")
    WebElement addButton;

    //constructor
    public Apparat(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        //inicialization
        PageFactory.initElements(driver, this);
    }

    public void clickAddButton() {
        try{
            addButton.click();
            log.info("Button Add is clicked");
        }catch (Exception e) {
            log.error("Can't work with add button");
            Assert.fail("Can't work with add button");
        }
    }


    public boolean isAppartPresentComment(String commentFromTest) {
        try{
            return driver.findElement(By.xpath(".//*[text()='" + commentFromTest + "']")).isDisplayed();
        }catch (Exception e){
            log.info(commentFromTest + " wasn't found");
            return false;
        }
    }
    public boolean isAppartPresentNumber(String numberFromTest) {
        try{
            return driver.findElement(By.xpath(".//*[text()='" + numberFromTest + "']")).isDisplayed();
        }catch (Exception e){
            log.info(numberFromTest + " wasn't found");
            return false;
        }
    }
}
