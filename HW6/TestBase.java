import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class TestBase {
    protected AppManager app;
    protected StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    protected void setUp() throws Exception {
        app = new AppManager();
        app.driver.manage().window().maximize();
        app.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        app.navigationHelper.goToHomePage();
        app.loginHelper.login(new AccountData("username", "password"));
    }

    @AfterClass(alwaysRun = true)
    protected void tearDown() throws Exception {
        app.Stop();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


}
