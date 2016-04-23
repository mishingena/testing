import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Settings {
    private Element baseConfig;

    public Settings() {
        try {
            File fxmlFile = new File("settings.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fxmlFile);
            document.getDocumentElement().normalize();
            NodeList nList = document.getElementsByTagName("Constant");
            Node node = nList.item(0);
            baseConfig = (Element) node;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getPassword() {
        return baseConfig.getElementsByTagName("Password").item(0).getTextContent();
    }

    public String getLogin() {
        return baseConfig.getElementsByTagName("Login").item(0).getTextContent();
    }

    public String getBaseUrl() {
        return baseConfig.getElementsByTagName("BaseUrl").item(0).getTextContent();
    }

    public static void main(String []args){
        Settings s = new Settings();
        System.out.println(s.getBaseUrl());
    }
}