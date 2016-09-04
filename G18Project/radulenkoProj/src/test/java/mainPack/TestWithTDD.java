package mainPack;

import libs.SpreadsheetData;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;


@RunWith(value = Parameterized.class)
public class TestWithTDD extends Assert{
    Logger log;
    private String firstName;
    private String lastName;


    public TestWithTDD(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        log = Logger.getLogger(getClass());

    }

    @Parameters
    public static Collection testData() throws IOException {
                InputStream spreadsheet = new FileInputStream("src/main/java/testData.xls");
                return new SpreadsheetData(spreadsheet,"test2").getData();
    }

    @Test
    public void test1(){
        log.info("firstName = " + firstName);
        log.info("lastName = " + lastName);
    }

    @After
    public void tearDown(){
    }

}
