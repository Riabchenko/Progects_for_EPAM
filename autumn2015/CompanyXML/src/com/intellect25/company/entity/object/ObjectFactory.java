
package com.intellect25.company.entity.object;

import com.intellect25.company.controller.sesionRequest.NewRequest;
import com.intellect25.company.controller.sesionRequest.NewRequestImpl;
import com.intellect25.company.entity.interfaceObject.Company;
import com.intellect25.company.entity.interfaceObject.Employee;
import com.intellect25.company.entity.interfaceObject.ListWorkers;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.intellect25.company.entity4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
    private static ObjectFactory objectFactory;
    private final static QName _Company_QNAME = new QName("http://com.intellect25.company.resources4/mns", "company");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.intellect25.company.entity4
     * 
     */
    private ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompanyType }
     * 
     */
    public Company createCompanyType() {
        return new CompanyType();
    }

    public static ObjectFactory getInstance(){
        if (objectFactory == null)
            objectFactory = new ObjectFactory();
        return objectFactory;
    }

    public Employee createEmployee(TypeEmployee type){
        switch (type){
            case MANAGER:
                return new ManagerType();
            case WORKER:
                return new WorkerType();
            case OTHER:
                return new OtherType();

            default:
                throw new NullPointerException("");
        }
    }

    public ListWorkers createListWorkers() {
        return new ListWorkersImpl();
    }
    public NewRequest createResult() {
        return new NewRequestImpl();
    }


}
