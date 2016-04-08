import org.openqa.selenium.By;

public class AddressHelper extends HelperBase {

    public AddressHelper(AppManager manager) {
        super(manager);
    }

    public void addAddress(AddressData address) {
        manager.navigationHelper.goToLink("link=Добавить адрес");
        fillTheField("address.name", address.firstName);
        fillTheField("address.surname", address.surname);
        fillTheSelect("address.region", address.region);
        fillTheSelect("address.city", address.cityIso);
        fillTheField("address.line1", address.line1);
        fillTheField("address.phone", address.phone);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }
}
