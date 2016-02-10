package com.task3.parser;



import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.log4j.Logger;
import com.task3.entity.Gem;
import com.task3.entity.Pavilion;
import java.io.File;
/**
 * 
 * @author Aliona Riabchenko
 * @version 1.0 Build 23.15.2015
 *
 */
public final class MyJAXB {
    private static final String XSD_FILE_PATH = "src/main/resources/Schema.xsd";
    static Logger log = Logger.getLogger(MyDOMParser.class.getName());

    private MyJAXB() {
    }

    public static void marshall(String filePath, Pavilion pav1) {
        try {
            File file = new File(filePath);
            JAXBContext jaxbContext = JAXBContext.newInstance(Pavilion.class, Gem.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XSD_FILE_PATH);
            jaxbMarshaller.marshal(pav1, file);
        } catch (JAXBException e) {
            log.error(e);
        }
    }
}