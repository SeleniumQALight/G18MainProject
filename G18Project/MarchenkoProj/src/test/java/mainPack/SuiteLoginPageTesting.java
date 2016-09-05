package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Iris on 05.09.2016.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                TestLoginPageInvalidWithPageObject.class,
                TestLoginPageValidWithPageObject.class
        }
)
public class SuiteLoginPageTesting {
}
