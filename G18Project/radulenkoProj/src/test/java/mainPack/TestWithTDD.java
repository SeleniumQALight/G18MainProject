package mainPack;

import libs.SpreadsheetData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class TestWithTDD extends Assert{
    Logger log;
    private String firstName;
    private String lastName;
    private double valueOfDouble;
    WebDriver driver;


    public TestWithTDD(String firstName, String lastName, double valueOfDouble) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.valueOfDouble = valueOfDouble;
        log = Logger.getLogger(getClass());

    }

    @Parameters
    public static Collection testData() throws IOException {
                InputStream spreadsheet = new FileInputStream("src/main/java/testData.xls");
                return new SpreadsheetData(spreadsheet,"test1").getData();
    }

    @Test
    public void test1(){
        driver = new ChromeDriver();
        driver.get("http:/qalight.com.ua");
        log.info("driver was opened");
        driver.quit();
        log.info("firstName = " + firstName);
        log.info("lastName = " + lastName);
        log.info("Double = " + valueOfDouble);
    }

    @After
    public void tearDown(){
    }

}
