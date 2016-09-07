package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Iris on 29.08.2016.
 */
public class Zap4astiEdit {
    WebDriver driver;
    Logger log;

    @FindBy(id = "spares_spareName")
    WebElement inputSpareName;

    @FindBy (id = "spares_spareType")
    WebElement ddSpareType;

    @FindBy(xpath = ".//button[@name='add']")
    WebElement buttonCreate;


    //constructor
    public Zap4astiEdit(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        //inicialization
        PageFactory.initElements(driver, this);
    }

    public void inputTextInToSpareName(String spareName){
        try{
            inputSpareName.clear();
            inputSpareName.sendKeys(spareName);
            log.info(spareName + " was entered into input");
        }catch (Exception e){
            log.error("Cannot work with input SpareName");
            Assert.fail("Cannot work with input SpareName");
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


    public void selectTextInToDropDownSpareType(String textSpareType){
        try{
            Select valuesFromDD = new Select(ddSpareType);
            valuesFromDD.selectByVisibleText(textSpareType);
            log.info(textSpareType + " was selected in to DropDown SpareType");

        }catch (Exception e){
            log.error("Cannot work with DropDown");
            Assert.fail("Cannot work with DropDown");
        }

    }
















}