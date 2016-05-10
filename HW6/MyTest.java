import org.testng.annotations.*;
import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Test
public class MyTest extends AuthBase {
    
    @DataProvider
    public Object[][] fromXml(String file, String elements) {
        ArrayList<String> result = new ArrayList<>();
        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName(elements);
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                result.add(new String(element.getElementsByTagName("value").item(0).getTextContent()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[][] obj1 = (Object[][]) result.toArray();
        return obj1;
    }
    
    
    @DataProvider
    public Object[][] namesFromXml() {
        String file = "xml/name.xml";
        String elements = "names";
        return fromXml(file, elements);
    }
    
    @Test(dataProvider = "searchFormFromXml")
    public void searchProduct(String value) {
        app.searchHelper.search(value);
    }
    
    
    @Test(dataProvider = "namesFromXml")
    public void addAddress(String value) {
        app.navigationHelper.goToAccountPage();
        app.navigationHelper.goToAddreddesPage();
        String lastname = generateRandomString(10);
        AddressData address = new AddressData(value, lastname, , "Tatarstan", "Kazan city", "Univercity street", "242-56-23");
        app.addressHelper.addAddress(address);
        
        app.loginHelper.logout();
    }
}