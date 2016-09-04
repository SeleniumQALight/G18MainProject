package mainPack;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestLoginPageValideWithPageObject1.class,
        TestLoginPageNotValideWithPageObject1.class

})

public class SuitTestLoginPage {
}
