import org.junit.Assert;
import org.testng.annotations.Test;


public class TestLogin extends TestBase {
    @Test
    public void loginWithValidCreditionals() throws Exception {
        AccountData account = new AccountData("username", "password");

        app.loginHelper.logout();
        app.loginHelper.login(account);

        Assert.assertEquals(app.loginHelper.isLoggedIn(account), true);
    }

    @Test
    public void logout() throws Exception {
        app.loginHelper.logout();

        Assert.assertEquals(app.loginHelper.isLoggedIn(), false);
    }
}