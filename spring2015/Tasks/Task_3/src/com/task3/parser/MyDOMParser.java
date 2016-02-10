package com.task3.parser;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import com.task3.entity.Gem;
import com.task3.entity.Pavilion;
import com.task3.entity.VisualParameters;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 23.15.2015
 *
 */
public final class MyDOMParser {
    static Logger log = Logger.getLogger(MyDOMParser.class.getName());

    private MyDOMParser() {
    }

    private static Element getBaby(Element parent, String childName) {
        NodeList nlist = parent.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);
        return child;
    }

    private static String getBabyValue(Element parent, String childName) {
        Element child = getBaby(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();
        return value;
    }

    public static Pavilion parse(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            log.error(e);
        }
        Document document = null;
        try {
            document = builder.parse(xmlFile);
        } catch (SAXException e) {
            log.error(e);
        } catch (IOException e) {
            log.error(e);
        }

        List<Gem> gemList = new ArrayList<>();
        NodeList gemsNodes = document.getDocumentElement().getElementsByTagName("gem");
        VisualParameters visualParameters;
        for (int i = 0; i < gemsNodes.getLength(); i++) {
            Gem gem = new Gem();
            Element gemElement = (Element) gemsNodes.item(i);
            gem.setId(gemElement.getAttribute("id"));
            gem.setName(getBabyValue(gemElement, "name"));
            gem.setValue(new Double(getBabyValue(gemElement, "value")));
            visualParameters = new VisualParameters();
            Element visualParametersElement = getBaby(gemElement, "visualParameters");
            visualParameters.setColor(getBabyValue(visualParametersElement, "color"));
            visualParameters.setTransparency(new Integer(getBabyValue(visualParametersElement, "transparency")));
            visualParameters.setGemCutting(new Integer(getBabyValue(visualParametersElement, "gemCutting")));
            gem.setVisualParameters(visualParameters);
            gemList.add(gem);
        }
        return new Pavilion(gemList);
    }
}

