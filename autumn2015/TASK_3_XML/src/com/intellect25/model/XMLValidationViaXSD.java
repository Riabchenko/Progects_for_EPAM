package com.intellect25.model;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * XMLValidationViaXSD to compare xml document with xsd document
 *
 * @author Riabchenko Aliona
 */
public final class XMLValidationViaXSD {

    /**
     * Compare xml document with xsd document
     * and return result of validation
     *
     * @param pathXml path to XML
     * @param pathXsd path to XSD
     * @return true or false
     */
    public boolean validate(String pathXml, String pathXsd) {
        try {
            File xml = new File(pathXml);
            File xsd = new File(pathXsd);
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(pathXsd));
            Validator validator = schema.newValidator();
            try {
                validator.validate(new StreamSource(pathXml));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
    }

}