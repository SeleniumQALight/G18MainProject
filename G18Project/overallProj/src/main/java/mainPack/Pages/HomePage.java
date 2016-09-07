 package mainPack.Pages;

        import org.apache.log4j.Logger;
        import org.junit.Assert;
        import org.openqa.selenium.ElementNotVisibleException;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

/**
 * Created by Iris on 29.08.2016.
 */
public class HomePage {
    WebDriver driver;
    Logger log;
    @FindBy(xpath = ".//img[contains(@alt,'student')]")
    WebElement avatar;
    @FindBy(xpath = ".//*[@id='dictionary']//*[@class = 'fa fa-book']")
    WebElement dictionary;
    @FindBy(xpath = ".//*[@id='apparat']/a")
    WebElement subMenuApparat;
    @FindBy(xpath = ".//*[@href='/dictionary/spares]'//a" )
    WebElement subMenuZap4asti;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        log = Logger.getLogger(getClass());
        PageFactory.initElements(driver, this);
    }

    public boolean isHomePageLoaded() {
        try {
            return avatar.isDisplayed();
        } catch (ElementNotVisibleException e) {
            return false;
        }
    }

    public void CloseHomePageAndBrowser() {
        driver.quit();
        log.info("Browser and Home Page were closed");
    }
    public void clickDictionaryMenu(){
        try{
            dictionary.click();
            log.info("menu dictionary was clicked");
        }catch (Exception e){
            log.error("can't work with dictionary menu");
            Assert.fail("can't work with dictionary menu");
        }
    }
    public void clickSubMenuApparat(){
        try{
            subMenuApparat.click();
            log.info("SubMenuApparat was clicked");
        }catch (Exception e){
            log.error("can't work with SubMenuApparat");
            Assert.fail("can't work with SubMenuApparat");
        }
    }

    public  void clickSubMenuZap4asti(){
        try{
            subMenuZap4asti.click();
            log.info("SubMenuZap4asti was clicked");
        }catch (Exception e){
            log.error("can't work with SubMenuZap4asti");
            Assert.fail("can't work with SubMenuZap4asti");
        }
    }
}