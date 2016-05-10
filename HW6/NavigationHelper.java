import org.openqa.selenium.By;

public class NavigationHelper extends HelperBase {

    private String baseUrl;

    public NavigationHelper(AppManager manager, String baseUrl) {
        super(manager);
        this.baseUrl = baseUrl;
    }

    public void goToHomePage() {
        driver.get(baseUrl);
    }

    public void goToLoginPage() {
        goToLink("link=Авторизация");
    }

    public void goToAddreddesPage() {
        goToLink("link=Адрес")
    }

    public void goToAccountPage() {
        goToLink("link=Профиль");
    }

    public void button(String selector) {
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void goToLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }


}
