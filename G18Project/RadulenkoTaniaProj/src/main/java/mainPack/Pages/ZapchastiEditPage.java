package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ZapchastiEditPage {
    WebDriver driver;
    Logger log;

    @FindBy(id = "spares_spareName")
    WebElement inputSpareName;

    @FindBy(tagName = "button")
    WebElement buttonCreate;

    @FindBy(id = "spares_spareType")
    WebElement ddSpareType;

    //construktor
    public ZapchastiEditPage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public void inputTextIntoSpareName(String spareName) {
        try {
            inputSpareName.clear();
            inputSpareName.sendKeys(spareName);
            log.info(spareName + "was entered into input");
        } catch (Exception e) {
            log.error("Can't work with Input");
            Assert.fail("Can't work with Input");
        }
    }
    public void clickOnButtonCreate() {
        try {
            buttonCreate.click();
            log.info("Button Create was clicked");
        } catch (Exception e) {
            log.error("Can't click");
            Assert.fail("Can't click");
        }
    }

    public void selectTextIntoDropDownSpareType(String textSpareType) {
        try {
            Select valuesFromDD = new Select(ddSpareType);
            valuesFromDD.selectByVisibleText(textSpareType);
            log.info("TextSpearType was selected into DropDowm SpareType");
        } catch (Exception e) {
            log.error("Can't work with DropDowm");
            Assert.fail("Can't work with DropDowm");
        }
    }


}

