import org.junit.Assert;
import org.testng.annotations.Test;


public class TestLogin extends TestBase {
    @Test
    public void loginWithValidCreditionals() throws Exception {
        AccountData acc = new AccountData("username", "password");

        app.loginHelper.logout();
        app.loginHelper.login(acc);

        Assert.assertEquals(app.loginHelper.isLoggedIn(acc), true);
    }
}