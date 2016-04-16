import org.openqa.selenium.By;

public class AddressHelper extends HelperBase {

    public AddressHelper(AppManager manager) {
        super(manager);
    }

    public void addAddress(AddressData address) {
        OpenAdrressPage();
        fillAddressForm(address);
        SubmitAddress();
    }

    public void fillAddressForm(AddressData address) {
        fillTheField("address.firstName", address.firstName);
        fillTheField("address.surname", address.surname);
        fillTheSelect("address.region", address.region);
        fillTheSelect("address.cityIso", address.cityIso);
        fillTheField("address.line1", address.line1);
        fillTheField("address.phone", address.phone);
    }

    public void SubmitAddress() {
        driver.findElement(By.xpath("(//button[@type='address-submit'])")).click();
    }

    public void OpenAdrressPage() {
        manager.navigationHelper.goToLink("link=Добавить адрес");
    }
}
