import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {

    protected WebDriver driver;
    protected AppManager manager;

    public HelperBase(AppManager manager) {
        this.manager = manager;
        driver = manager.driver;
    }

    public void fillTheField (String field, String value) {
        driver.findElement(By.id(field)).clear();
        driver.findElement(By.id(field)).sendKeys(value);
    }

    public void fillTheSelect(String field, String value) {
        new Select(driver.findElement(By.id(field))).selectByVisibleText(value);
    }
}
