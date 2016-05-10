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

    public boolean isLoggedIn(){
        return isElementPresent(By.id("logout"));
    }

    public boolean isLoggedIn(AccountData account){
        return isLoggedIn() && (getUserName() == account.login);
    }

    public String getUserName() {
        manager.navigationHelper.goToAccountPage();
        String text = driver.findElements(By.tagName("tr")).get(3).findElements(By.tagName("tr")).get(2).getText();
        return text;
    }

}
