package com.intellect25.model;

import com.intellect25.entity.*;

import javax.xml.stream.*;
import java.io.FileOutputStream;
import java.io.StringReader;

/**
 * StAXParser to parse xml documents
 *
 * @author Riabchenko Aliona
 */
public class StAXParser implements StaticValue {

    /**
     * Parse xml document
     *
     * @param xmlAsString input xml as String
     * @return object of Pavilion
     */
    public Pavilion parse(String xmlAsString) {
        ObjectFactory objectFactory = new ObjectFactory();
        String tagContent = null;
        Pavilion pavilion = null;
        Pavilion.Gem gem = null;
        Stone stone = null;
        Visual visual = null;

        /* Create XMLInputFactory */
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;

        try {

            /* Read xml and create XMLStreamReader */
            StringReader stringReader = new StringReader(xmlAsString);
            reader = factory.createXMLStreamReader(stringReader);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        try {
            if (reader != null){
                while (reader.hasNext()) {
                    int event = reader.next();

                    /* Read XMLStreamConstants and create objects */
                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            if (PAVILION.equals(reader.getLocalName())) {
                                pavilion = objectFactory.createPavilion();
                            } else if (GEM.equals(reader.getLocalName())) {
                                gem = objectFactory.createPavilionGem();
                                pavilion.setGem(gem);
                            } else if (STONE.equals(reader.getLocalName())) {
                                stone = objectFactory.createStone();
                                visual = objectFactory.createVisual();
                                stone.setId(new Integer(reader.getAttributeValue(0)));
                                gem.getStone().add(stone);
                            }
                            break;

                        case XMLStreamConstants.CHARACTERS:
                            tagContent = reader.getText().trim();
                            break;

                        case XMLStreamConstants.END_ELEMENT:
                            switch (reader.getLocalName()) {
                                case NAME:
                                    stone.setName(tagContent);
                                    break;
                                case PRECIOUSNESS:
                                    stone.setPreciousness(Preciousness.valueOf(tagContent));
                                    break;
                                case ORIGIN:
                                    stone.setOrigin(tagContent);
                                    break;
                                case COLOR:
                                    visual.setColor(Color.valueOf(tagContent));
                                    break;
                                case TRANSPARENCY:
                                    visual.setTransparency(Integer.parseInt(tagContent));
                                    break;
                                case CUTTING:
                                    visual.setCutting(Integer.parseInt(tagContent));
                                    stone.setVisual(visual);
                                    break;
                                case VALUE:
                                    stone.setValue(new Float(tagContent));
                                    break;
                            }
                            break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return pavilion;
    }

    /**
     * Create XML from object of Pavilion
     *
     * @param filePath path to output xml document
     * @param pavilion input object of Pavilion
     */
    public void createXML(String filePath, Pavilion pavilion) {
        XMLOutputFactory xmlof = XMLOutputFactory.newInstance();
        try {
            XMLStreamWriter xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(filePath));
            xmlw.writeStartDocument();
            xmlw.writeCharacters("\n");
            xmlw.writeStartElement("mns", "pavilion", "http://www.example.com/mns");
            xmlw.writeNamespace("mns", "http://www.example.com/mns");
            xmlw.writeNamespace("xs", "http://www.w3.org/2001/XMLSchema-instance");
            xmlw.writeAttribute("xs:schemaLocation", "http://www.example.com/mns stone.xsd");
            xmlw.writeCharacters("\n");
            xmlw.writeStartElement(GEM);
                for (Stone stone : pavilion.getGem().getStone()) {
                    xmlw.writeStartElement(STONE);
                    xmlw.writeAttribute(ID, String.valueOf(stone.getId()));
                    xmlw.writeStartElement(NAME);
                    xmlw.writeCharacters(stone.getName());
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(PRECIOUSNESS);
                    xmlw.writeCharacters(String.valueOf(stone.getPreciousness()));
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(ORIGIN);
                    xmlw.writeCharacters(String.valueOf(stone.getOrigin()));
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(VISUAL);
                    Visual visual = stone.getVisual();
                    xmlw.writeStartElement(COLOR);
                    xmlw.writeCharacters(visual.getColor().value());
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(TRANSPARENCY);
                    xmlw.writeCharacters(String.valueOf(visual.getTransparency()));
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(CUTTING);
                    xmlw.writeCharacters(String.valueOf(visual.getCutting()));
                    xmlw.writeEndElement();
                    xmlw.writeEndElement();
                    xmlw.writeStartElement(VALUE);
                    xmlw.writeCharacters(String.valueOf(stone.getValue()));
                    xmlw.writeEndElement();
                    xmlw.writeEndElement();
                    xmlw.writeCharacters("\n");
                }

            xmlw.writeEndElement();
            xmlw.writeEndDocument();
            xmlw.close();
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

}
