
package com.tracking.adminoperationssoap.trackingservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="awb" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "awb"
})
@XmlRootElement(name = "registerPackageRequest", namespace = "http://spring.io/guides/gs-producing-web-service")
public class RegisterPackageRequest {

    @XmlElement(namespace = "http://spring.io/guides/gs-producing-web-service")
    protected int awb;

    /**
     * Gets the value of the awb property.
     * 
     */
    public int getAwb() {
        return awb;
    }

    /**
     * Sets the value of the awb property.
     * 
     */
    public void setAwb(int value) {
        this.awb = value;
    }

}
