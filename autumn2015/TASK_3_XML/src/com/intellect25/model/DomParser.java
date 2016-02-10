package com.intellect25.model;

import com.intellect25.entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * DomParser to parse xml documents
 *
 * @author Riabchenko Aliona
 */
public class DomParser implements StaticValue {

    /**
     * Parse xml document
     *
     * @param file input xml document
     * @return object of Pavilion
     */
    public Pavilion parse(File file) {

        /* Create objects of Pavilion and Gem */
        ObjectFactory factory = new ObjectFactory();
        Pavilion pavilion = factory.createPavilion();
        Pavilion.Gem gem = factory.createPavilionGem();
        Visual visual = null;

        try {

            /* Create document and element root from file */
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            Element root = document.getDocumentElement();

            /* Create node list by tag name STONE */
            NodeList gemNodes = root.getElementsByTagName(STONE);

            /* Create objects of Stone with all parameters them */
            for (int i = 0; i < gemNodes.getLength(); i++) {
                Stone stone = factory.createStone();
                Element stoneElement = (Element) gemNodes.item(i);
                stone.setId(Integer.parseInt(stoneElement.getAttribute(ID)));
                stone.setName(getBabyValue(stoneElement, NAME));
                stone.setOrigin(getBabyValue(stoneElement, ORIGIN));
                stone.setValue(new Float(getBabyValue(stoneElement, VALUE)));
                stone.setPreciousness(Preciousness.valueOf(getBabyValue(stoneElement, PRECIOUSNESS)));

                visual = factory.createVisual();
                Element visualElement = getBaby(stoneElement, VISUAL);
                visual.setColor(Color.valueOf(getBabyValue(visualElement, COLOR)));
                visual.setCutting(new Integer(getBabyValue(visualElement, CUTTING)));
                visual.setTransparency(new Integer(getBabyValue(visualElement, TRANSPARENCY)));
                stone.setVisual(visual);

                /* Add stone to object Gem */
                gem.getStone().add(stone);
            }

            /* Add object Get to object Pavilion*/
            pavilion.setGem(gem);

        } catch (SAXException | ParserConfigurationException |IOException e) {
            e.printStackTrace();
        }
        return pavilion;
    }

    /**
     * Helper for get child value
     *
     * @param parent parent of child
     * @param childName name of child
     * @return value
     */
    private String getBabyValue(Element parent, String childName) {
        Element baby = getBaby(parent, childName);
        Node node = baby.getFirstChild();
        return node.getNodeValue();
    }

    /**
     * Helper for get Child from parent
     *
     * @param parent element of parent
     * @param childName name of child
     * @return element of child
     */
    private Element getBaby(Element parent, String childName) {
        NodeList nodeList = parent.getElementsByTagName(childName);
        return (Element) nodeList.item(0);
    }
}
