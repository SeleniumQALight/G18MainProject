package mainPack.Pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Zap4astiEdit {

    WebDriver driver;
    Logger log;

    //  @FindBy(id = "apparat_apparatNumber")
    // WebElement apparatNumber;
    //@FindBy(id = "apparat_apparatComment")
    //WebElement apparatComment;
    @FindBy(xpath = ".//button[@name='add']")
    WebElement buttonCreate;
    @FindBy(id = "spares_spareName")
    WebElement inputSpareName;
    @FindBy(id = "spares_spareType")
    WebElement ddSpareType;

    public Zap4astiEdit(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    /*  public void inputNewApparatNumber(String number) {
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
  */

    public void inputTextIntoSpareName(String spareName){
        try{
            inputSpareName.clear();
            inputSpareName.sendKeys(spareName);
            log.info(spareName+" was entered into input");
        }catch(Exception e){
            log.error("Cannot work with SpareName");
            Assert.fail("Cannot work with SpareName");
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
    public void selectTextFromDropDownSpareType(String textSpareType){
        try
        {
            Select valueFromDD = new Select(ddSpareType);
            valueFromDD.selectByVisibleText(textSpareType);
        log.info("TextSpare was selected from dd");
        }catch(Exception e){
            log.info("Cannot work with dropdown");
            Assert.fail("Cannot work with dropdown");
        }
    }
}
