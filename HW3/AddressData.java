public class AddressData {
    String firstName;
    String surname;
    String region;
    String cityIso;
    String line1;
    String postcode;
    String phone;

    public AddressData(String firstName, String surname, String region, String cityIso, String line1, String phone) {
        this.firstName = firstName;
        this.surname = surname;
        this.region = region;
        this.cityIso = cityIso;
        this.line1 = line1;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCityIso() {
        return cityIso;
    }

    public void setCityIso(String cityIso) {
        this.cityIso = cityIso;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
