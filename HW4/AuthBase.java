import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;


public class AuthBase extends TestBase {

    @BeforeClass(alwaysRun = true)
    protected void setUp() throws Exception {
        app.loginHelper.login(new AccountData("username", "password"));
    }
}