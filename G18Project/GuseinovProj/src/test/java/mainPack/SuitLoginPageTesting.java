package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestLoginPageValidWithPageObject.class,
                TestLoginPageNotValidWithPageObject.class

        }
)
public class SuitLoginPageTesting {
}
