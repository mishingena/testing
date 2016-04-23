import org.testng.annotations.*;

public class MyTest extends TestBase {

    @Test
    public void test() throws Exception {
        app.navigationHelper.goToLoginPage()
        app.navigationHelper.goToAccountPage();
        app.navigationHelper.goToAddreddesPage();
        AddressData address = new AddressData("Name", "Surname", "Tatarstan", "Kazan city", "Univercity street", "242-56-23");
        app.addressHelper.addAddress(address);
        app.loginHelper.logout();
    }
}
