
package com.intellect25.company.entity.object;

import com.intellect25.company.entity.interfaceObject.Worker;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for workerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="workerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://com.intellect25.company.resources4/mns}employee">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "workerType", namespace = "http://com.intellect25.company.resources4/mns")
public class WorkerType
    extends EmployeeImpl implements Worker
{


}
