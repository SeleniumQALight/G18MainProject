package mainPack;

import org.junit.Assert;
import org.junit.Test;

public class Test2 {

    @Test
    public void test2(){
        System.out.println("New test Radulenko2");
        Assert.assertTrue("assert  works1", true);
    }

    @Test
    public void test21(){
        System.out.println("New test Radulenko21");
        Assert.assertTrue("assert  works1", false);
    }
}
