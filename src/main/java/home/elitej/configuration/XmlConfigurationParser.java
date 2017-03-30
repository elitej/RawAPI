package home.elitej.configuration;

import home.elitej.exception.XmlConfigurationParseException;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class XmlConfigurationParser {
    private final static List<String> beansInfo = new CopyOnWriteArrayList<>();
    private final static String BEAN_TAG_NAME = "common-bean";
    private final static String FULL_CLASS_NAME_TAG_NAME = "fully-qualified-class-name";


    XmlConfigurationParser(String filePath) {
        parse(filePath);
    }

    List<String> getBeansInfo() {
        return beansInfo;
    }

    private void parse(String filePath) {
        try (InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath)) {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(in);
            findElements(doc);
        } catch (Exception e) {
            throw new XmlConfigurationParseException(e.getMessage(), e);
        }
    }

    private static void findElements(Document doc) {
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String tagName = element.getTagName();
                if (tagName.equals(BEAN_TAG_NAME)) {
                    putBeansInfo(element);
                }
            }
        }
    }

    private static void putBeansInfo(Element bean) {
        NodeList nodes = bean.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element element = (Element) node;
                String tagName = element.getTagName();
                if (tagName.equals(FULL_CLASS_NAME_TAG_NAME)) {
                    Text text = (Text) node.getFirstChild();
                    String fullClassName = text.getData();
                    beansInfo.add(fullClassName);
                }
            }
        }
    }
}
