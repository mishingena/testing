import org.openqa.selenium.By;

public class LoginHelper extends HelperBase {

    public LoginHelper(AppManager manager) {
        super(manager);
    }

    public void login(AccountData user) {
        manager.navigationHelper.goToLoginPage();
        fillTheField("name=USER_LOGIN", user.login);
        fillTheField("name=USER_PASSWORD", user.password);
        manager.navigationHelper.button("button.login-button");
    }

    public void logout() {
        manager.navigationHelper.button("button.logout-button");
    }

}
