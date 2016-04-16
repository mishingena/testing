import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppManager {
    private String baseUrl;
    protected WebDriver driver;
    protected LoginHelper loginHelper;
    protected NavigationHelper navigationHelper;
    protected AddressHelper addressHelper;
    protected StringBuffer verificationErrors = new StringBuffer();
    protected boolean acceptNextAlert = true;

    public AppManager() {
        driver = new FirefoxDriver();
        baseUrl = "https://www.iguides.ru/";
        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        addressHelper = new AddressHelper(this);
    }


    @AfterClass(alwaysRun = true)
    protected void Stop() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public static AppManager getInstance (){
        if (app == null) {
            AppManager newInstance = new AppManager();
            newInstance.navigationHelper.goToHomePage();
            app.set(newInstance);
        }
        return app.get();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public AddressHelper getAddressHelper() {
        return addressHelper;
    }

    public void setAddressHelper(AddressHelper addressHelper) {
        this.addressHelper = addressHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void setNavigationHelper(NavigationHelper navigationHelper) {
        this.navigationHelper = navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public void setLoginHelper(LoginHelper loginHelper) {
        this.loginHelper = loginHelper;
    }
}
