package mainPack;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Test1 extends Assert{
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Test1(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    @Parameters
    public static Collection testData() {
        return Arrays.asList(new Object[][] {
                { "TesterFname1", "TesterLName1", "email1@email.com", "password" },
                { "TesterFname2", "TesterLName2", "email2@email.com", "password" },
                { "TesterFname3", "TesterLName3", "email3@email.com", "password" },
                { "TesterFname4", "TesterLName4", "email4@email.com", "password" } });
    }

    @Test
    public void test1(){
        System.out.println("New test par1 = " + firstName + " , par2 = " + lastName);
        Assert.assertTrue("assert  works", true);
        assertEquals("Assert works ",firstName,"TesterFname1");
    }

}
