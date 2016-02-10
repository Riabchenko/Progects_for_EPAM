package com.intellect25.company.model;


import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.entity.interfaceObject.Company;

/**
 * Static value for parsers
 *
 * @author Riabchenko Aliona
 */
public abstract class Parser {
    public static final String ID = "id";
    public static final String START_ELEMENT_HTTP_MNS = "http://com.intellect25.company.resources4/mns"; // "http://www.example.com/mns";
    public static final String PAVILION = "company";
    public static final String MNS = "mns";
    public static final String MNS_ = "mns:";
    public static final String XS = "xs";
    public static final String START_ELEMENT_HTTP_SCHEMA = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XS_LOCATION = "xs:schemaLocation";
    public static final String NAME_XSD = " company.xsd";
    public static final String INFO = "info";
    public static final String MANAGER = "manager";
    public static final String OTHER = "other";
    public static final String WORKER = "worker";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String MIDDLE_NAME = "middleName";
    public static final String BIRTHDAY = "birthday";
    public static final String DAY_JOB = "dateOfGetJob";
    public static final String LIST_WORKER = "listWorkers";
    public static final String WORKER_ID = "workerId";
    public static final String XML_SUCCESS = "XML was built successful";
    public static final String NOT_PATH = "Not found path";


    public abstract NewRequest parse(String path);
    public abstract NewRequest createXML(String filePath, Company company);
}
