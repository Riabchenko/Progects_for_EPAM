package com.intellect25.model;

import com.intellect25.entity.*;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * SaxParser to parse xml documents
 *
 * @author Riabchenko Aliona
 */
public class SaxParser implements StaticValue{

    /** Create objects of Pavilion, Gem, Visual, Stone */
    private ObjectFactory factory = new ObjectFactory();
    private Pavilion pavilion;
    private Pavilion.Gem gem;
    private Stone stone;
    private Visual visual;

    /** Store name of current input the element*/
    private String temp;

    /** It shows the current position of the element */
    boolean isStone = false;

    /**
     * Parse xml documents
     *
     * @param in path of inputs xml documents
     * @return object of Pavilion
     */
    public Pavilion parse(String in) {
        try{
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SaxHandler contentHandler = new SaxHandler();
            reader.setContentHandler(contentHandler);
            reader.parse(new InputSource(in));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return pavilion;
    }

    /**
     * Inner class SaxHandler that implements ContentHandler
     * to parse xml documents
     */
    class SaxHandler implements ContentHandler {

        @Override
        public void setDocumentLocator(Locator locator) {

        }

        @Override
        public void startDocument()  {
            pavilion = factory.createPavilion();
            gem = factory.createPavilionGem();
        }

        @Override
        public void endDocument(){
            pavilion.setGem(gem);
        }

        @Override
        public void startPrefixMapping(String s, String s1){

        }

        @Override
        public void endPrefixMapping(String s) {

        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            temp = qName;
            if (qName.equals(STONE)) {
                stone = factory.createStone();
                visual = factory.createVisual();
                stone.setId(new Integer(attributes.getValue(ID)));
                isStone = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName){
            if (isStone) {
                stone.setVisual(visual);
                gem.getStone().add(stone);
            }
            isStone = false;
            temp = "";
        }

        @Override
        public void characters(char[] chars, int start, int length){
                switch (temp) {
                    case NAME:
                        stone.setName(new String(chars, start, length));
                        break;
                    case PRECIOUSNESS:
                        stone.setPreciousness(Preciousness.valueOf(new String(chars, start, length)));
                        break;
                    case ORIGIN:
                        stone.setOrigin(new String(chars, start, length));
                        break;
                    case COLOR:
                        visual.setColor(Color.valueOf(new String(chars, start, length)));
                        break;
                    case TRANSPARENCY:
                        visual.setTransparency(new Integer(new String(chars, start, length)));
                        break;
                    case CUTTING:
                        visual.setCutting(new Integer(new String(chars, start, length)));
                        stone.setVisual(visual);
                        break;
                    case VALUE:
                        stone.setValue(new Float(new String(chars, start, length)));
                        break;
                }
        }

        @Override
        public void ignorableWhitespace(char[] chars, int i, int i1){

        }

        @Override
        public void processingInstruction(String s, String s1){

        }

        @Override
        public void skippedEntity(String s) {

        }
    }

}
