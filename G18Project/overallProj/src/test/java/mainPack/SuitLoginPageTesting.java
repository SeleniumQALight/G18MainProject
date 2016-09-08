package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestLogiPageValideWithPageObject.class,
                TestLogiPageNotValideWithPageObject.class
        }
)
public class SuitLoginPageTesting {

}




